package ca.droppings.swirl.suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.droppings.swirl.tests.SimpleSmokeTest;
import ca.droppings.swirl.tests.SimplerSmokeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	SimpleSmokeTest.class, SimplerSmokeTest.class 
})
public class SimplerSmokeSuite {

}
