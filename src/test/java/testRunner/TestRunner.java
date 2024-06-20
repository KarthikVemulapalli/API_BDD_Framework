package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue = {"stepDefinitions"}
		,stepNotifications = true
		,plugin = {"html:reports/cucumber-json-reports/report.html", //Cucumber reports generation
			"json:reports/cucumber-json-reports/report.json",
			"junit:reports/cucumber-json-reports/report.xml"}
//		,tags = "@DeletePlace"
		)

public class TestRunner {
	/* Execute through CommandPrompt, using 'test' will compile & execute test cases
	 		mvn test
	 	Execute through CommandPrompt by providing specific tagName.
	 		mvn test -Dcucumber.options="--tags @AddPlace"
		To generate html reports
			mvn test verify
	 */
	
	/* Error Face while running tests through CommanPrompt,
			Issue - After Executing through cmd, at last the testRun 0, failures 0. But the report is generating good.
			Reason - If you add both 'cucumber-testng' & 'cucumber-junit' dependencies in pom.xml. Java searches for testNG test cases.
						But in this project the tests are related to junit, so count is displayed.
			Solution - Keep only one dependency suitable for framework
	 */
	
	/* <!-- Cucumber Reporting
		1. reporting plugin Code is copied from git link 'https://github.com/damianszczepanik/maven-cucumber-reporting' for cucumber reporting
		2. Change version and get Json Reports path. 
		3. Comment out ClassificationFiles lines
		4. Basically this will take result .json file as input and generate clean .html report
		5. So to provide .json result file, we have written plugin parameter and mentioned path to generate .json file in TestRunner class.
		6. html reports are generated in 'report/cucumber-html-reports' path
	*/
}
