package test.arraylist;

import java.util.Scanner;
import task.arraylist.ArrayListTask;
import utils.InvalidInputException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class ArrayListRunner{
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);	
		int i=1;
		while(i<2){
			i--;
			System.out.print("Enter your choice of task ( 1-18 ) : ");
			int choice = scan.nextInt();
			scan.nextLine();
			ArrayListTask task1= new ArrayListTask();
			switch(choice)	{
				
				case 1:		
					try {
						ArrayList<Object> arrList=(ArrayList<Object>) task1.createArrList(Object.class);
						printArrListSize(arrList);
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					
					break;
				
				case 2:
					try{
						ArrayList<String> arrList1=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList1,scan);					
						printArrListSize(arrList1);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					
					break;
				
				case 3:
					try {
						ArrayList<Integer> arrList2=(ArrayList<Integer>) task1.createArrList(Integer.class);
						addInt(arrList2, scan);
						printArrListSize(arrList2);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					
					break;
				
				case 4:
					try {
						ArrayList<Object> arrList3=(ArrayList<Object>) task1.createArrList(Object.class);
						Custom cus=new Custom();
						task1.addObj(arrList3,cus);
						printArrListSize(arrList3);
					}
					catch(InvalidInputException exception) {
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					
					
					break;
					
				case 5:
					try {
						@SuppressWarnings("rawtypes") ArrayList arrList4=(ArrayList) task1.createArrList(Object.class);
						addString(arrList4, scan);
						addInt(arrList4, scan);
						Custom cus=new Custom();
						task1.addObj(arrList4, cus);
						printArrListSize(arrList4);							
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 6:
					try {
						ArrayList<String> arrList5=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList5, scan);;					
						printArrListSize(arrList5);
						System.out.println("Enter String whose index you want to check : ");
						String str=scan.nextLine();
						int ind=task1.getIndex(arrList5,str);
						if(ind!=-1) {
							System.out.println("The String is at index "+ind);
						}
						else {
							System.out.println("The String is not present");
						}
						
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 7:
					try{
						ArrayList<String> arrList6=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList6, scan);
						Iterator<String> iter=task1.createIterator(arrList6);
						int size=ArrayListTask.getSize(arrList6);
						for(int x=0;x<size;x++) {
							System.out.println(iter.next());
						}
						
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 8:
					try{
						ArrayList<String> arrList7=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList7,scan);					
						printArrListSize(arrList7);
						System.out.println("Which index do you want to fetch ? :");
						int index=scan.nextInt();
						scan.nextLine();
						String indStr=task1.fetchIndex(arrList7,index);
						System.out.println("The String at index "+index+" is "+indStr);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 9:
					try{
						ArrayList<String> arrList8=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList8,scan);					
						printArrListSize(arrList8);
						System.out.println("Enter the String whose first and last index you want to check :");
						String str=scan.nextLine();
						int firstInd=task1.findFirstIndex(arrList8,str);
						if(firstInd!=-1) {
							int lastInd=task1.findLastIndex(arrList8,str);
							System.out.println("The first and last index are "+firstInd+", "+lastInd);
						}
						else {
							System.out.println("The String isn't present");
						}
						
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 10:
					try{
						ArrayList<String> arrList9=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList9,scan);					
						printArrListSize(arrList9);
						System.out.println("Enter String to add :");
						String str=scan.nextLine();
						System.out.println("Enter index to add string : ");
						int index=scan.nextInt();
						scan.nextLine();
						task1.insertStr(arrList9,str,index);
						printArrListSize(arrList9);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
				
				case 11:
					try{
						ArrayList<String> arrList10=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList10,scan);					
						printArrListSize(arrList10);
						System.out.print("Enter start position : ");
						int start=scan.nextInt();
						System.out.print("Enter end position : ");
						int end=scan.nextInt();
						scan.nextLine();
						List<String> subArrList=task1.createSubArrList(arrList10,start,end);
						printArrListSize(subArrList);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break; 
					
				case 12:
					
					try{
						ArrayList<String> arrList11=(ArrayList<String>) task1.createArrList(String.class);
						ArrayList<String> arrList12=(ArrayList<String>) task1.createArrList(String.class);
						ArrayList<String> arrList13=(ArrayList<String>) task1.createArrList(String.class);
						System.out.println("First ArrayList");
						addString(arrList11,scan);
						printArrListSize(arrList11);
						System.out.println("(2nd ArrayList) :");
						addString(arrList12,scan);					
						System.out.println("Second ArrayList");
						printArrListSize(arrList12);
						task1.mergeArrList(arrList13,arrList11,arrList12);
						System.out.println("Merged ArrayList");
						printArrListSize(arrList13);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 13:
					
					try{
						ArrayList<String> arrList14=(ArrayList<String>) task1.createArrList(String.class);
						ArrayList<String> arrList15=(ArrayList<String>) task1.createArrList(String.class);
						ArrayList<String> arrList16=(ArrayList<String>) task1.createArrList(String.class);
						System.out.println("First ArrayList");
						addString(arrList14,scan);						
						printArrListSize(arrList14);
						System.out.println("Second ArrayList");
						addString(arrList15,scan);					
						printArrListSize(arrList15);
						task1.mergeArrList(arrList16,arrList15,arrList14);
						System.out.println("Merged ArrayList");
						printArrListSize(arrList16);
					}
					catch(InputMismatchException exception){
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
				
				case 14:
					
					try{
						ArrayList<Float> arrList17=(ArrayList<Float>) task1.createArrList(Float.class);
						System.out.println("How many float numbers do you want to enter? :");
						int nFlt=scan.nextInt();
						scan.nextLine();
						for(int x=1;x<=nFlt;x++) {
							System.out.println("Enter float value : ");
							float flt=scan.nextFloat();
							task1.addFloat(arrList17,flt);					
						}
						printArrListSize(arrList17);
						System.out.println("Enter index of value to remove : ");
						int index=scan.nextInt();
						scan.nextLine();
						task1.removeFloat(arrList17,index);
						printArrListSize(arrList17);
						
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 15:
					
					try{
						ArrayList<String> arrList18=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList18,scan);						
						printArrListSize(arrList18);
						System.out.print("Enter start position for subList : ");
						int start=scan.nextInt();
						scan.nextLine();
						System.out.print("Enter end position for subList : ");
						int end=scan.nextInt();
						scan.nextLine();
						List<String> subArrList=task1.createSubArrList(arrList18,start,end);
						printArrListSize(subArrList);
						task1.removeMatches(arrList18,subArrList);
						printArrListSize(arrList18);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 16:
					
					try{
						ArrayList<String> arrList19=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList19,scan);					
						printArrListSize(arrList19);
						System.out.print("Enter start position for subList : ");
						int start=scan.nextInt();
						scan.nextLine();
						System.out.print("Enter end position for subList : ");
						int end=scan.nextInt();
						scan.nextLine();
						List<String> subArrList=task1.createSubArrList(arrList19,start,end);
						printArrListSize(subArrList);
						task1.removeNonMatches(arrList19,subArrList);
						printArrListSize(arrList19);
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 17:
					
					try{
						ArrayList<Long> arrList20=(ArrayList<Long>) task1.createArrList(Long.class);
						System.out.println("How many long values do you want to enter? :");
						int nLong=scan.nextInt();
						scan.nextLine();
						for(int x=1;x<=nLong;x++) {
							System.out.println("Enter long value : ");
							long lng=scan.nextLong();
							scan.nextLine();
							task1.addLong(arrList20,lng);					
						}
						printArrListSize(arrList20);
						System.out.println("Cleared ArrayList : ");
						task1.clearArrList(arrList20);
						printArrListSize(arrList20);
						
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					}
					catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					break;
					
				case 18:
					
					try{
						ArrayList<String> arrList21=(ArrayList<String>) task1.createArrList(String.class);
						addString(arrList21,scan);					
						printArrListSize(arrList21);
						System.out.println("Enter String whose presence you want to check :");
						String str=scan.nextLine();
						boolean isPresent=task1.checkPresence(arrList21,str);
						if(isPresent) {
							int index=task1.getIndex(arrList21, str);
							System.out.println("The string is present at index, "+index);
						}
						else {
							System.out.println("The String isn't present");
						}
					}
					catch(InputMismatchException exception) {
						System.out.println("Incorrect Input Type");
					}
					catch(InvalidInputException exception){
						exception.printStackTrace();
					} catch (ReflectiveOperationException exception) {
						exception.printStackTrace();
					}
					
					break;
					
			}
		System.out.print("Do you want to continue? (y/yes) : ");
		String cont=scan.nextLine();
		if(cont.equalsIgnoreCase("y")||cont.equalsIgnoreCase("yes")){
			i++;
		}
		else{
			break;
		}	
		}
		scan.close();
		
	}
public static<T> void printArrListSize(List<T> arrList){
	try {
		int size=ArrayListTask.getSize(arrList);
		System.out.println("The ArrayList is "+arrList+" with size "+size);
	}
	catch(InvalidInputException exception) {
		exception.printStackTrace();
	}
	}
public static void addString(List<String> arrList,Scanner scan) 
		throws InvalidInputException,InputMismatchException{
	System.out.println("How many strings do you want to enter ? :");
		int nStr=scan.nextInt();
		scan.nextLine();

		for(int x=1;x<=nStr;x++) {
			System.out.println("Enter String : ");
			String str=scan.nextLine();
			ArrayListTask.addStr(arrList,str);

		}
}
public static <T> void addInt(List<Integer> arrList,Scanner scan) 
		throws InvalidInputException,InputMismatchException{
	System.out.println("How many integers do you want to enter ? :");
		int nInt=scan.nextInt();
		scan.nextLine();

		for(int x=1;x<=nInt;x++) {
			System.out.println("Enter Integer : ");
			int num =scan.nextInt();
			scan.nextLine();
			ArrayListTask.addInt(arrList,num);
		}
}

}