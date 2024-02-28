package task.database;

public class Dependent{
	
	private long empID;
	
	private String name;
	
	private String relation;
	
	private int age;
	
	public String toString() {
		return(	"Dependent :"+this.name+
				"\nDependent Relation : "+this.relation+
				"\nDependent Age : "+this.age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setEmpID(long l) {
		this.empID = l;
	}
	
	public long getEmpID() {
		return empID;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}

}
