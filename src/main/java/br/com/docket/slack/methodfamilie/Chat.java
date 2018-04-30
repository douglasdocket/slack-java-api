package br.com.docket.slack.methodfamilie;

import br.com.docket.slack.api.WebAPI;

public class Chat {
	public Chat() {
		WebAPI.slackBuilder.url("chat");
	}

    /**
     * Método para enviar uma mensagem a um channel
     * 
     * @param channel - String (Id do channel a ser enviada a mensagem)
     * @param text - String (O texto a enviado na mensagem)
	 * @throws IOException 
     * @throws InvalidAttributeValueException 
     */
	public ChatPostMessage postMessage(String channel, String text) {
		return new ChatPostMessage(channel, text);
	}
	
	public class ChatPostMessage extends AbstractMethod {
		public ChatPostMessage(String channel, String text) {
			WebAPI.slackBuilder.addParam("channel", channel);
			WebAPI.slackBuilder.addParam("text", text);
			WebAPI.slackBuilder.url(".postMessage");
		}
	
		public ChatPostMessage asUser(Boolean asUser) {
			WebAPI.slackBuilder.addParam("as_user", asUser.toString());
			return this;
		}
	
		public ChatPostMessage attachments(String attachments) {
			WebAPI.slackBuilder.addParam("attachments", attachments);
			return this;
		}
		
		public ChatPostMessage iconEmoji(String iconEmoji) {
			WebAPI.slackBuilder.addParam("icon_emoji", iconEmoji);
			return this;
		}
		
		public ChatPostMessage iconUrl(String iconUrl) {
			WebAPI.slackBuilder.addParam("icon_url", iconUrl);
			return this;
		}
		
		public ChatPostMessage linkNames(Boolean linkNames) {
			WebAPI.slackBuilder.addParam("link_names", linkNames.toString());
			return this;
		}
		
		public ChatPostMessage mrkdwn(Boolean mrkdwn) {
			WebAPI.slackBuilder.addParam("mrkdwn", mrkdwn.toString());
			return this;
		}
		
		public ChatPostMessage parse(String parse) {
			WebAPI.slackBuilder.addParam("parse", parse);
			return this;
		}
		
		public ChatPostMessage replyBroadcast(Boolean replyBroadcast) {
			WebAPI.slackBuilder.addParam("reply_broadcast", replyBroadcast.toString());
			return this;
		}
		
		public ChatPostMessage threadTs(Double threadTs) {
			WebAPI.slackBuilder.addParam("thread_ts", threadTs.toString());
			return this;
		}
		
		public ChatPostMessage unfurlLinks(Boolean unfurlLinks) {
			WebAPI.slackBuilder.addParam("unfurl_links", unfurlLinks.toString());
			return this;
		}
		
		public ChatPostMessage unfurlMedia(Boolean unfurlMedia) {
			WebAPI.slackBuilder.addParam("unfurl_media", unfurlMedia.toString());
			return this;
		}
		
		public ChatPostMessage username(String username) {
			WebAPI.slackBuilder.addParam("username", username);
			return this;
		}
	}
}
