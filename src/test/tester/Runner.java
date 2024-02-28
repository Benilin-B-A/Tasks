package test.tester;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {

		try (FileInputStream fIn = new FileInputStream("/home/benlin-pt7278/eclipse-workspace/Object.txt");
				ObjectInputStream oIn = new ObjectInputStream(fIn)) {

			@SuppressWarnings("unchecked")
			List<ArrayList<TrialObj>> list = (List<ArrayList<TrialObj>>) oIn.readObject();
			System.out.println(list);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
