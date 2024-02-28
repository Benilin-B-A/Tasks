package task.database;

public class TableSchema {
	
	public static String employeeFields = "(EmployeeID bigint not null auto_increment,Name varchar(100),Mobile bigint,"
			+ "Email varchar(100),Department varchar(100),Primary Key (EmployeeID))";
	
	public static String dependentFields = "EmployeeID bigint not null,Name varchar(100),Relation varchar(100),"
			+ "Age int,foreign key(EmployeeID) references Employees(EmployeeID) on delete cascade";
	
}
