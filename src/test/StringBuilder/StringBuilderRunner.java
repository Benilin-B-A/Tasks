package test.StringBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.stringbuilder.StringBuilderTask;
import utils.InputUtil;
import utils.InvalidInputException;

public class StringBuilderRunner{
	
	private static Scanner scan = new Scanner(System.in);
	private static Logger logger = Logger.getLogger("StringBuilderRunner.class");
	
	public static void main(String...args){
		StringBuilderTask strBuildTask = new StringBuilderTask();
		boolean cont = true;
		while(cont){
			
			int choice = getInt("Enter your choice of task ( 1-10 ) : ");
			
			
			switch(choice){
				
				case 1:
				
				String str1 = getString();
				
				try{
					StringBuilder strB = strBuildTask.createStrBuilder(str1);
					logStrAndLen(strB);
					int int1 = getInt("Do you want to add a string to this StringBuilder?"+
								" 1-Yes : ");
					if(int1 == 1){
						String str2 = getString("Enter the string you want to add : ");
						strBuildTask.addString(strB,str2);
						logStrAndLen(strB);
					}
					else{
						break;
					}
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 1", exception);
				}
				
				break;
				
				case 2:
				
				String str3 = getString();
				try{
					StringBuilder strB=strBuildTask.createStrBuilder(str3);
					logStrAndLen(strB);
					String[] strArray = InputUtil.getStringArray(scan);
					String delim = getString("Enter your delimiter : ");
					strBuildTask.addString(strB,delim,strArray);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 2", exception);
				}
				
				break;
				
				//check----------------------------------------------------------------------------
				
				case 3:
				
				String[] strArray = InputUtil.getStringArray(scan);
				String delim = getString("Enter delimiter : ");
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray,delim);
					logStrAndLen(strB);
					String str = getString("Enter the new string you want to insert in between : ");
					strBuildTask.addString(strB,str,delim);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 3", exception);
				}
				
				break;
				
				case 4:

				String[] strArray1 = InputUtil.getStringArray(scan);
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray1," ");
					logStrAndLen(strB);
					int nElem = getInt("How many elements do you want to delete? : ");
					strBuildTask.deleteElem(strB," ",nElem);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 4", exception);
				}
				
				break;
				
				case 5:

				String[] strArray2 = InputUtil.getStringArray(scan);
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray2," ");
					logStrAndLen(strB);
					strBuildTask.replaceAllMatch(strB," ","-");
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 5", exception);
				}
				
				break;
				
				case 6:
				
				String[] strArray3 = InputUtil.getStringArray(scan);
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray3," ");
					logStrAndLen(strB);
					strBuildTask.reverseStrBuilder(strB);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 6", exception);
				}
				break;
				
				case 7:

				String[] strArray4 = InputUtil.getStringArray(scan);
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray4," ");
					logStrAndLen(strB);
					int start = getInt("Enter start index to delete : ");
					int end = getInt("Enter end index to delete : ");
					strBuildTask.deleteElem(strB,start,end);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 7", exception);
				}
				break;
				
				case 8:
				
				String[] strArray5 = InputUtil.getStringArray(scan);
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray5," ");
					logStrAndLen(strB);
					int start = getInt("Enter start index to replace : ");
					int end = getInt("Enter end index to replace : ");
					String replacement = getString("Enter replacement string : ");
					strBuildTask.replaceStr(strB,start,end,replacement);
					logStrAndLen(strB);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 8", exception);
				}
				break;
				
				case 9:
				
				String[] strArray6 = InputUtil.getStringArray(scan);
				String tarString = getString("Enter target whose first occurence you want to find? : ");
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray6,tarString);
					int firstIndex = strBuildTask.findFirstIndex(strB,tarString);
					logStrAndLen(strB);
					logger.info("The final string is "+strB+
					" with first occurence of "+tarString+" at "+firstIndex);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 9", exception);
				}
				
				break;
				
				case 10:
				
				String[] strArray7 = InputUtil.getStringArray(scan);
				String target = getString("Enter String whose last occurence you want to check : ");
				try{
					StringBuilder strB = strBuildTask.createWithDelim(strArray7,target);
					int lastIndex = strBuildTask.findLastIndex(strB,target);
					logStrAndLen(strB);
					logger.info("The final string is "+strB+
					" with last occurence of "+target+" at "+lastIndex);
				}
				catch(InvalidInputException exception){
					logger.log(Level.SEVERE,"Main : case 10", exception);
				}
				break;
				
	/*			case 11: //test case for addString(StringBuilder,String);
				int num = getInt("");
				try{
				switch(num){
						case 1:  //returns hello
						StringBuilder strB25=
						strBuildTask.addString(new StringBuilder(),"hello");
						System.out.println(strB25);
						break;
						case 2:  //throws exception
						StringBuilder strB26=strBuildTask.addString(null,null);
						System.out.println(strB26); 
						break;
						case 3:  //throws exception
						StringBuilder strB27=strBuildTask.addString(null,"");
						System.out.println(strB27); 
						break;
						case 4: //returns empty
						StringBuilder strB28=
						strBuildTask.addString(new StringBuilder(),"");
						System.out.println(strB28);						
				 		}}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
				break;
				
				case 12: //test case for addString(StringBuilder strB,String delim,String[] strArr)
				int num1=scan.nextInt();
				scan.nextLine();
				try{
				switch(num1){
					
						case 1://exception
						StringBuilder strB29=strBuildTask.addString(new StringBuilder(),"",new String[1]);
						System.out.println(strB29);
						break;
						case 2:  //ambiguity
						StringBuilder strB30=strBuildTask.addString(null,null,null); 
						System.out.println(strB30);
						break;
						case 3:  //ambiguity
						StringBuilder strB31=strBuildTask.addString(new StringBuilder(),null,null);
						System.out.println(strB31);
						break;
						case 4://returns Strings in string array
						String[] strArr11=InputUtil.getStringArray();
						StringBuilder strB32=
						strBuildTask.addString(new StringBuilder(),"",strArr11);
						System.out.println(strB32);
						break;
						case 5: //
						StringBuilder strB33=
						strBuildTask.addString(new StringBuilder(),"",null);
						System.out.println(strB33);
						break;
						case 6: //returns strings in array with delimiter
						String[] strArr12=InputUtil.getStringArray();
						StringBuilder stringBuild=new StringBuilder("Hello");
						StringBuilder strB34=strBuildTask.addString(stringBuild,"",strArr12);
						System.out.println(strB34);
					}}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
				break;
					
				case 13:   //test case for deleteElem(StringBuilder strB,String delim,int nElem)
				int num2=scan.nextInt();
				scan.nextLine();
				StringBuilder strB15=new StringBuilder("beni**benilin**ben");
				try{
					switch(num2){
					
					case 1:
					StringBuilder strB35=
					strBuildTask.deleteElem(new StringBuilder(),"",1);
					System.out.println(strB35);
					break;
					case 2:
					StringBuilder strB36=strBuildTask.deleteElem(strB15,"",10);
					System.out.println(strB36);
					break;
					case 3:
					StringBuilder strB38=strBuildTask.deleteElem(strB15,"*",2);
					System.out.println(strB38);
					break;
				}}
				catch(InvalidInputException exception){
					exception.printStackTrace();
				}		*/
			}
		logger.info("Hit enter to continue...");
		String contString = getString("");
		if(!contString.equals("")){
			cont = false;
		}
		}
		
		scan.close();
	}
	
	
	
	public static void logStrAndLen(StringBuilder strB) {
		try{
			logger.info("The length of final string "+strB
					+" is "+StringBuilderTask.getLen(strB));
		}
		catch(InvalidInputException exception){
			logger.log(Level.SEVERE,"Main : logStrAndLen method", exception);
		}		
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
