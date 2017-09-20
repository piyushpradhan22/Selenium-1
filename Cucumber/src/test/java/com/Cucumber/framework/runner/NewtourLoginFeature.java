package com.Cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"classpath:featurefile/NewtourLogin.feature"})
public class NewtourLoginFeature extends AbstractTestNGCucumberTests{

}
