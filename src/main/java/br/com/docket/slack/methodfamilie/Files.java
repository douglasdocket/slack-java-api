package br.com.docket.slack.methodfamilie;

import java.io.FileInputStream;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Method;

import br.com.docket.slack.api.WebAPI;

public class Files {

	public Files() {
		WebAPI.slackBuilder.url("files");
	}

	public FilesUpload upload() {
		return new FilesUpload();
	}
	
	public class FilesUpload extends AbstractMethod {
		public FilesUpload() {
			WebAPI.slackBuilder.url(".upload");
			WebAPI.slackBuilder.method(Method.POST);
		}

		public FilesUpload channels(String channels) {
			WebAPI.slackBuilder.addParam("channels", channels);
			return this;
		}

		public FilesUpload content(String content) {
			WebAPI.slackBuilder.addParam("content", content);
			return this;
		}

		public FilesUpload file(FileInputStream file, String name) {
			if(file != null && !StringUtils.isEmpty(name)) {
				WebAPI.slackBuilder.file(file, name);
			}
			return this;
		}

		public FilesUpload filename(String filename) {
			WebAPI.slackBuilder.addParam("filename", filename);
			return this;
		}

		public FilesUpload filetype(String filetype) {
			WebAPI.slackBuilder.addParam("filetype", filetype);
			return this;
		}

		public FilesUpload initialComment(String initialComment) {
			WebAPI.slackBuilder.addParam("initial_comment", initialComment);
			return this;
		}

		public FilesUpload title(String title) {
			WebAPI.slackBuilder.addParam("title", title);
			return this;
		}
	}
}
