package test.string;

import utils.InputUtil;
import utils.InvalidInputException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.string.StringTask;

import java.util.Arrays;
import java.util.InputMismatchException;

public class StringRunner{	

	private static Scanner scan = new Scanner(System.in);
	private static Logger logger = Logger.getLogger("StringRunner.class");

	public static void main(String...args){
   	
		boolean cont = true;
		while(cont){
			int choice = 0;
			choice = getInt("Enter your choice ( 1-20 ) : ");
			StringTask strTask = new StringTask();

			switch(choice){

			case 1:

				if(args.length != 0){
					String arg0 = args[0];
					try{
						int lengthOfStr = strTask.getLen(arg0);
						logger.info("The length of string "
								+arg0+" is "+lengthOfStr);
					}
					catch(InvalidInputException exception){
						logger.log(Level.SEVERE,"Main : case 1", exception);
					}
				}
				else{
					logger.info("No string entered");
				}
				
				break;

			case 2:

				String str = getString();
				try{
					char[] charArr = strTask.toCharArr(str);
					logger.info(Arrays.toString(charArr));
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 2", exception);
				}
				
				break;

			case 3:

				String str1 = getString();
				int targetPos = getInt("Enter target position : ");

				try{
					char targetChar= strTask.findTargetChar(str1,targetPos);
					logger.info("The character is : "+targetChar);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 3", exception);
				}
	
				break;

			case 4:

				String str2 = getString();
				logger.info("Enter the character whose"+
						" occurence you want to check : ");
				char character=scan.nextLine().charAt(0);
				
				try{
					int nOfOcc=strTask.getOccurence(str2,character);
					logger.info("The character "+character+" has occured "
							+nOfOcc+" times in the given string");
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 4", exception);
				}
				
				break;
	
			case 5:

				String str3 = getString();
				String charToCheck = getString("Enter the character whose greatest"+
						" position you want to check : ");
				try{
					int index=strTask.findLastIndex(str3,charToCheck);
					logger.info("The character "+charToCheck+
							" has a greatest position of "+index+
							" in the given string");
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 5", exception);
				}
	
				break;

			case 6:

				String str4 = getString();
				int int1 = getInt("Create substring with start and end position (1) "
						+ "or Without end position - till last (2) : ");
				if(int1==1){
					int start = getInt("Enter start position : ");
					int end = getInt("Enter end position : ");
					try{
						String subStr = strTask.createSubstring(str4,start,end);
						logger.info("The required characters are, "+subStr);	
					}
					catch(InvalidInputException exception){
						logger.log(Level.SEVERE,"Main : case 6", exception);
					}
				}
				else if(int1==2){
					int start = getInt("Enter Starting position : ");
					try{
						String subStr = strTask.createSubstring(str4,start);
						logger.info("The required characters are, "+subStr);
					}
					catch(InvalidInputException exception){
						logger.log(Level.SEVERE,"Main : case 6", exception);
					}
				}
				else{
					logger.info("Invalid Choice");
				}
	
				break;
	
			case 7:
				
				String str5 = getString();
				int num = getInt("Enter value of n (to create substring "+
						"of first n caharcters): ");
				try{
					String subString = strTask.createSubstring(num,str5);
					logger.info("The required characters are, "+subString);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 7", exception);
				}
	
				break;
		
			case 8:

				String str6 = getString();
				logger.info("Enter Start and end position "+
						"of region to be replaced : ");
				int int2 = getInt("Start : ");
				int int3 = getInt("End : ");
				String str7 = getString("Enter replacement string : ");
				try{	
					String newStr=strTask.replaceLetters(str6,int2,int3,str7);
					logger.info("The new string is : "+newStr);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 8", exception);
				}
				break;
				
	//check
				
			case 9:

				String str8 = getString();
				String str9 = getString("Enter starting substring to check : ");
				try{
					boolean startsWith = strTask.isStartingWith(str8,str9);
					if(startsWith){
						logger.info("The string starts with, "+str9);
					}
					else {
						logger.info("The string doesn't start with, "+str9);
					}
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 9", exception);
				}
	
				break;
				
			case 10:

				String str10 = getString();
				String str11 = getString("Enter ending substring to check : ");
				
				try{
					boolean endsWith = strTask.isEndingWith(str10,str11);
					if(endsWith){
						logger.info("The string ends with, "+str11);
					}
					else {
						logger.info("The string doesn't end with, "+str11);
					}					
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 10", exception);
				}
	
				break;
	
			case 11:
				
				String str12 = getString();
				
				try{
					String lower = strTask.toLower(str12);
					logger.info(lower);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 11", exception);
				}
	
				break;
	
			case 12:

				String str13 = getString();
			
				try{
					String upper = strTask.toUpper(str13);
					logger.info(upper);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 12", exception);
				}
	
				break;
	
			case 13:

				String str14 = getString();
				
				try{
					String revStr = strTask.reverseString(str14);
					logger.info("Reversed String : "+revStr);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 13", exception);
				}
	
				break;

			case 14:

				String str15 = getString();
				logger.info("The String ( "+str15+" ) is accepted");
	
				break;
	
			case 15:

				String str16 = getString();
				
				try{
					String newString = strTask.replaceAllMatch(str16," ","");
					logger.info("The String is now : "+newString);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 15", exception);
				}
	
				break;

			case 16:

				String str17 = getString();
				try{
					String[] words = strTask.splitLine(str17," ");
					logger.info("Reference : 'words' "+Arrays.toString(words));
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 16", exception);
				}
	
				break;

			case 17:
				
				String[] strArray = InputUtil.getStringArray(scan);
				String delim = getString("Enter your delimiter : ");
				try{
					String delimStr=strTask.appendWithDelimiter(strArray,delim);
					logger.info(delimStr);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 17", exception);
				}
				catch(InputMismatchException exception) {
					logger.log(Level.WARNING,"Enter valid input...",exception);
				}
	
				break;
	
			case 18:
				
				String str19 = getString("Enter first string : ");
				String str20 = getString("Enter second string : ");
				try{
					boolean isEqualCS = strTask.isEqualCaseSensitive(str19,str20);
					if (isEqualCS){
						logger.info("Strings are equal");
					}
					else{
						logger.info("Strings are not equal");
					}
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 18", exception);
				}
				
				break;

			case 19:

				String str21 = getString("Enter first string : ");
				String str22 = getString("Enter second string : ");
				try{
					boolean isEqualNCS = strTask.isEqualNotCaseSensitive(str21,str22);
					if (isEqualNCS){
						logger.info("Strings are equal");
					}
					else{
						logger.info("Strings are not equal");
					}
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 19", exception);
				}
	
				break;

			case 20:

				String str23 = getString();
				try{
					String noTrailSp=strTask.removeTrailingSpace(str23);
					logger.info("The trailing spaces are removed "+ noTrailSp);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 20", exception);
				}
	
				break;
	
			default:
		
				logger.info("No such case available...Try again...");
			}
			
			logger.info("Hit enter to continue...");
			String str24 = getString("");
			if(!str24.equals("")){
				cont=false;
			}
		}
		scan.close();
	}	
	
	private static String getString() {
		return getString("Enter String : ");
	}
	
	private static String getString(String str) {
		logger.info(str);
		return scan.nextLine();
	}
	
	private static int getInt(String str) {
		try {
			logger.info(str);
			int num = scan.nextInt();
			scan.nextLine();
			return num;
		}
		catch(InputMismatchException exception) {
			logger.log(Level.WARNING,"Enter valid input...",exception);
		}
		return getInt(str);
	}
}
