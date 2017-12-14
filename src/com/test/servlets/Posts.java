package com.test.servlets;

public class Posts {
	String content;
	int sid;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Posts(String content, int sid) {
		super();
		this.content = content;
		this.sid = sid;
	}
	public Posts() {
		super();
	}
	@Override
	public String toString() {
		return "Posts [content=" + content + ", sid=" + sid + "]";
	}
	
	
	
	

}
