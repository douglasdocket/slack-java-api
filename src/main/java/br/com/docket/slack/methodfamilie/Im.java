package br.com.docket.slack.methodfamilie;

import br.com.docket.slack.api.WebAPI;

public class Im {
	public Im() {
		WebAPI.slackBuilder.url("im");
	}
	
    /**
     * Método para criar uma conversa do sistema com o usuario
     * 
     * @param user - String (Id do usuario a ser criado o channel)
	 * @throws IOException 
     */
	public ImOpen open(String user){
		return new ImOpen(user);
	}

	public class ImOpen extends AbstractMethod {
		public ImOpen(String user) {
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


