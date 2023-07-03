package org.com.design;

import java.sql.Timestamp;

public class DesignDTO {
	private int num;
	private String author;
	private String typename;
	private String title;
	private String content;
	private String password;
	private Timestamp writedate;
	private int readcnt;
	private int rep_root;
	private int rep_step;
	private int rep_indent;
	
	public DesignDTO() {
		this(0, "", "", "", "", "", null, 0, 0, 0, 0);
	}
	
	public DesignDTO(int num) {
		this(num,"","","","","",null,0,0,0,0);
	}
	
	public DesignDTO(int num, String typename,String title, String content) {
		this(num,"",typename,title,content,"",null,0,0,0,0);
	}

	public DesignDTO(String author, String typename, String title, String content, String password) {
		this(0, author, typename, title, content, password, null, 0, 0, 0, 0);
	}
	
	public DesignDTO(int num, String author, String typename, String title, String content, String password,
			Timestamp writedate, int readcnt, int rep_root, int rep_step, int rep_indent) {
		super();
		this.num = num;
		this.author = author;
		this.typename = typename;
		this.title = title;
		this.content = content;
		this.password = password;
		this.writedate = writedate;
		this.readcnt = readcnt;
		this.rep_root = rep_root;
		this.rep_step = rep_step;
		this.rep_indent = rep_indent;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRep_root() {
		return rep_root;
	}
	public void setRep_root(int rep_root) {
		this.rep_root = rep_root;
	}
	public int getRep_step() {
		return rep_step;
	}
	public void setRep_step(int rep_step) {
		this.rep_step = rep_step;
	}
	public int getRep_indent() {
		return rep_indent;
	}
	public void setRep_indent(int rep_indent) {
		this.rep_indent = rep_indent;
	}

	@Override
	public String toString() {
		return "DesignDTO [num=" + num + ", author=" + author + ", typename=" + typename + ", title=" + title
				+ ", content=" + content + ", password=" + password + ", writedate=" + writedate + ", readcnt="
				+ readcnt + ", rep_root=" + rep_root + ", rep_step=" + rep_step + ", rep_indent=" + rep_indent + "]";
	}
}
