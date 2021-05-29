package commonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
	 * @author kumar
	 *
	 */
/**
 * This GenericUtility class has all generic methods. We can use these methods
 * across the projects. We consider Cucumber-Selenium project as base and
 * converted the common generic libraries of that project
 * 
 */

public class GenericUtility extends BaseTest implements IConst {
	public static String beforeWindowHandle = "";
	public static String currentWindowHandle = "";
	/**
	 * JSE click element
	 * 
	 * @throws Exception
	 */
	public void JseClick(WebElement element) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			throw new Exception("Not able to click element");
		}
	}

	/**
	 * JSE Highlight element
	 */
	public void JseHighlightTheElement(WebElement header) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int iCnt = 0; iCnt < 2; iCnt++) {
			js.executeScript("arguments[0].style.border='5px dotted green';", header);

		}
	}

	/**
	 * User Get screenshot on page
	 */
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	/**
	 * User enter text in to textField
	 * 
	 */
	public void sendToTextBox(WebElement element, String text) throws Exception {
		element.sendKeys(text);
	}

	/**
	 * User Wait for some time
	 */
	public void wait(int object) throws InterruptedException {
		TimeUnit.SECONDS.sleep(object);
	}

	/**
	 * get text
	 */

	public String getText(WebElement object) throws Exception {
		String value = object.getText();
		return value;
	}

	/**
	 * Verify element is displayed
	 * 
	 * @throws Exception
	 */
	public boolean validateElementDisplayed(WebElement elementName) throws Exception {

		boolean actualValue = elementName.isDisplayed();

		if (actualValue) {
			System.out.println("expected element" + elementName.getText() + " is displayed");
		} else {
			throw new Exception("Element  is not displayed");
		}
		return actualValue;
	}

	/**
	 * click on element
	 */
	public void clickElement(WebElement object) {
		try {
			object.click();
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	/**
	 * visiblity of element
	 */

	public void WaitForTheVisibilityOfElement(WebElement Ele, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(Ele));

	}

	/**
	 * scroll to element
	 */

	public void scrollToview(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	/**
	 * User enter text in to textField
	 * 
	 */
	public void sendTToTextBox(WebElement element, Keys tab) throws Exception {
		element.sendKeys(tab);
	}

	
	

	public void switchtoNewWindow() throws Exception {

		final String c = driver.getWindowHandle();
		final Set<String> handles = driver.getWindowHandles();
		handles.remove(c);
		System.out.println("Switch to recent window");
		for (String obj : handles) {

			driver.switchTo().window(obj);

			System.out.println(handles.size());

		}

	}

	public void parentTab() {

		beforeWindowHandle = driver.getWindowHandle();
		System.out.println("Capturing the window of current control");

	}

	public void SwitchtoparentTab() {

		driver.switchTo().window(beforeWindowHandle);
		System.out.println("move again to parent window");

	}
	
	
	
	/**
	 * User clear text in text field
	 * 
	 */
	public void clearText(WebElement element) throws Exception {
		System.out.println("Clear text in text field");
		element.clear();
	}
	
	
	/**
	 * Verify element is displayed
	 * 
	 * @throws Exception
	 */
	public boolean validateListElementDisplayed(List<WebElement> list) throws Exception {

		boolean actualValue = ((WebElement) list).isDisplayed();

		if (actualValue) {
			System.out.println("expected element" + ((WebElement) list).getText() + " is displayed");
		} else {
			throw new Exception("Element  is not displayed");
		}
		return actualValue;
	}
	
	
	public String getRandomText(int length) {
		System.out.println("Generating Random Text");
		String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		int n = alphabet.length();
		String result = new String();
		Random r = new Random();

		for (int i = 0; i < length; i++) {
			result = result + alphabet.charAt(r.nextInt(n));
		}
		System.out.println("Generating Random Text" + result);
		return result;

	}
	
	
	
	/**
	 * Click on pause/enable video
	 * 
	 */
	public boolean clickVideoPause(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].pause()", element);
        
        return true;
	}
}