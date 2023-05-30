package jsp01;

public class PersonDTO {
	// DB의 PERSON테이블의 필드와 동일한 구조이다.
	private int seq;
	private String id;
	private String name;
	private int age;
	// Lombok 라이브러리를 사용하면 자동 생성 가능한 부분.
	public PersonDTO() {
		this(0,"","",0); // seq, id, name, age
	}
	public PersonDTO(int seq, String id, String name, int age) {
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "['seq':" + seq + ", 'id':'" + id + "', 'name':'" + name + "', 'age':" + age + "]";
	}	
}