package dummy;

import lombok.Data;

@Data
public class Person {
	private String name;
	private String gender;
	
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
}
