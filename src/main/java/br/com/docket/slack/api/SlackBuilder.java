package br.com.docket.slack.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SlackBuilder {
	private String authorization;
	private String baseUrl;
	private StringBuilder url;
	private Method method;
	private List<Connection.KeyVal> params;
	private Map<String, String> headers;
	
	public SlackBuilder() {
		resetValues();
	}
	
	public SlackBuilder authorization(String authorization) {
		this.authorization = "Bearer " + authorization;
		return this;
	}

	public SlackBuilder baseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
		return this;
	}
	
	public SlackBuilder url(String url) {
		this.url.append(url);
		return this;
	}

	public SlackBuilder method(Method method) {
		this.method = method;
		return this;
	}

	public SlackBuilder addParam(String key, String value) {
        this.params.add(HttpConnection.KeyVal.create(key, value));
		return this;
	}

	public SlackBuilder addHeader(String key, String value) {
		this.headers.put(key, value);
		return this;
	}
	
	private void resetValues() {
		url = new StringBuilder();
		method = Connection.Method.GET;
		params = new ArrayList<Connection.KeyVal>();
		headers = new HashMap<String, String>();
	}

	public JsonObject build() throws IOException{
		this.headers.put("Authorization", authorization);
		
		Connection.Response response = Jsoup.connect(baseUrl + url.toString())
						                .ignoreContentType(true)
						                .ignoreHttpErrors(true)
						                .headers(headers)
						                .method(method)
						                .data(params)
						                .execute();
		resetValues();

        return new Gson().fromJson(response.body(), JsonObject.class);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SlackBuilder [authorization=");
		builder.append(authorization);
		builder.append(", baseUrl=");
		builder.append(baseUrl);
		builder.append(", url=");
		builder.append(url);
		builder.append(", method=");
		builder.append(method);
		builder.append(", params=");
		builder.append(params);
		builder.append(", headers=");
		builder.append(headers);
		builder.append("]");
		return builder.toString();
	}
}

