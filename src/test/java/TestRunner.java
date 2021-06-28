import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import salesforce.ReportingUtils;

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void generateReport() {
        ReportingUtils.generateJVMReport();
    }


}