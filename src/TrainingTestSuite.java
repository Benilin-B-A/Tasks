import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.experimental.categories.Categories;

//@RunWith(Suite.class)
@RunWith(Categories.class)

@Categories.IncludeCategory(FastTests.class)

@Suite.SuiteClasses({ StringTest.class, ValidateTests.class })

public class TrainingTestSuite {
}
