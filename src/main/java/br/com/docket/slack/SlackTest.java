package br.com.docket.slack;

import java.io.FileInputStream;
import java.io.IOException;

import br.com.docket.slack.api.WebAPI;

public class SlackTest {

    public static void main(String[] args) throws IOException {
    	WebAPI webApi = new WebAPI(System.getProperty("slackApiKey"));
//    	System.out.println(webApi.im().open("UA2HUT77Y").execute());
//    
//    	System.out.println(webApi.chat().postMessage("DAEV8P6LE", "Ola mano").execute());
    	
//    	System.out.println(webApi.users().lookupByEmail("richard.souza@docket.com.br").execute());
//    	
//    	FileInputStream fs = new FileInputStream("/home/richard/Área de Trabalho/p8_b2c1321.png");
//    	
//    	System.out.println(
//    			webApi
//    				.files()
//    				.upload()
//    				.file(fs, "docket.png")
//    				.channels("DAEV8P6LE")
//    				.filename("docket.png")
//    				.filetype("png")
//    				.title("teste")
//    				.execute());
    }
}
