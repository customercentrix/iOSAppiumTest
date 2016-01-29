package test.java;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Simple tests for the Main Storyboard.
 * 
 * @author Sonny
 */
public class MainStoryboardTest extends MyAppTestBase
{	
	/**
	 * Test that the calendar is showing the correct date.
	 */
	@Test
	public void testCalendar()
	{
		MobileElement month = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]"));
		String label = month.getAttribute("label");
		
		MyAppTestBase.takeScreenshot("Calendar");
		
		Assert.assertTrue("January 2016".equals(label));
	}
	
	/**
	 * Clicks each button in the tab bar.
	 */
	@Test
	public void testNavigation()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		MyAppTestBase.takeScreenshot("Navigation Start");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(getTabBarButton(1)))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(getTabBarButton(2)))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(getTabBarButton(3)))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(getTabBarButton(4)))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(getTabBarButton(5)))).click();		
	}
	
	/**
	 * Retrieves the xpath to the button in the tab bar.
	 * 
	 * @param position The tab element.
	 * @return The XPath to the tab button.
	 */
	private String getTabBarButton(int position)
	{
		return "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton["+position+"]";
	}
}
