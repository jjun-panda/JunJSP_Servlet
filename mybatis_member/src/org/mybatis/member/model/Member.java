package org.mybatis.member.model;

public class Member {
	// seq, name, height, weight, age, gender
	private int seq;
	private String name;
	private int height;
	private int weight;
	private int age;
	private String gender;
	
	public Member() {
		this(0, "", 0, 0, 0, "남자");
	}

	public Member(int seq, String name, int height, int weight, int age, String gender) {
		this.seq = seq;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}
	
	public Member(String name, int height, int weight, int age, String gender) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}
	
	public Member(int seq, String name) {
		this.seq = seq;
		this.name = name;
	}
	
	public Member(int seq) {
		this.seq = seq;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[" + seq + "] " + name + "\t" + height + "cm\t" + weight + "kg\t"+ age + "세\t"+ gender;
	}
}