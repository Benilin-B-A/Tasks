package task.basic.programming;

public class Employee {
	
	public Employee() {
		
	}
	
	public Employee(String name,String iD){
		setName(name);
		setID(iD);
	}
	
	private String employeeID;
	private String employeeName;
	
	public void setName(String name){
		this.employeeName=name;
	}
	
	public void setID(String iD) {
		this.employeeID=iD;
	}
	
	public String getName() {
		return this.employeeName;
	}
	
	public String getID() {
		return this.employeeID;
	}
	
	public String toString() {
		return ("Name : "+this.employeeName+"\nID : "+this.employeeName);
	}
}
