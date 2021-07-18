package de.sindelar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.amazon.lambda.test.LambdaClient;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class LambdaHandlerTest {

    @Test
    public void skillInputStreamSuccess() {
        try {
            String input = "{\r\n" + 
            		"  \"version\": \"1.0\",\r\n" + 
            		"  \"session\": {\r\n" + 
            		"    \"new\": true,\r\n" + 
            		"    \"sessionId\": \"amzn1.echo-api.session.123456789012\",\r\n" + 
            		"    \"application\": {\r\n" + 
            		"      \"applicationId\": \"amzn1.ask.skill.78cd0b60-9683-418f-9c12-dcf22b7f1f72\"\r\n" + 
            		"    },\r\n" + 
            		"    \"user\": {\r\n" + 
            		"      \"userId\": \"amzn1.ask.account.testUser\"\r\n" + 
            		"    },\r\n" + 
            		"    \"attributes\": {}\r\n" + 
            		"  },\r\n" + 
            		"  \"context\": {\r\n" + 
            		"    \"AudioPlayer\": {\r\n" + 
            		"      \"playerActivity\": \"IDLE\"\r\n" + 
            		"    },\r\n" + 
            		"    \"System\": {\r\n" + 
            		"      \"application\": {\r\n" + 
            		"        \"applicationId\": \"amzn1.ask.skill.78cd0b60-9683-418f-9c12-dcf22b7f1f72\"\r\n" + 
            		"      },\r\n" + 
            		"      \"user\": {\r\n" + 
            		"        \"userId\": \"amzn1.ask.account.testUser\"\r\n" + 
            		"      },\r\n" + 
            		"      \"device\": {\r\n" + 
            		"        \"supportedInterfaces\": {\r\n" + 
            		"          \"AudioPlayer\": {}\r\n" + 
            		"        }\r\n" + 
            		"      }\r\n" + 
            		"    }\r\n" + 
            		"  },\r\n" + 
            		"  \"request\": {\r\n" + 
            		"    \"type\": \"LaunchRequest\",\r\n" + 
            		"    \"requestId\": \"amzn1.echo-api.request.1234\",\r\n" + 
            		"    \"timestamp\": \"2016-10-27T18:21:44Z\",\r\n" + 
            		"    \"locale\": \"en-US\"\r\n" + 
            		"  }\r\n" + 
            		"}";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            LambdaClient.invoke(inputStream, outputStream);

            ByteArrayInputStream out = new ByteArrayInputStream(outputStream.toByteArray());
            StringBuilder response = new StringBuilder();
            int i = 0;
            while ((i = out.read()) != -1) {
                response.append((char)i);
            }

            Assertions.assertTrue(response.toString().contains("Keto"));
        } catch (Exception e) {
        	e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }
    
    @Test
    public void kvCalcRequestTest() {
        try {
            String input = "{\r\n" + 
            		"  \"version\": \"1.0\",\r\n" + 
            		"  \"session\": {\r\n" + 
            		"    \"new\": true,\r\n" + 
            		"    \"sessionId\": \"amzn1.echo-api.session.123456789012\",\r\n" + 
            		"    \"application\": {\r\n" + 
            		"      \"applicationId\": \"amzn1.ask.skill.78cd0b60-9683-418f-9c12-dcf22b7f1f72\"\r\n" + 
            		"    },\r\n" + 
            		"    \"user\": {\r\n" + 
            		"      \"userId\": \"amzn1.ask.account.testUser\"\r\n" + 
            		"    },\r\n" + 
            		"    \"attributes\": {}\r\n" + 
            		"  },\r\n" + 
            		"  \"context\": {\r\n" + 
            		"    \"AudioPlayer\": {\r\n" + 
            		"      \"playerActivity\": \"IDLE\"\r\n" + 
            		"    },\r\n" + 
            		"    \"System\": {\r\n" + 
            		"      \"application\": {\r\n" + 
            		"        \"applicationId\": \"amzn1.ask.skill.78cd0b60-9683-418f-9c12-dcf22b7f1f72\"\r\n" + 
            		"      },\r\n" + 
            		"      \"user\": {\r\n" + 
            		"        \"userId\": \"amzn1.ask.account.testUser\"\r\n" + 
            		"      },\r\n" + 
            		"      \"device\": {\r\n" + 
            		"        \"supportedInterfaces\": {\r\n" + 
            		"          \"AudioPlayer\": {}\r\n" + 
            		"        }\r\n" + 
            		"      }\r\n" + 
            		"    }\r\n" + 
            		"  },\r\n" + 
            		"  \"request\": {\r\n" + 
            		"		\"type\": \"IntentRequest\",\r\n" + 
            		"		\"requestId\": \"amzn1.echo-api.request.884ad78a-4aec-4495-9227-ef80c3ea5177\",\r\n" + 
            		"		\"locale\": \"de-DE\",\r\n" + 
            		"		\"timestamp\": \"2020-09-17T08:17:17Z\",\r\n" + 
            		"		\"intent\": {\r\n" + 
            		"			\"name\": \"KVCalcIntent\",\r\n" + 
            		"			\"confirmationStatus\": \"NONE\",\r\n" + 
            		"			\"slots\": {\r\n" + 
            		"				\"Eiweiss\": {\r\n" + 
            		"					\"name\": \"Eiweiss\",\r\n" + 
            		"					\"value\": \"4\",\r\n" + 
            		"					\"confirmationStatus\": \"NONE\",\r\n" + 
            		"					\"source\": \"USER\"\r\n" + 
            		"				},\r\n" + 
            		"				\"Kohlenhydrate\": {\r\n" + 
            		"					\"name\": \"Kohlenhydrate\",\r\n" + 
            		"					\"value\": \"6\",\r\n" + 
            		"					\"confirmationStatus\": \"NONE\",\r\n" + 
            		"					\"source\": \"USER\"\r\n" + 
            		"				},\r\n" + 
            		"				\"Fett\": {\r\n" + 
            		"					\"name\": \"Fett\",\r\n" + 
            		"					\"value\": \"20\",\r\n" + 
            		"					\"confirmationStatus\": \"NONE\",\r\n" + 
            		"					\"source\": \"USER\"\r\n" + 
            		"				}\r\n" + 
            		"			}\r\n" + 
            		"		},\r\n" + 
            		"		\"dialogState\": \"COMPLETED\"\r\n" + 
            		"	}" + 
            		"}";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            LambdaClient.invoke(inputStream, outputStream);

            ByteArrayInputStream out = new ByteArrayInputStream(outputStream.toByteArray());
            StringBuilder response = new StringBuilder();
            int i = 0;
            while ((i = out.read()) != -1) {
                response.append((char)i);
            }

            Assertions.assertTrue(response.toString().contains("Keto"));
        } catch (Exception e) {
        	e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }
    
    


}
