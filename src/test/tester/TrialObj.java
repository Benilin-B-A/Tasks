package test.tester;

import java.io.Serializable;

public class TrialObj implements Serializable{

	private static final long serialVersionUID = 7224986843093681136L;
	private int age;
	
	public String toString() {
		return("Age : "+this.age+"\nName : "+this.name);
	}
	
	public TrialObj(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	private String name;
	
		public String getName() {
			return this.name;
		}
		
		public int getAge() {
			return this.age;
		}

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}
