package task.string;

import utils.InvalidInputException;
import utils.UtilityActions;

public class StringTask{
	public int getLen(String str)throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.length();
	}

	// convert string to character array
	public char[] toCharArr(String str)throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.toCharArray();		
	}
	// find character in a string by position
	public char findTargetChar(String str, int pos) throws InvalidInputException{
	int len=getLen(str);
	UtilityActions.checkPosition(len,pos);
	return str.charAt(pos);
	}
    // find number of occurences of character in a string
	public int getOccurence(String str,char character)throws InvalidInputException{
		
	int index=str.indexOf(character);
	int count=0;
	while(index!=-1){
		count++;
		index=str.indexOf(character,index+1);
	}
	return count;
	}
	// find last index of a character in a given string
	public int findLastIndex(String str,String character)
	 throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.lastIndexOf(character);
		//return str.indexOf(character);

	}
	// create a substring
	public String createSubstring(String str,int startNo,int endNo)
	 throws InvalidInputException{
		int len=getLen(str);
		UtilityActions.checkPosition(len,startNo);
		UtilityActions.checkPosition(len,endNo);
		return str.substring(startNo,endNo);
	}
	// when no end num is given to create substring
	public String createSubstring(String str,int startNo) 
	throws InvalidInputException{
		int endNo=getLen(str);
		return createSubstring(str,startNo,endNo);		
	}
	// when first n characters are required
	public String createSubstring(int endNo,String str) 
	throws InvalidInputException{
		return createSubstring(str,0,endNo);  		
	}
	//replace first matching substring with the given letters
	public String replaceLetters(String str,int start,int end,String replacement) 
	throws InvalidInputException{
		UtilityActions.checkNull(replacement,"Invalid Input : "+
		"The replacement substring is null");
		String newString=createSubstring(str,start,end);
		return str.replaceFirst(newString,replacement);
	}
	//check if string starts with the given prefix
	public boolean isStartingWith(String str,String subSt)
	 throws InvalidInputException{
		UtilityActions.checkNull(str);
		UtilityActions.checkNull(subSt,"Invalid Input : The Substring is null");
		return str.startsWith(subSt);

	}
	//check if string ends with the given suffix
	public boolean isEndingWith(String str,String subSt) 
	throws InvalidInputException{
		UtilityActions.checkNull(str);
		UtilityActions.checkNull(subSt,"Invalid Input : The Substring is null");
		return str.endsWith(subSt);
	}
	//convert to lowercase
	public String toLower(String str) throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.toLowerCase();
	}
	//convert to uppercase
	public String toUpper(String str) throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.toUpperCase();
	}

	//reverse a string
	public String reverseString(String str) throws InvalidInputException{
		char[] charArr=toCharArr(str);
		int len=charArr.length;
		char[] revCharArr=new char[len];
		int j=0;
		for (int i=len-1;i>=0;i--){
			revCharArr[j]=charArr[i];
			j++;
		}
		return String.valueOf(revCharArr);
	}
	//replace all matching elements in a string
	public String replaceAllMatch(String str,String presentStr,String replacementStr)
	 throws InvalidInputException{ //returns same string if replacement is null
		return str.replaceAll(presentStr,replacementStr);   
	}
	//split a sentence to words and store in array
	public String[] splitLine(String str,String splitter)throws InvalidInputException{
		UtilityActions.checkNull(str);
		String[] strArr = str.split(splitter);
		return strArr;
	}
	//check if equal (case sensitive)
	public boolean isEqualCaseSensitive(String str,String compString)
	throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.equals(compString);  //returns false if argument is null
	}
	//check if equal (not case sensitive)
	public boolean isEqualNotCaseSensitive(String str,String compString)
	throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.equalsIgnoreCase(compString);  //returns false if argument is null
	}
	//remove trailing spaces
	public String removeTrailingSpace(String str)throws InvalidInputException{
		UtilityActions.checkNull(str);
		return str.trim();
	}
	public String appendWithDelimiter(String[] str,CharSequence delimiter)
	throws InvalidInputException{ //throws NullPointerException if any argument is null
		return String.join(delimiter, str);   
	}		
}
