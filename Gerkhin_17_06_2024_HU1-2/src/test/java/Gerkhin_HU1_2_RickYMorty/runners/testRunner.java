package Gerkhin_HU1_2_RickYMorty.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Gerkhin_HU1_2_RickYMorty",
        glue = {"Gerkhin_HU1_2_RickYMorty.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class testRunner {
}

