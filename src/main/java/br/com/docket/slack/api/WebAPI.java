package br.com.docket.slack.api;

import br.com.docket.slack.methodfamilie.Chat;
import br.com.docket.slack.methodfamilie.Conversations;
import br.com.docket.slack.methodfamilie.Files;
import br.com.docket.slack.methodfamilie.Im;
import br.com.docket.slack.methodfamilie.Users;

public class WebAPI {

	public static SlackBuilder slackBuilder;
	
	public WebAPI(String authorization) {
		slackBuilder = new SlackBuilder();
		slackBuilder.authorization(authorization);
		slackBuilder.baseUrl("https://slack.com/api/");
	}
	
	public Chat chat() {
		return new Chat();
	}

	/**
	 * Método para obter funções de IM do slack
	 *
	 * @deprecated depois da versão 0.0.2, substituido por {@link #conversations()}
	 *
	 * @return {@link Im}
	 */
	@Deprecated
	public Im im() {
		return new Im();
	}
	
	public Files files() {
		return new Files();
	}
	
	public Users users() {
		return new Users();
	}

	public Conversations conversations() {
		return new Conversations();
	}
}
