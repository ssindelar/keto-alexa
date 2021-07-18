package de.sindelar.skill.requesthandlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;
import com.google.common.primitives.Doubles;

public class KVCalcRequestHandler implements RequestHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(KVCalcRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("KVCalcIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
    	Slot fat = Slots.getSlot(handlerInput, Slots.FAT);
    	Slot kh = Slots.getSlot(handlerInput, Slots.KH);
    	Slot protein = Slots.getSlot(handlerInput, Slots.PROTEIN);
    	ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();
    	return handle(responseBuilder, Doubles.tryParse(fat.getValue()), Doubles.tryParse(kh.getValue()), Doubles.tryParse(protein.getValue()));
    }
    
    Optional<Response> handle(ResponseBuilder responseBuilder, Double fat, Double kh, Double protein){
    	if(fat == null || kh == null || protein == null) {
    		return responseBuilder
                    .withSpeech("Es wurden leider nicht alle Werte verstanden. Bitte probiere es erneut.")
                    .build();
    	}
    	double kv = fat / (kh + protein);
    	LOGGER.info("keto calc: {}/{}/{} -> {}", fat, kh, protein, kv);
    	String speech = String.format(Locale.GERMAN, "%.1f", kv);
    	String cardText = String.format(Locale.GERMAN, "%.1fg Fett, %.1fg Kohlenhydrate und %.1fg haben eine ketogenes Verhältnis von %.1f." , fat, kh, protein, kv);
    	return responseBuilder
                .withSpeech(speech)
                .withSimpleCard("Ketogenes Verhältnis", cardText)
                .build();
    }
}