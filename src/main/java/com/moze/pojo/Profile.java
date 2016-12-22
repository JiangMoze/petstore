package com.moze.pojo;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class Profile {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLangpref() {
		return langpref;
	}
	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}
	public String getFavcategory() {
		return favcategory;
	}
	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}
	private String langpref;
	private String favcategory;
}
