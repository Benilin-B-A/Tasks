import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import task.regex.RegExTask;
import utils.InvalidInputException;

@Category(FastTests.class)
public class ValidateTests {
	
	//@Category(FastTests.class)
	@Test
	public void test() {
		RegExTask task = new RegExTask();
		try {
			assertEquals(true,task.validateMobile("9791289041"));
		}
		catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
	
	//@Category(FastTests.class)
	@Test
	public void test1() {
		RegExTask task = new RegExTask();
		try {
			assertEquals(true,task.validateMobile("3791289041"));
		}
		catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
	

}
