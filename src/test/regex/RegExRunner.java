package test.regex;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.regex.RegExTask;
import utils.InputUtil;
import utils.InvalidInputException;

public class RegExRunner {
	
	private static Logger logger = Logger.getLogger("RegExRunner.class");
	private static Scanner scan = new Scanner(System.in);
	
	public static void main (String...args) {
		
		RegExTask task = new RegExTask();
		boolean cont = true;
		
		while(cont){
			
			int choice = getInt("Enter your choice of task ( 1-10 ) : ");
			
			switch(choice){
			
			case 1:
				try {
					String num = getString("Enter mobile number : ");
					boolean isValid = task.validateMobile(num);
					logResult(isValid,"Mobile number validated","Invalid mobile number");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 1",exception);
				}
				
				break;
				
			case 2:				
				try {
					String alphaNum = getString("Enter an AlphaNumeric string : ");
					boolean isAlphaNum = task.validateAlphaNum(alphaNum);
					logResult(isAlphaNum, "AlphaNumeric String validated",
							"Invalid AlphaNuneric String");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 2",exception);
				}				
				break;
				
			case 3:				
				try {
					String pattern = 
						getString("Enter string whose presence you want to check at start : ");
					String string = getString("Enter String to check : ");
					boolean startsWith = task.validateStartsWith(pattern, string);
					logResult(startsWith,"The string starts with the given pattern",
							"The String doesn't start with the given pattern");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 3",exception);
				}				
				break;
				
			case 4:
				try {
					String pattern = 
						getString("Enter string whose presence you want to check at end : ");
					String string = getString("Enter String to check : ");
					boolean endsWith = task.validateEndsWith(pattern, string);
					logResult(endsWith,"The string ends with the pattern",
							 "The String doesn't end with the pattern");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 4",exception);
				}				
				break;
				
			case 5:
				try {
					String pattern = 
						getString("Enter string whose presence you want to check : ");
					String string = getString("Enter String to check : ");
					boolean contains = task.validateContains(pattern, string);
					logResult(contains,"The string contains the pattern",
							"The String doesn't contain the pattern");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 5",exception);
				}
				
				break;
				
			case 6:
				try {
					String pattern = 
						getString("Enter string whose presence you want to check : ");
					String string = getString("Enter String to check : ");
					boolean match = task.validateExact(pattern, string);
					logResult(match,"Exact match","String doesn't match pattern exactly");
				}
				catch(InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 6",exception);
				}
				
				break;
				
			case 7:
				try {
					String[] strArr = InputUtil.getStringArray(scan);
					String str = getString("Enter Matching String : ");
					List<String> list = task.validateCaseIns(strArr,str);
					int len = list.size();
					if(len==0) {
						logger.info("Successfully Validated");
					}
					else {
						logger.info("The following strings didn't match : "+list);
					}
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"String Array : Main : Case 7",exception);
				}
				catch (InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 7",exception);
				}
				break;
				
			case 8:
				try {
					String mail = getString("Enter E-mail address : ");
					boolean isValid = task.validateMail(mail);
					logResult(isValid,"Email ID validated", "Invalid Email ID");					
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"String Array : Main : Case 7",exception);
				}
				catch (InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 8",exception);
				}
				break;
				
			case 9:
				try {
					List<String> keyList = RegExTask.getList();
					getListInputs(keyList);
					List<String> valList = RegExTask.getList();
					getListInputs(valList);
					Map<String,Integer> map = task.getMap(keyList,valList);
					if(map.size()!=0) {
						logger.info("The map is : "+map);
					}
					else {
						logger.info("There were no matches");
					}
				}
				catch (InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 9",exception);
				}
				break;
				
			case 10:
				try {
					String hString = getString("Enter raw HTML string : ");
					List<String> list = task.getTags(hString);
					for(String str : list) {
						System.out.println(str);
					}
				}
				catch (InvalidInputException exception) {
					logger.log(Level.SEVERE,"Main : Case 10",exception);
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
	
	private static List<String> getListInputs(List<String> list) {
		int num = getInt("How many strings do you want to enter ? :");
		for(int x=0;x<num;x++){
			logger.info("Enter String : ");
			String string =scan.nextLine();
			list.add(string);
		}
		return list;
	}

	private static void logResult(boolean result,String trueString,String falseString) {
		if(result) {
			logger.info(trueString);
		}
		else {
			logger.info(falseString);
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
			logger.log(Level.WARNING,"Incorrect choice",exception);
			return getInt("Enter valid choice : ");
		}		
	}
}
