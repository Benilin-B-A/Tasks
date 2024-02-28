package task.database;

public class Employee {
	
	public Employee() {
		
	}
	
	public Employee(String name, long mobile, String eMail, String department) {
		this.name = name;
		this.mobile = mobile;
		this.eMail = eMail;
		this.department = department;
	}
	private String name;
	
	protected long empID;
	
	private long mobile;
	
	private String eMail;
	
	private String department;

	
	public String toString() {
		return(	"EmployeeID : "+this.empID+
				"\nName : "+this.name+
				"\nMobile : "+this.mobile+
				"\nEmail : "+this.eMail+
				"\nDepartment : "+this.department);
	}
	
	public void setEmpID(long iD) {
		this.empID=iD;
	}
	
	public long getEmpID() {
		return this.empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
