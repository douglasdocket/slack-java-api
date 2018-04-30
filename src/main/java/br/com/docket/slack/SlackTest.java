package br.com.docket.slack;

import java.io.IOException;

import br.com.docket.slack.api.WebAPI;

public class SlackTest {

    public static void main(String[] args) throws IOException {
    	WebAPI webApi = new WebAPI("xoxb-354791830342-eVbiNPc9HWOYmHhK9r1O1slZ");
    	System.out.println(webApi.im().open("UA2HUT77Y").execute());
    
    	System.out.println(webApi.chat().postMessage("DAEV8P6LE", "Ola mano").execute());
    }
}
