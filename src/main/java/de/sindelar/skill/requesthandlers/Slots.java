package de.sindelar.skill.requesthandlers;

import java.util.Map;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Slot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Slots {
	FAT("Fett"), KH("Kohlenhydrate"), PROTEIN("Eiweiss");
	
	private final String name;
	
	public static Slot getSlot(HandlerInput handlerInput, Slots slot) {
		 IntentRequest intentRequest = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
    	 Map<String, Slot> slots = intentRequest.getIntent().getSlots();
    	 return slots.get(slot.name);
	}

}
