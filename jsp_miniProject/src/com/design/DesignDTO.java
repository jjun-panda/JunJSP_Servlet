package com.design;
import java.sql.Date;

public class DesignDTO {
	// SEQ, NAME, GENRE, AUTHOR, CONTENT, REGDATE, CNT
	private int seq;
	private String name;
	private String type;
    private String author;
    private String content;
    private Date regdate;
    private int cnt;
    
    public DesignDTO() {
    }
    
	public DesignDTO(int seq, String name, String type, String author, String content, Date regdate, int cnt) {
		super();
		this.seq = seq;
		this.name = name;
		this.type = type;
		this.author = author;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "designDTO [ " + "seq=" + seq + ", name=" + name + ", type=" + type + ", author=" + author + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}
	
}
