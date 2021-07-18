package de.sindelar.skill.requesthandlers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.amazon.ask.model.Response;
import com.amazon.ask.model.ui.SsmlOutputSpeech;
import com.amazon.ask.response.ResponseBuilder;

class KVCalcRequestHandlerTest {

	@Test
	void testHandleResponseBuilderDoubleDoubleDouble() {
		KVCalcRequestHandler handler = new KVCalcRequestHandler();
		ResponseBuilder responseBuilder = new ResponseBuilder();
		Optional<Response> optResponse = handler.handle(responseBuilder, 10d, 4d, 6d);
		assertThat(optResponse).isNotEmpty();
		Response response = optResponse.get();
		SsmlOutputSpeech speech = (SsmlOutputSpeech) response.getOutputSpeech();
		assertThat(speech.getSsml()).contains("1,0");
	}

}
