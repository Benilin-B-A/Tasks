package test.basic.programming;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.basic.programming.Employee;
import task.basic.programming.FileTask;
import task.basic.programming.RainbowColors;
import task.basic.programming.Student;
import task.basic.programming.TimeTask;
import utils.InputUtil;
import utils.InvalidInputException;

public class BasicRunner {
	
	private static Logger logger=Logger.getLogger(BasicRunner.class.getName());
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
	
		boolean c=true;;
		while(c){
			int choice=0;
			try {
				logger.info("Select Operation (1-12) : "
						+ "\n 1)  Create a file and write String lines to it"
						+ "\n 2)  Create a properties object and write it to a file"
						+ "\n 3)  Read properties from a file and load them to a properties object"
						+ "\n 4)  Create required Directories"
						+ "\n 5)  Create Student object"
						+ "\n 6)  Create Employee object with overloaded constructor"
						+ "\n 7)  Create Employee Object with default constructor"
						+ "\n 9)  Enum"
						+ "\n 10) SingletonClass Example"
						+ "\n 11) Time package tasks"
						+ "\n \n Enter Choice : ");
				choice=scan.nextInt();
				scan.nextLine();
			}
			catch(InputMismatchException exception) {
				scan.nextLine();
				logger.log(Level.WARNING,"Enter valid input...",exception);
			}
			
			FileTask task=new FileTask();
			BasicRunner run=new BasicRunner();
			
			switch(choice){
				
			
			case 1:
				
				try{
					File file=run.getFile(scan,task);
					String[] stringArr = InputUtil.getStringArray(scan);
					task.writeLines(stringArr,file,"\n");	
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"Enter valid input...",exception);
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"case 1", exception);
				}
				catch(IOException exception) {
					logger.log(Level.SEVERE,"case 1", exception);
				}
				
				break;

				
			case 2:
								
				try {
					File file=run.getFile(scan, task);
					Properties prop=task.getProp();
					run.getPropEntries(task, scan,prop);
					task.storeProp(prop, file,"My Properties");
				}
				catch(IOException exception) {
					logger.log(Level.SEVERE,"case 2", exception);
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"case 2", exception);
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"case 2", exception);
				}	

				break;
				
			case 3:
				
				try{
					
					File file=run.getFile(scan,task,
							"Where do you want to read the file from ? ");
					Properties prop=task.getProp();
					task.readProp(file, prop);
					logger.info("The properties object is : "+prop);
				}
				catch (IOException exception) {
					logger.log(Level.SEVERE,"case 3", exception);
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"case 3", exception);
				}
				
				break;
				
			case 4:
				
				try {
					File file=run.createDirectoryAndFile(scan,task);
					logger.info("What operation do you want to perform ?\n"
							+ "Write lines in file (1) // Write Properties in file (2)");
					int opt=scan.nextInt();
					scan.nextLine();
					switch(opt) {
					case 1:
						String[] stringArr = InputUtil.getStringArray(scan);
						task.writeLines(stringArr,file,"\n");
						break;
					case 2:
						Properties prop=task.getProp();
						run.getPropEntries(task, scan,prop);
						task.storeProp(prop, file,"My Properties");
					default:
						logger.info("No such choice of operation...");
					}
					
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"case 4", exception);
				}
				catch(IOException exception) {
					logger.log(Level.SEVERE,"case 4", exception);
				}
				
				break;
				
				
			/*case 100:
				System.out.print("Enter choice : ");
				int caseChoice=scan.nextInt();
				scan.nextLine();
				
				try {
					switch(caseChoice) {
					case 1:
						//FileTask.getFile(null);
						//FileTask.getFile("");
						
					case 2:
						//FileTask.getWriter(null);
						
					case 3:
						Properties prop1=task.getProp();
						task.insertEntry(prop1,"","");
						
					case 4:
						try {
							run.getWriter(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					case 5:
						
					}
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				catch(InputMismatchException exception) {
					exception.printStackTrace();
				}
				
				break;*/
			
			case 5:
				
				logger.info("Create new Student object...\nEnter student name : ");
				String studentName=scan.nextLine();
				Student stuObj=new Student(studentName);
				System.out.println(stuObj);
				
				break;
				
			case 6:
				
				logger.info("Create new Employee object...\nEnter employee name : ");
				String name=scan.nextLine();
				logger.info("Enter employee ID : ");
				String iD=scan.nextLine();
				Employee emp=new Employee(name,iD);
				logger.info("The employee object is : \n"+emp);
					
				break;
					
			case 7:
				Employee employee=new Employee();
				
				employee.setID("2012014");
				employee.setName("Benilin");
				
				String name1=employee.getName();
				String iD1=employee.getID();
				
				logger.info("Name : "+name1+" || ID : "+iD1);
				
				break;
				
			case 9:
				
				for(RainbowColors color:RainbowColors.values()) {
					logger.info("Color : "+color);
					logger.info("Color code : "+color.getCode());
				}
				logger.info("Ordianl value of yellow : "+RainbowColors.YELLOW.ordinal());
				logger.info("Value of Yellow : "+RainbowColors.valueOf("YELLOW"));
				
				break;
				
			case 11:
				
				logger.info("What task do you want to perform ? "
						+ "\n 1) Get current date and time with seconds"
						+ "\n 2) Get current time in milliseconds"
						+ "\n 3) Get time of diggerent timezones"
						+ "\n 4) Get day of week from currenttime in millis or any time"
						+ "\n 5) Get month of year from currenttime in millis or any time"
						+ "\n 6) Get year from currenttime in millis or any time"
						+ "\n \n Enter choice : ");
				try {
					int taskChoice=scan.nextInt();
					scan.nextLine();
					TimeTask timeEg=new TimeTask();
					switch (taskChoice) {
					
					case 1:
						ZonedDateTime dateTime=timeEg.getTime("Asia/Kolkata");
						logger.info("Date and Time : "+dateTime);
						break;
						
					case 2:
						long timeInMilli=timeEg.getTimeMillis();
						logger.info("The current time in milliseconds is : "+timeInMilli);
						break;
						
					case 3:
						
						String[] zones=TimeZone.getAvailableIDs();
						logger.info("The Zones are : \n"+Arrays.toString(zones)+"\nEnter the required zone from the list");
						String zone=scan.nextLine();
						logger.info("The date and time is :"+timeEg.getTime(zone));
						
						
						break;
					
					case 4:
						
						int timeChoice=run.getTimeChoice(scan);
						try {
							DayOfWeek day = null;
							if(timeChoice==1) {
								day=timeEg.getDayOfWeek();
							}
							else if(timeChoice==2) {
								long timeInMillis=run.getTimeMillis(scan,run);
								day=timeEg.getDayOfWeek(timeInMillis);
							}
							else {
								logger.warning("Invalid Choice...");
							}
							logger.info("The day is : "+ day);
						}
						catch(InputMismatchException exception) {
							exception.printStackTrace();
						}
						
						
						break;
						
					case 5:
						int ch=run.getTimeChoice(scan);
						Month month = null;
						if(ch==1){
							month=timeEg.getMonth();
						}
						else if(ch==2) {
							long timeInMillis=run.getTimeMillis(scan, run);
							month=timeEg.getMonth(timeInMillis);
						}
						else{
							logger.warning("Invalid Choice...");
						}
						logger.info("The month is : "+month);
						
						break;
						
					case 6:
						
						int ch1=run.getTimeChoice(scan);
						int year = 0;
						if(ch1==1){
							year=timeEg.getYear();
						}
						else if(ch1==2) {
							long timeInMillis=run.getTimeMillis(scan, run);
							year=timeEg.getYear(timeInMillis);
						}
						else{
							logger.warning("Invalid Choice...");
						}
						
						logger.info("The year is : "+year);
						
						break;
						
					}
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"Choice : While loop", exception);
				}
			
			break;
			
			/*case 12:
				
				SingletonExample sing1=SingletonExample.getObj();
				System.out.println(sing1);
				SingletonExample sing2=SingletonExample.getObj();
				System.out.println(sing2);
				SingletonExample sing3=sing1.clone();
				System.out.println(sing3);
				SingletonExample sing4=sing2.clone();
				System.out.println(sing4);
				
			break;*/
			
			default:
				
				logger.info("No such option...");
				
			}
			logger.info("Hit Enter to continue...");
			String cont=scan.nextLine();
			if(!cont.equals("")){
				c=false;
			}
		}
		scan.close();
		logger.info("Successfully exited...");
	}
	
	private int getTimeChoice(Scanner scan)throws InputMismatchException {
		System.out.println("Which time do you want to calculate the month of ?"
				+ "\n 1-current time // 2-user input time : ");
		int ch=scan.nextInt();
		scan.nextLine();
		return ch;
	}
	
	private long getTimeMillis(Scanner scan,BasicRunner run)throws InputMismatchException{
		logger.info("Enter the time in milliseconds : ");
			long milliTime=scan.nextLong();
			scan.nextLine();
			return milliTime;
	}
	
	private void getPropEntries(FileTask task,Scanner scan,Properties prop)
			throws InvalidInputException{
			int num=getNum(scan,"How many properties do you want to enter ? : ");
			for(int x=0;x<num;x++){
				logger.info("Enter key: ");
				String key=scan.nextLine();
				logger.info("Enter value: ");
				String val=scan.nextLine();
				task.insertEntry(prop,key,val);	
			}
	}

	private File createDirectoryAndFile(Scanner scan, FileTask task) 
			throws IOException, InvalidInputException {
		logger.info("Enter directories to create (In Order): ");
		String dirPath=scan.nextLine();
		logger.info("Enter Filename : ");
		String fName=scan.nextLine();
		task.createDir(dirPath);
		return task.getFile(dirPath, fName);
	}

	private static int getNum(Scanner scan,String str){
		try {
			logger.info(str);
			int num=scan.nextInt();
			scan.nextLine();
			return num;
		}
		catch(InputMismatchException excep){
			logger.info("Enter valid input...");
			return getNum(scan,"Enter number : ");
		}
	
	}
	private File getFile(Scanner scan,FileTask task)
			throws IOException, InvalidInputException{
		return getFile(scan,task,"Where do you want to create a file ? ");
	}

	private File getFile(Scanner scan,FileTask task,String str) 
			throws IOException, InvalidInputException {
		String dir=null;
		logger.info(str+"\nEnter option : Current directory(1) // Custom directory(2) : ");
		int option=scan.nextInt();
		scan.nextLine();
		if(option==1){
			dir=task.getCurrentDir();
		}
		else if (option==2){
			logger.info("Enter Directory of file : ");
			dir=scan.nextLine();
		}
		else{
			logger.warning("Invalid choice...");
		}
		logger.info("Enter Filename : ");
		String fName=scan.nextLine();
		return task.getFile(dir,fName);
	}	
		
}