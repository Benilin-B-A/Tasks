package test.hashmap;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import task.hashmap.HashMapTask;
import utils.InvalidInputException;

public class HashMapRunner {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		HashMapTask task= new HashMapTask();
		boolean c=true;
		while(c){
			int choice; 
			System.out.println("Enter your choice of task ( 1-20 )"
					+"\n 1)  Create a HashMap"
					+"\n 2)  Create HashMap<String,String> and enter key value pairs"
					+"\n 3)  Create HashMap<Integer,Integer> and enter key value pairs"
					+"\n 4)  Create HashMap<String,Integer> and enter key value pairs"
					+"\n 5)  Create HashMap<String,Car> and enter key value pairs"
					+"\n 6)  Create HashMap<String,String> and enter key value pairs + one null value"
					+"\n 7)  Create HashMap<String,String> and enter key value pairs + one null key"
					+"\n 8)  Check if a key is present in the HashMap"
					+"\n 9)  Check if a value is present in the HashMap"
					+"\n 10) Create HashMap<String,String> and enter key value pairs and change"
					+ 		 " value for each key"
					+"\n 11) Fetch Value for a key in a HashMap"
					+"\n 12) Get value of non existing key"
					+"\n 13) Insert a String as value if required key isn't present"
					+"\n 14) Remove a key from a HashMap"
					+"\n 15) Remove a key from HashMap only if entered value matches"
					+"\n 16) Replace value of a key from HashMap"
					+"\n 17) Replace a value of key only if mapped to the given value"
					+"\n 18) Transfer values from one HashMap to another"
					+"\n 19) Iterate and print key and values in a HashMap"
					+"\n 20) Clear all entries from a HashMap");
			System.out.print("Enter Choice : ");
			choice = scan.nextInt();
			System.out.print("\n");
			scan.nextLine();
			
			switch(choice){
				
			case 1:	//create a HashMap and print it and it's size
				
				HashMap<Integer,String> hMap1=HashMapTask.getHashMap();
				printMapSize(hMap1);
				
				break;
			
			case 2: //Create HashMap<String,String> and enter key value pairs
				
				HashMap<String,String> hMap2=addStrKeyVal(scan);
				printMapSize(hMap2);
				
				break;
				
			case 3:  //Create HashMap<Integer,Integer> and enter key value pairs
				
				HashMap<Integer,Integer> hMap3=HashMapTask.getHashMap();
				try {
					System.out.print("How many key, value pairs do you want to enter ? : ");
					int num1=scan.nextInt();
					System.out.print("\n");
					scan.nextLine();
					for(int j=0;j<num1;j++) {
						System.out.print("Enter key: ");
						int key=scan.nextInt();
						scan.nextLine();
						System.out.print("Enter value: ");
						int val=scan.nextInt();
						scan.nextLine();
						System.out.print("\n");
						HashMapTask.insertEntry(hMap3,key, val);
					}
				}
				catch(InvalidInputException exception){
					exception.printStackTrace();
				}
				catch (InputMismatchException exception) {
					System.out.println("Incorrect Input : Try Again...");
				}
				
				printMapSize(hMap3);
				
				break;
				
			case 4:  //Create HashMap<String,Integer> and enter key value pairs
				
				HashMap<String,Integer> hMap4=HashMapTask.getHashMap();
				try {
					System.out.print("How many key, value pairs do you want to enter ? : ");
					int num2=scan.nextInt();
					System.out.print("\n");
					scan.nextLine();
					for(int j=0;j<num2;j++) {
						System.out.print("Enter key: ");
						String key=scan.nextLine();
						System.out.print("Enter value: ");
						int val=scan.nextInt();
						scan.nextLine();
						System.out.print("\n");
						HashMapTask.insertEntry(hMap4,key, val);
					}
				}
				catch(InvalidInputException exception){
					exception.printStackTrace();
				}
				catch (InputMismatchException exception) {
					System.out.println("Incorrect Input : Try Again...");
				}
				
				
				printMapSize(hMap4);
				
				break;
				
			case 5:  //Create HashMap<String,Car> and enter key value pairs
				
				HashMap<String,Car> hMap5=HashMapTask.getHashMap();
				Car benz=new Car();
				Car mustang=new Car();
				Car dodge=new Car();
				hMap5.put("Benilin", benz);
				hMap5.put("Jeffrey", mustang);
				hMap5.put("Hari", dodge);
				printMapSize(hMap5);
				
				break;
				
			case 6:  //Create HashMap<String,String> and enter key value pairs + one null value
				
				HashMap<String,String> hMap6=addStrKeyVal(scan);
				
				hMap6.put("Key of null",null);
				printMapSize(hMap6);
				
				break;
				
			case 7:  //Create HashMap<String,String> and enter key value pairs + one null key
				
				HashMap<String,String> hMap7=addStrKeyVal(scan);				
				hMap7.put(null,"Zoho");
				printMapSize(hMap7);
				
				break;
				
			case 8:  //Check if a key is present in the HashMap
				
				HashMap<String,String> hMap8=addStrKeyVal(scan);
				System.out.print("Enter key whose presence you want to check : ");
				String checkKey=scan.nextLine();
				System.out.print("\n");
				try {
					String string=task.getValue(hMap8,checkKey);
					if(string!=null) {
						System.out.println("Key is present");
					}
					else {
						boolean keyPresence=task.checkKeyPresence(hMap8, checkKey);
						if(keyPresence) {
							System.out.println("Key is present");
						}
						else {
							System.out.println("Key is not present");
						}
					}
					
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				
				break;
				
			case 9:  //Check if a value is present in the HashMap
				
				HashMap<String,String> hMap9=addStrKeyVal(scan);
				System.out.print("Enter value whose presence you want to check : ");
				String checkVal=scan.nextLine();
				try {
					boolean valPresent=task.checkValPresence(hMap9,checkVal);
					System.out.print("\n");
					if(valPresent) {
						System.out.println("Value is present");
					}
					else {
						System.out.println("Value is not present");
					}
				}
				catch(InvalidInputException exception){
					exception.printStackTrace();
				}
				
				break;
				
			case 10:  //Change Values for each key in HashMap
				
				HashMap<String,String> hMap10=addStrKeyVal(scan);
				printMapSize(hMap10);
				try {
					Set<String> map10Key=task.getKeySet(hMap10);
					for(String keyStr:map10Key) {
						System.out.print("Enter new Value for Key "+keyStr+" : ");
						String newVal=scan.nextLine();
						task.replaceKeyVal(hMap10, keyStr, newVal);
					}
					printMapSize(hMap10);
				}
				catch (InputMismatchException exception) {
					System.out.println("Incorrect Input : Try Again...");
				}				
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 11:  //Fetch Value for a key in a HashMap
				
				HashMap<String,String> hMap11=addStrKeyVal(scan);
				
				try {
					System.out.print("Enter key whose value you want to fetch : ");
					String getKey=scan.nextLine();
					String valString=task.getValue(hMap11,getKey);
					System.out.println("The value for entered key is : "+valString);						
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
		
			case 12:  //get value of non existing key
				
				HashMap<String,String> hMap12=addStrKeyVal(scan);
				
				try {
					System.out.print("Enter key whose value you want to fetch : ");
					String getKey=scan.nextLine();
					String valString=task.getValue(hMap12,getKey);
					System.out.println("The value for entered key is : "+valString);						
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 13: //get a String as value if key is not present
				
				HashMap<String,String> hMap13=addStrKeyVal(scan);
				
				try {
					System.out.print("Enter key whose value you want to fetch : ");
					String getKey=scan.nextLine();
					/*System.out.print("Enter String to add as value if key is not present : ");
					String str=scan.nextLine();
					String valString=task.getValue(hMap13,str);
					System.out.println("The value for entered key is : "+valString);
					task.insertIfAbs(hMap13,getKey,str);
					printMapSize(hMap13);*/
					
					String str=task.getDefault(hMap13,getKey,"Zoho");
					System.out.println(str);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 14://remove a key from a hashmap
				
				HashMap<String,String> hMap14=addStrKeyVal(scan);
				printMapSize(hMap14);
				try {
					System.out.print("Enter Key to remove : ");
					String rKey=scan.nextLine();
					task.removeKey(hMap14,rKey);
					printMapSize(hMap14);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 15://remove a key from a hashmap only if entered value matches
				
				HashMap<String,String> hMap15=addStrKeyVal(scan);
				printMapSize(hMap15);
				try {
					System.out.print("Enter Key to remove : ");
					String rKey=scan.nextLine();
					System.out.print("Enter Value of key : ");
					String rVal=scan.nextLine();
					task.removeKey(hMap15,rKey,rVal);
					printMapSize(hMap15);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 16://replace value of key from HashMap
				
				HashMap<String,String> hMap16=addStrKeyVal(scan);
				printMapSize(hMap16);
				try {
					System.out.print("Enter Key whose value needs to be replaced : ");
					String replaceKey=scan.nextLine();
					System.out.print("Enter new Value : ");
					String replaceVal=scan.nextLine();
					task.replaceKeyVal(hMap16,replaceKey,replaceVal);
					printMapSize(hMap16);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 17://Replace a value of key only if mapped to the given value
				
				HashMap<String,String> hMap17=addStrKeyVal(scan);
				printMapSize(hMap17);
				try {
					System.out.print("Enter Key whose value needs to be replaced : ");
					String replaceKey=scan.nextLine();
					System.out.print("Enter existing value : ");
					String oldVal=scan.nextLine();
					System.out.print("Enter new Value : ");
					String replaceVal=scan.nextLine();
					task.replaceKeyVal(hMap17,replaceKey,oldVal,replaceVal);
					printMapSize(hMap17);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 18:  //copy all mappings from one HashMap to Another
				
				HashMap<String,String> hMap18_1=addStrKeyVal(scan);
				System.out.print("First HashMap : ");				
				printMapSize(hMap18_1);
				HashMap<String,String> hMap18_2=addStrKeyVal(scan);
				System.out.print("Second HashMap : ");				
				printMapSize(hMap18_2);
				try {
					task.mergeMap(hMap18_1,hMap18_2);
					System.out.print("\n Merged HashMap : ");
					printMapSize(hMap18_1);
				}
				catch (InputMismatchException exception){
					System.out.println("Incorrect Input : Try Again...");
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 19://Iterate and print key and values in a HashMap
				
				HashMap<String,String> hMap19=addStrKeyVal(scan);
				try {
					Set<String> map10Key=task.getKeySet(hMap19);
					for(String keyStr:map10Key) {
						String valStr=task.getValue(hMap19,keyStr);
						System.out.print(keyStr+" : "+valStr+"\n");
					}
				}
				catch (InputMismatchException exception) {
					System.out.println("Incorrect Input : Try Again...");
				}				
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
				
			case 20://clear all entries from a hashmap
				
				HashMap<String,String> hMap20=addStrKeyVal(scan);
				printMapSize(hMap20);
				try {
					task.clearAllEntries(hMap20);
					printMapSize(hMap20);
				}
				catch(InvalidInputException exception) {
					exception.printStackTrace();
				}
				
				break;
			}
			System.out.print("Hit Enter to continue...");
			String cont=scan.nextLine();
			if(!cont.equals("")){
				c=false;
			}			
		}
		scan.close();
		System.out.println("Scanner is closed...");
	}

	private static HashMap<String, String> addStrKeyVal(Scanner scan) {
		HashMap<String, String> hMap=HashMapTask.getHashMap();
		try {
			System.out.print("How many key, value pairs do you want to enter ? : ");
			int num=scan.nextInt();
			System.out.print("\n");
			scan.nextLine();
			for(int j=0;j<num;j++) {
				System.out.print("Enter key: ");
				String key=scan.nextLine();
				System.out.print("Enter value: ");
				String val=scan.nextLine();
				System.out.print("\n");
				HashMapTask.insertEntry(hMap,key, val);
			}
		}
		catch(InvalidInputException exception){
			exception.printStackTrace();
		}
		catch (InputMismatchException exception) {
			System.out.println("Incorrect Input : Try Again...");
		}
		return hMap;
		
	}

	private static <K,V> void printMapSize(HashMap<K, V> hMap) {
		try {
			int size=HashMapTask.getSize(hMap);
			System.out.println("The size of HashMap "+hMap+" is, "+size);			
		}
		catch(InvalidInputException exception){
			exception.printStackTrace();
		}		
	}
	
	/*public static <K,V>void getKeyValPair(HashMap<K,V> hMAp,Scanner scan) {
		System.out.println("How many key, value pairs do you want to enter ? : ");
		int num=scan.nextInt();
		for(int i=0;i<num;i++) {
			System.out.print("Enter key: ");
			int key=scan.next<K>();
			
		}
	}*/
}

