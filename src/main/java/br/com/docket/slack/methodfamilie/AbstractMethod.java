package br.com.docket.slack.methodfamilie;

import java.io.IOException;

import com.google.gson.JsonObject;

import br.com.docket.slack.api.WebAPI;

public abstract class AbstractMethod {
	public JsonObject execute() throws IOException {
		return WebAPI.slackBuilder.build();
	}
}
