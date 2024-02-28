import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import task.string.StringTask;
import utils.InvalidInputException;

public class StringTest {
	@Category(SlowTests.class)
	@Test
	public void test() {
		StringTask stringTask = new StringTask();
		try {
			assertEquals(7,stringTask.getLen("benilin"));
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

}
