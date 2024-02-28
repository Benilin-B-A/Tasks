package task.basic.programming;

public class Student {
	
	public Student(String name) {
		this.name=name;
	}
	private String name;
	
	public String toString() {
		return("Name : "+this.name);
	}
}
