package task.stringbuilder;

import utils.InvalidInputException;
import utils.UtilityActions;

public class StringBuilderTask{
	
	public StringBuilder createStrBuilder(String str)throws InvalidInputException{ 
		UtilityActions.checkNull(str);  //create stringbuilder from string
		return new StringBuilder(str);
	}
	
	public static int getLen(StringBuilder strB)throws InvalidInputException{
		UtilityActions.checkNull(strB);  //get length of stringbuilder
		return strB.length();
	}
	
	public StringBuilder addString(StringBuilder strB,String str)
	throws InvalidInputException{
		int len=getLen(strB);
		return addString(strB,str,len); //add string at end of stringbuilder
	}
	
	public StringBuilder addString(StringBuilder strB,String str,int position)
	throws InvalidInputException{
		int len=getLen(strB);
		UtilityActions.checkPosition(len,position);
		return strB.insert(position,str); //insert string at any index of stringbuilder
	}
	
	public StringBuilder addString
	(StringBuilder strB,String str,String delim) //I*delim*INDIA
	throws InvalidInputException{    //insert str in the middle of a strB
		UtilityActions.checkNull(strB);
		UtilityActions.checkNull(delim);
		int ind=strB.indexOf(delim);
		strB=addString(strB,delim,ind);  //I*delim**delim*INDIA
		int index=ind+delim.length();
		return addString(strB,str,index);//I*delim*LOVE*delim*INDIA
	}
	
	public StringBuilder addString(StringBuilder strB,String delim,String[] strArr)
	throws InvalidInputException{
		UtilityActions.checkNull(strB);
		strB=strB.append(delim);  //add strings at end of stringbuilder with delimiter
		StringBuilder strB1=createWithDelim(strArr,delim);
		String str=strB1.toString();
		return addString(strB,str);
	}
	
	public int findLastIndex(StringBuilder strB,String targetChar)
	throws InvalidInputException{  //find last occurence of character
		checkNull(strB,targetChar);
		return strB.lastIndexOf(targetChar);
	}
	
	public int findFirstIndex(StringBuilder strB,String targetChar)
	throws InvalidInputException{  //find first occurence of character
		checkNull(strB,targetChar);
		return strB.indexOf(targetChar);
	}
	
	public StringBuilder deleteElem(StringBuilder strB,String delim,int nElem)
	throws InvalidInputException{	//deletes n strings in a strinbuilder
		UtilityActions.checkNull(strB);
		UtilityActions.checkNull(delim);
		int deleteIndex=0;
		int fromIndex=0;
		int len = delim.length();
		for(int i=0;i<nElem;i++){
			deleteIndex=strB.indexOf(delim,fromIndex);
			fromIndex+=deleteIndex+len;
		}
		return deleteElem(strB,0,deleteIndex+1);
	}
	
	public StringBuilder deleteElem(StringBuilder strB,int start,int end)
	throws InvalidInputException{  //deletes target indices in a stringbuilder
		int len=getLen(strB);
		UtilityActions.checkPosition(len,start,end);
		return strB.delete(start,end);
	}
	
	public StringBuilder replaceAllMatch  //replace all matches in a stringbuilder
	(StringBuilder strB,String target,String replacement)throws InvalidInputException{
		UtilityActions.checkNull(strB);
		UtilityActions.checkNull(replacement);
		UtilityActions.checkNull(target);
		int i = strB.indexOf(target);
		int len = replacement.length();
		while(i!=-1){
			int j=i+len;
			strB.replace(i,j,replacement);
			i=strB.indexOf(target,j);
		}
	return strB;
	}
	
	public StringBuilder reverseStrBuilder(StringBuilder strB)
	throws InvalidInputException{   //reverse a stringbuilder
		UtilityActions.checkNull(strB);
		return strB.reverse(); 
	} 
	
	public StringBuilder createWithDelim(String[] strArray,String delim)
	throws InvalidInputException{   		//create a stringbuilder with multiple 
		UtilityActions.checkNull(strArray); //strings with a delimiter inbetween
		StringBuilder strBuild = createStrBuilder(strArray[0]);
		int len=strArray.length;
		for(int i=1;i<len;i++){
			strBuild = strBuild.append(delim);
			strBuild = strBuild.append(strArray[i]);
		}
		return strBuild;
	}
	
	public StringBuilder replaceStr
	(StringBuilder strB,int start,int end,String replacement)
	throws InvalidInputException{			//replace string in target indices
		int len=getLen(strB);    //till end if end pos is invalid
		UtilityActions.checkNull(replacement);
		UtilityActions.checkPosition(len,start); 
		return strB.replace(start,end,replacement);
	} 
	
	private void checkNull(StringBuilder strB,String str)
	throws InvalidInputException{
		UtilityActions.checkNull(strB);
		UtilityActions.checkNull(str,"The character whose index is"+
		" to be found is null");
	} 
}
