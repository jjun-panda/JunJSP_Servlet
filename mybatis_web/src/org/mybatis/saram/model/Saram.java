package org.mybatis.saram.model;

public class Saram {
	private int seq;
	private String id;
	private String name;
	private String email;
	
	public Saram() {
		this(0, "","","");
	}

	public Saram(int seq, String id, String name, String email) {
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Saram(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[" + seq + "] " + id + "\t" + name + "\t" + email;
	}
}