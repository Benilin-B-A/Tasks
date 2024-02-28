package test.tester;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args){
		TrialObj obj1 = new TrialObj(45,"badhb");
		TrialObj obj2 = new TrialObj(45,"hfshf");
		TrialObj obj3 = new TrialObj(45,"ekhf");
		TrialObj obj4 = new TrialObj(45,"Miwrui");
		TrialObj obj5 = new TrialObj(45,"ehur");
		List<TrialObj> list1 = new ArrayList<TrialObj>();
		List<ArrayList<TrialObj>> list2 = new ArrayList<ArrayList<TrialObj>>();
		list1.add(obj1);
		list1.add(obj2);
		list1.add(obj3);
		list1.add(obj4);
		list1.add(obj5);
		list2.add((ArrayList<TrialObj>) list1);
		try(FileOutputStream fOut = new FileOutputStream("/home/benlin-pt7278/eclipse-workspace/Object.txt");
			    ObjectOutputStream oOut = new ObjectOutputStream(fOut);){
			 oOut.writeObject(list2);
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}	    
	}
}
