package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions
(
	features=".//Feature/",
	glue="stepDefinations",
	dryRun=false,
	monochrome=true,
	plugin= {"pretty","html:test-output1.html"},
	tags= "@sanity"
)
public class TestRun 
{

}
