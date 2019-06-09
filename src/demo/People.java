package demo;
/**
 * People¿‡
 * @author hzp
 *
 */

import java.util.Calendar;

public class People {
	private String name;

	private String id;

	private Calendar birthday;

	public People(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public People(String name, String id, Calendar birthday) {
		super();
		this.name = name;
		this.id = id;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	
	public void sayHello() {
		System.out.println("Hello! My name is "+name);
	}
	
	public void sayHello(String name) {
		System.out.println("Hello, "+name+"! My name is "+this.name);
	}

}
