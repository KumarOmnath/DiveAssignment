package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * @author kumar Base class
 *
 */
public class BaseTest implements IConst {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebEventListener eventListener;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + CONFIG_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author kumar
	 * browser initilize & path
	 *
	 */
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("use-fake-ui-for-media-stream");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver(option);
			
		}else if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		/**
		 * @author kumar
		 * Eventfire listener &  get url
		 *
		 */
		event_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		event_driver.register(eventListener);
		driver = event_driver;
		driver.manage().window().maximize();
		String implicitWait = prop.getProperty("Implicit_Wait");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWait), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}