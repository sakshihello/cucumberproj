package cucumberframeworkpkg;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(tags="@Smoke",
		features={"C:\\Users\\hp\\eclipse-workspace\\cucumberframework\\src\\test\\resources\\featurefile\\pizza.feature"}
		,glue= {"cucumberframeworkpkg"},
	     dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports"}
				
		)
public class TestRunner {

	
	
	
		
	
}
