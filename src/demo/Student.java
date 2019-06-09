package demo;

public class Student extends People {
	/**
	 * Ñ§ºÅ
	 */
	private String sId;

	public Student() {
		this("", "", "");
	}
	
	public Student(String name, String id, String sId) {
		super(name, id);
		this.sId = sId;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}
	
	public void sayHello() {
		super.sayHello();
		System.out.println("I am a student of department of compuer science.");
	}
	
}
