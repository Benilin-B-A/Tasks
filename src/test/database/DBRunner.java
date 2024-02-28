package test.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.database.DBTask;
import task.database.Employee;
import task.database.Dependent;

public class DBRunner {
	
	
	private static Logger logger = Logger.getLogger("RegExRunner.class");
	private static Scanner scan = new Scanner(System.in);
	
	public static void main (String...args) {
		
		DBTask task = new DBTask();
		task.setDB("IncubationDB");
		
		boolean cont = true;
		while(cont){
			
			int choice = getInt("Enter your choice of task ( 1-10 ) : ");
			
			switch(choice){
			
			case 1:
				try {
					String dB = getString("Enter database name : ");
					task.createDB(dB);
					logger.info("Database created");
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in creating DB",exception);
				}
				
			case 2:
				try {
					String tableName = getString("Enter Table name to create : ");
					task.createTable(tableName);
					logger.info("Table created");
				}
				catch(SQLException exception){
					logger.log(Level.SEVERE,"Error in creating table",exception);
				}
				break;
				
			case 3:
				try {
					List<Employee> list = createEmployeeObj();
					task.enterEmployeeData(list);					
				}
				catch(SQLException exception){
					logger.log(Level.SEVERE,"Error in adding data",exception);
				}
				break;
			
			case 4:
				try {
					String tableName = getString("Enter table name : ");
					String filter = getString("Enter field to use for search");
					String value = getString("Enter "+filter+" value : ");
					List<Employee> list = task.getEmployeeDetails(tableName, filter, value);
					printEmployees(list);
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in retrieving data",exception);
				}
				break;
				
			case 5:
				try {
					String tableName = getString("Enter Table Name : ");
					String filter = getString("Enter field you want to use as filter : ");
					String value = getString("Enter "+filter+" value : ");
					String updateField = getString("Enter field you want to update : ");
					String newValue = getString("Enter new "+updateField+" value :");
					task.updateField(tableName,filter,value,updateField,newValue);
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in updating data",exception);
				}
				break;
				
			case 6:
				try {
					int num = getInt("Enter number of Employees to fetch : ");
					List<Employee> list = task.getNEmployees(num);
					printEmployees(list);
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in retrieving data",exception);
				}
				break;
				
			case 7:
				try {
					int num = getInt("Enter number of Employees to fetch : ");
					String field = getString("Enter field to sort while fetching data : ");
					String order = getString("Enter order (ASC | DESC) : ");
					List<Employee> list = task.getOrderedEmployeeData(num,field,order);
					printEmployees(list);
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in retrieving ordered data",exception);
				}
				break;
				
			case 8:
				try {
					String tabName = getString("Enter Table Name : ");
					String field = getString("Enter filed of selection : ");
					String value = getString("Enter "+ field + " value : ");
					task.deleteEmployee(tabName, field, value);
				}
				catch(SQLException exception){
					logger.log(Level.SEVERE,"Error in retrieving ordered data",exception);
				}
				break;
				
			case 9:
				try {
					List<Dependent> list = getDependents();
					task.enterDependentData(list);
				}
				catch(SQLException exception) {
					logger.log(Level.SEVERE,"Error in retrieving ordered data",exception);
				}
				break;
				
			case 10:
				try {
					String filter = getString("Enter field to filter : ");
					String value = getString("Enter "+filter+" value : ");
					List<Dependent> list = task.getDependentDetails(filter,value);
					printDependents(list);
				}
				catch(SQLException exception){
					logger.log(Level.SEVERE,"Error in retrieving ordered data",exception);					
				}
				break;
			
			case 11:
				try {
					int num = getInt("Enter number of Employees' "
							+ "dependents to fetch : ");
					Map<Long,List<Dependent>> map = task.getNDependents(num);
					logger.info("The Map is : "+map);
				}
				catch(SQLException exception){
					logger.log(Level.SEVERE,"Error in retrieving data",exception);					
				}
			}
			logger.info("Hit enter to continue...");
			String contString = getString("");
			if(!contString.equals("")){
				cont = false;
			}
		}
		scan.close();
	}
	
	private static void printEmployees(List<Employee>  list) {
		int len = list.size();
		for(int i = 0;i<len;i++) {
				System.out.println(list.get(i)+"\n");
		}
		
	}
	
	private static void printDependents(List<Dependent>  list) {
		int len = list.size();
		for(int i = 0;i<len;i++) {
				System.out.println(list.get(i)+"\n");
		}
		
	}

	private static String getString(String str) {
		logger.info(str);
		return scan.nextLine();
	}
	
	private static int getInt(String str) {
		logger.info(str);
		try {
			int num = scan.nextInt();
			scan.nextLine();
			return num;
		}catch(InputMismatchException exception) {
			scan.nextLine();
			logger.log(Level.WARNING,"Incorrect entry",exception);
			return getInt(str);
		}		
	}
	private static List<Employee> createEmployeeObj() {
		int num = getInt("How many Employees do you want to add ? : ");
		List<Employee> list = new ArrayList<Employee>();
		for(int i = 0;i<num;i++) {
			Employee emp = new Employee();
			emp.setName(getString("Enter Employee name : "));
			emp.setMobile(getLong("Enter Mobile No : "));
			emp.setEMail(getString("Enter Email : "));
			emp.setDepartment(getString("Enter department : "));
			list.add(emp);
		}
		return list;
	}
	
	private static List<Dependent> getDependents() {
		List<Dependent> list = new ArrayList<Dependent>();
		int num = getInt("Enter number of dependents Object: ");
		for(int i=1;i<=num;i++) {
			Dependent dep = new Dependent();
			dep.setEmpID(getLong("Enter employee ID : "));
			dep.setName(getString("Enter dependent name : "));
			dep.setRelation(getString("Enter dependent Relation : "));
			dep.setAge(getInt("Enter dependent age : "));
			list.add(dep);
		}
		return list;
	}
	
	private static long getLong(String string) {
		logger.info(string);
		try {
			long num = scan.nextLong();
			scan.nextLine();
			return num;
		}catch(InputMismatchException exception) {
			scan.nextLine();
			logger.log(Level.WARNING,"Incorrect entry",exception);
			return getLong(string);
		}
	}
}

