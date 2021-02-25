package br.com.docket.slack.methodfamilie;

import org.jsoup.Connection.Method;

import br.com.docket.slack.api.WebAPI;

import java.io.IOException;

public class Im {

	public Im() {
		WebAPI.slackBuilder.url("im");
	}

	/**
	 * Método para criar uma conversa com o usuario
	 *
	 * @deprecated depois da versão 0.0.2, substituido por {@link Conversations#open(String)}
	 *
	 * @param user String (Id do usuario a ser criado o channel)
	 * @throws IOException
	 * */
	@Deprecated
	public ImOpen open(String user) {
		return new ImOpen(user);
	}

	public class ImOpen extends AbstractMethod {
		public ImOpen(String user) {
			WebAPI.slackBuilder.method(Method.POST);
			WebAPI.slackBuilder.addParam("user", user);
			WebAPI.slackBuilder.url(".open");
		}
	
		public ImOpen includeLocale(Boolean includeLocale) {
			WebAPI.slackBuilder.addParam("include_locale", includeLocale.toString());
			return this;
		}
	
		public ImOpen returnIm(Boolean returnIm) {
			WebAPI.slackBuilder.addParam("return_im", returnIm.toString());
			return this;
		}
	}
}


