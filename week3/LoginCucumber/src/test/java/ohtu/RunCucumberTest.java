package ohtu;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "pretty", 
    features = "src/test/resources/ohtu", 
    snippets = SnippetType.CAMELCASE
    //tags = { "@problem" } // voidaan määritellä, että suoritetaan vain tällä tagillä olevat testit
)

public class RunCucumberTest {}