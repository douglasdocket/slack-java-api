package br.com.docket.slack.methodfamilie;

import br.com.docket.slack.api.WebAPI;
import org.jsoup.Connection.Method;

import java.io.IOException;

public class Conversations {

	public Conversations() {
		WebAPI.slackBuilder.url("conversations");
	}
	
    /**
     * Método para criar uma conversa com o usuario
     * 
     * @param user - String (Id do usuario a ser criado o channel)
	 * @throws IOException
     */
	public ConversationsOpen open(String user) {
		return new ConversationsOpen(user);
	}

	public class ConversationsOpen extends AbstractMethod {
		public ConversationsOpen(String user) {
			WebAPI.slackBuilder.method(Method.POST);
			WebAPI.slackBuilder.addParam("users", user);
			WebAPI.slackBuilder.url(".open");
		}
	
		public ConversationsOpen includeLocale(Boolean includeLocale) {
			WebAPI.slackBuilder.addParam("include_locale", includeLocale.toString());
			return this;
		}
	
		public ConversationsOpen returnIm(Boolean returnIm) {
			WebAPI.slackBuilder.addParam("return_im", returnIm.toString());
			return this;
		}
	}
}


