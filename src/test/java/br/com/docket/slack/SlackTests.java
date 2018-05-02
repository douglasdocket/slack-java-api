package br.com.docket.slack;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import com.google.gson.JsonObject;

import br.com.docket.slack.api.WebAPI;

public class SlackTests {
	
	@Test
	public void webApiTesting() throws IOException {
		WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));

		JsonObject jsonObject = webApi.users().lookupByEmail("SEU_EMAIL").execute();
		String userSlakeId = jsonObject.getAsJsonObject("user").get("id").getAsString();
		
		jsonObject = webApi.im().open(userSlakeId).execute();
		String channelSlakeId = jsonObject.getAsJsonObject("channel").get("id").getAsString();
		
		webApi.chat().postMessage(channelSlakeId, "Ola mano").execute();
		
		FileInputStream fs = new FileInputStream("/home/user/Área de Trabalho/p8_b2c1321.png");
		webApi.files().upload().file(fs, "docket.png").channels(channelSlakeId).filename("docket.png").filetype("png").title("Teste").execute();
		
		standardValidations(jsonObject);
	}
	
	@Test
	public void webApiTestingImOpen() {
    	WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));
    	JsonObject jsonObject = null;
    	try {
    		jsonObject = webApi.im().open("SEU_ID_USER").execute();
		} catch (IOException e) {
			fail();
		}
		
		standardValidations(jsonObject);
	}
	
	@Test
	public void webApiTestingChatPostMessage() {
    	WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));
    	JsonObject jsonObject = null;
    	try {
    		jsonObject = webApi.chat().postMessage("SEU_ID_CHANNEL", "Ola mano").execute();
		} catch (IOException e) {
			fail();
		}
		
		standardValidations(jsonObject);
	}

	@Test
	public void webApiTestingUsersLookUpByEmail() {
    	WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));
    	JsonObject jsonObject = null;
    	try {
    		jsonObject = webApi.users().lookupByEmail("SEU_EMAIL").execute();
		} catch (IOException e) {
			fail();
		}
		
		standardValidations(jsonObject);
	}
	
	@Test
	public void webApiTestingFilesUpload() {
    	WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));
    	JsonObject jsonObject = null;
    	try {
    		FileInputStream fs = new FileInputStream("/home/user/Área de Trabalho/p8_b2c1321.png");
    		jsonObject = webApi
    				.files()
    				.upload()
    				.file(fs, null)
    				.channels("DAEV8P6LE")
    				.filename("docket.png")
    				.filetype("png")
    				.title("teste")
    				.execute();
		} catch (IOException e) {
			fail();
		}
		
		standardValidations(jsonObject);
	}

	private void standardValidations(JsonObject jsonObject) {
		assertNotNull(jsonObject);
		assertNotEquals(jsonObject.get("ok").getAsString(), "false");
	}
}
