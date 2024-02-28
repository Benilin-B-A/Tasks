package task.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBTask {
	
	private String dB;
	
	public void setDB(String dB) {
		this.dB = dB;
	}
	
	private  Connection connect() throws SQLException {
		return DriverManager.getConnection(ConnectionHandler.getURL()+
				dB,ConnectionHandler.getUser(),ConnectionHandler.getPassword());
	}

	private  Statement getStatement(Connection con)
			throws SQLException {
		return con.createStatement();
	}

	public void createDB(String str) throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
				st.execute("create database " + str);
		}
	}

	public void createTable(String tableName)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
			if(tableName.equals("Employees")) {
				st.execute("create table " + tableName+
			TableSchema.employeeFields);
			}
			else{
				st.execute("create table " + tableName + "(" +
			TableSchema.dependentFields + ")");
			}
		}
	}
	
	public void enterEmployeeData(List<Employee> list)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
			int len = list.size();
			for(int i=0;i<len;i++) {
				Employee obj = list.get(i);
				String name = obj.getName();
				long mobile = obj.getMobile();
				String eMail = obj.getEMail();
				String department = obj.getDepartment();
				st.addBatch("insert into Employees (Name,Mobile,Email,Department)"
						+ "values('"+name+"',"+mobile+",'"+eMail+"','"+department+"')");				
 			}
			st.executeBatch();
		}
	}

	public List<Employee> getEmployeeDetails(String tableName, String filter, String value)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection);
					ResultSet set = st.executeQuery("select * from " + tableName +
						" where " + filter + " = '" + value + "'")){
			return processEmployees(set);	
		}
	}

	public void updateField(String tableName,String filter, String value, String updateField, String newValue)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
			st.execute("update " + tableName + " set " + updateField 
						+ " = '" + newValue + "' where " +
						filter + " = '" + value + "'");
		}
	}
	
	public List<Employee> getNEmployees(int num) throws SQLException{
		try (Connection connection = connect();
				Statement st = getStatement(connection);
					ResultSet set = st.executeQuery("select * from Employees limit "+num)) {
			return processEmployees(set);
		}
	}

	public List<Employee> getOrderedEmployeeData(int num, String field, String order)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection);
					ResultSet set = st.executeQuery("select * from "
							+ "Employees order by "+ field + " " + order)){
			return processEmployees(set);
		}
	}
	
	public void deleteEmployee(String tableName, String field, String value)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
			st.execute("delete from " + tableName + " where " +
			field + " = '"+ value + "'");
		}
	}

	public void enterDependentData(List<Dependent> list) 
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection)) {
			int len = list.size();
			for(int i=0;i<len;i++) {
				Dependent obj = list.get(i);
				long empID = obj.getEmpID();
				String name = obj.getName();
				String relation = obj.getRelation();
				int age = obj.getAge();
				st.addBatch("insert into Dependents (EmployeeID,Dependent,Relation,Age) "
						+ "values('"+empID+"','"+name+"','"+relation+"','"+age+"')");				
 			}
			st.executeBatch();
		}
	}
	
	public List<Dependent> getDependentDetails(String filter, String value)
			throws SQLException {
		try (Connection connection = connect();
				Statement st = getStatement(connection);
					ResultSet set = st.executeQuery("select * from Dependents inner join Employees on "
						+ "Employees.EmployeeID=Dependents.EmployeeID where Employees." 
							+ filter + " = '" + value + "'")) {
			return processDependents(set);
		}
	}
	
	public Map<Long,List<Dependent>> getNDependents(int num) throws SQLException{
		try (Connection connection = connect();
				Statement st = getStatement(connection);) {
			StringBuilder str = new StringBuilder();
			try(ResultSet set = st.executeQuery("select EmployeeID from Employees limit "+num)) {
				while (set.next()){
					str.append(set.getLong(1));
					str.append(",");
				}
				str.deleteCharAt(str.lastIndexOf(","));
			}
			
			try (ResultSet set = st.executeQuery("select * from Dependents where EmployeeID in ("+str.toString()+")")){
				Map<Long,List<Dependent>> resultMap = new HashMap<Long, List<Dependent>>();
				while(set.next()) {
					long id = set.getLong(1);
					Dependent dep = new Dependent();
					dep.setName(set.getString(2));
					dep.setRelation(set.getString(3));
					dep.setAge(set.getInt(4));
					List<Dependent> list = resultMap.get(id);
					if(list == null) {									
						list = new ArrayList<Dependent>();
						resultMap.put(id,list);
					}	
					list.add(dep);
				}
				return resultMap;
			}
		}
	}
	
	private List<Dependent> processDependents(ResultSet set)
			throws SQLException{
		List<Dependent> list = new ArrayList<Dependent>();
		while(set.next()){
			Dependent dep = new Dependent();
			dep.setName(set.getString(2));
			dep.setRelation(set.getString(3));
			dep.setAge(set.getInt(4));
			list.add(dep);
		}
		return list;
	}
	
	private List<Employee> processEmployees(ResultSet set)
			throws SQLException{
		List<Employee> list = new ArrayList<Employee>();
		while (set.next()) {
			Employee emp = new Employee();
			emp.setEmpID(set.getLong(1));
			emp.setName(set.getString(2));
			emp.setMobile(set.getLong(3));
			emp.setEMail(set.getString(4));
			emp.setDepartment(set.getString(5));
			list.add(emp);
		}
		return list;
	}
	
}
