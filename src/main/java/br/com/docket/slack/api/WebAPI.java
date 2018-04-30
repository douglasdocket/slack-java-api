package br.com.docket.slack.api;

import br.com.docket.slack.methodfamilie.Chat;
import br.com.docket.slack.methodfamilie.Im;

public class WebAPI {
	public static SlackBuilder slackBuilder;
	
	public WebAPI(String authorization) {
		slackBuilder = new SlackBuilder();
		slackBuilder.authorization(authorization);
		slackBuilder.baseUrl("https://slack.com/api/");
	}
	
	public Im im() {
		return new Im();
	}
	
	public Chat chat() {
		return new Chat();
	}
}
