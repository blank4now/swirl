package ca.droppings.swirl.tests;

import ca.droppings.swirl.BaseTest;
//import ca.droppings.swirl.selenium.BasePage;
import ca.droppings.swirl.po.SanityHomePage;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleSmokeTest extends BaseTest {
	
	@Test
	public void simpleTest001() {
		driver.get(props.getProperty("does.not.exist","https://www.DuckDuckGo.com"));
		assertEquals(driver.getTitle(),props.getProperty("does.not.exist","DuckDuckGo"));
	}
	@Test
	public void simpleTest002() {
		driver.get(props.getProperty("does.not.exist","https://www.DuckDuckGo.com"));
		SanityHomePage sanityHomePage = new SanityHomePage(driver);
		assertTrue(sanityHomePage.verifyPageTitle(props.getProperty("does.not.exist","DuckDuckGo")));
	}

}
