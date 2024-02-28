package task.arraylist;

import java.util.Iterator;
import java.util.List;

import utils.InvalidInputException;
import utils.UtilityActions;

public class ArrayListTask{
	
	public static <E>int getSize(List<E> list)throws InvalidInputException{ //returns size of ArrayList
		UtilityActions.checkNull(list);
		return list.size();
	}
	@SuppressWarnings({ "unchecked" })
	public <E> List<E> createArrList(Class<E> elemType)throws ReflectiveOperationException{	//creates an ArrayList
        return (List<E>)Class.forName("java.util.ArrayList").getConstructor().newInstance();
	}
	
	public static boolean addStr(List<String> list, String str)	//add String to ArrayList
			throws InvalidInputException{
		UtilityActions.checkNull(list);			
		return list.add(str);
	}
	public static boolean addInt(List<Integer> list,int num)		//add Integer to ArrayList
			throws InvalidInputException{
		UtilityActions.checkNull(list);
		return list.add(num);
	}
	public void addFloat(List<Float> list, float flt)		//add Float to ArrayList
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		list.add(flt);	
		
	}
	public boolean addLong(List<Long> list, long lng) 		//add Long to ArrayList
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.add(lng);
	}
	@SuppressWarnings("unchecked")
	public boolean addObj(@SuppressWarnings("rawtypes") List list,Object obj)				//add custom Objects to ArrayList
			throws InvalidInputException{
		UtilityActions.checkNull(list);
		return list.add(obj);
	}
	public int getIndex(List<String> list,String str)		//find index of String in ArrayList
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.indexOf(str);
	}
	public Iterator<String> createIterator(List<String> list)//creates a ListIterator for the ArrayList
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.listIterator();
	}
	public String fetchIndex(List<String> list, int index)	//Find the String at given index
			throws InvalidInputException{
		UtilityActions.checkNull(list);
		int len=getSize(list);
		UtilityActions.checkPosition(len,index);
		return list.get(index);
	}
	public int findFirstIndex(List<String> list, String str) //find first occurrence of String
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.indexOf(str);
	}
	public int findLastIndex(List<String> list, String str)	//find last occurrence of String
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.lastIndexOf(str);
	}
	public void insertStr(List<String> list, String str, int index) //insert String at given index
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		int len=getSize(list);
		UtilityActions.checkPosition(len,index);
		list.add(index,str);
	}
	public List<String> createSubArrList(List<String> list, int start, int end)
			throws InvalidInputException {						//create AL from existing AL by index range
		UtilityActions.checkNull(list);
		int len=getSize(list);
		UtilityActions.checkPosition(len, start,end);	
		return list.subList(start,end);
	}
	public boolean mergeArrList(List<String>list ,List<String> rootList, List<String> toAddList)
			throws InvalidInputException  {			//adds elements in list1 and list2 to list
		UtilityActions.checkNull(list);
		UtilityActions.checkNull(rootList);
		UtilityActions.checkNull(toAddList);
		list.addAll(rootList);
		return list.addAll(toAddList);
	}
	public void removeFloat(List<Float> list, int index)
			throws InvalidInputException {			//removes float from said index
		UtilityActions.checkNull(list);			
		int len=getSize(list);
		UtilityActions.checkPosition(len, index);
		list.remove(index);
	}
	public boolean removeMatches(List<String> list, List<String> sublist)//removes elements in sublist from list
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		UtilityActions.checkNull(sublist);
		return list.removeAll(sublist);	
	}
	
	public void clearArrList(List<Long> list)throws InvalidInputException{//clear all elements
		UtilityActions.checkNull(list);
		list.clear();
	}
	public boolean removeNonMatches(List<String> list, List<String> sublist)
			throws InvalidInputException {			//remove non matching strings in sublist from list
		UtilityActions.checkNull(list);
		UtilityActions.checkNull(sublist);
		return list.retainAll(sublist);
	}
	public boolean checkPresence(List<String> list, Object obj)//check if str is present in list
			throws InvalidInputException {
		UtilityActions.checkNull(list);
		return list.contains(obj);
	}
}
