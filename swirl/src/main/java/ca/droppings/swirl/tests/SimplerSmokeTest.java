package ca.droppings.swirl.tests;


import ca.droppings.swirl.BaseTest;
//import ca.droppings.swirl.selenium.BasePage;
import ca.droppings.swirl.po.SanityHomePage;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimplerSmokeTest extends BaseTest {
	
	@Test
	public void simpleTest101() {
		driver.get("https://www.DuckDuckGo.com");
		assertEquals(driver.getTitle(),"DuckDuckGo");
	}
	@Test
	public void simpleTest102() {
		driver.get("https://www.DuckDuckGo.com");
		SanityHomePage sanityHomePage = new SanityHomePage(driver);
		assertTrue(sanityHomePage.verifyPageTitle("DuckDuckGo"));
	}

}