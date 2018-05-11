package br.com.docket.slack.methodfamilie;

import java.io.IOException;

import br.com.docket.slack.api.WebAPI;

public class Users {

	public Users() {
		WebAPI.slackBuilder.url("users");
	}
	
    /**
     * Método para buscar as informações do usuário slack
     * 
     * @param email - email do usuário a ser retornado
	 * @throws IOException 
     */
	public UsersLookupByEmail lookupByEmail(String email) {
		return new UsersLookupByEmail(email);
	}
	
	public class UsersLookupByEmail extends AbstractMethod {
		public UsersLookupByEmail(String email) {
			WebAPI.slackBuilder.addParam("email", email);
			WebAPI.slackBuilder.url(".lookupByEmail");
		}
	}
}
