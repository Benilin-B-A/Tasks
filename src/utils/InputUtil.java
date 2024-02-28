package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputUtil {
	
	private static Logger logger=Logger.getLogger("InpuptUtil.class");
	
	public static String[] getStringArray(Scanner scanner) throws InputMismatchException{
			
			logger.info("How many Strings do you want to enter : ");
			int num = scanner.nextInt();
			scanner.nextLine();
			String[] strArr = new String[num];
			for(int x=0;x<num;x++){
				logger.info("Enter String : ");
				String string =scanner.nextLine();
				strArr[x] = string;
			}
			return strArr;
	}
}
