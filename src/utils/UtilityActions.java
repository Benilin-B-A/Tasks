package utils;

public class UtilityActions{
	
	public static void checkNull(Object obj)throws InvalidInputException{
		checkNull(obj,"Invalid Input : The Object is null");
	}
	public static void checkNull(Object obj,String message)throws InvalidInputException{
		if (obj==null){
			throw new InvalidInputException(message);
		}
	}
	
	public static void checkPosition(int len,int start,int end)throws InvalidInputException{
		checkPosition(len,start);
		checkPosition(len,end);
		if(start>end) {
			throw new InvalidInputException("Invalid input : start position > end position");
		}
	}
	public static void checkPosition(int len,int position)throws InvalidInputException{
		if(position<0 || position>=len){
		throw new InvalidInputException("Invalid Input : "+
		"Length of Object is "+len+" and the entered start/end position is "+ position);
		}
	}
	
}
