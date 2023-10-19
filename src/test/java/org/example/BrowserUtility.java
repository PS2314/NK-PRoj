package org.example;

import io.netty.handler.codec.Headers;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.openqa.selenium.devtools.idealized.Network.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

//AAbstraction
public  class BrowserUtility {

	public WebDriver wd;
	
	

	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtility(WebDriver wd) {
		super();
		this.wd = wd;
	}

	public BrowserUtility() {
		System.setProperty("webdriver.chrome.driver", "C://Users//DELL//git//SeleNTry//JuneAutomationFW//driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		wd = new ChromeDriver(); // Launch a browser instance

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);


	}

	public void PoppsUp(){
		//Store the ID of the original window
		String originalWindow = wd.getWindowHandle();

//Check we don't have other windows open already
		assert wd.getWindowHandles().size() == 1;
		if(originalWindow.contains("Allow")){
			clickOnButton(By.name("Allow"));
		};

//Click the link which opens in a new window
		wd.findElement(By.linkText("Block")).click();

//Wait for the new window or tab
		Duration duration = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(wd,duration);
		wait.until(numberOfWindowsToBe(2));

//Loop through until we find a new window handle
		for (String windowHandle : wd.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				wd.switchTo().window(windowHandle);
				break;
			}
		}

//Wait for the new tab to finish loading content
		wait.until(titleIs("Home | Salesforce"));
		//wd.switchTo().newWindow(WindowType.TAB);

	}

	public void PopUpHandling() {
		System.setProperty("webdriver.chrome.driver", "C://Users//DELL//git//SeleNTry//JuneAutomationFW//driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable- show---notifications");
		WebDriver driver = new ChromeDriver(options);
		options.addArguments("--remote-allow-origins=*");

		Actions actions = new Actions(driver);
		//actions.click(triggerElement).build().perform()

	}

	public void goToWebsite(String url) {
		wd.get(url);
	}

	public void maximizeScreen() {
		wd.manage().window().maximize();
	}
	
	
	public String getVisibleText(By locatorForTheElement) {
		sleepFor(4);
		WebElement element = wd.findElement(locatorForTheElement);
		String data=element.getText();
		return data;
	}

	public void enterText(By elementLocator, String textToEnter) {
		sleepFor(4);
		WebElement element = wd.findElement(elementLocator);
		clearText(elementLocator);
		element.sendKeys(textToEnter);
	}
	
	public void enterSpecialKey(By elementLocator, Keys keyToEnter) {
		sleepFor(4);
		WebElement element = wd.findElement(elementLocator);
		element.sendKeys(keyToEnter);
	}

	public void clickOnButton(By elementLocator) {
		sleepFor(4);

		WebElement element = wd.findElement(elementLocator);
		element.click();
	}

	public void clickOnDropDown(By elementLocator) {
		sleepFor(4);

		WebElement element = wd.findElement(elementLocator);
		if(element.isEnabled()){
			element.click();
		}
		System.out.println("Element Clicked");
	}

	public void WindowHandles(){
		String mainWindowHandle = wd.getWindowHandle(); // Store the current window handle
		System.out.println(mainWindowHandle);
		Set<String> windowHandles = wd.getWindowHandles(); // Get all window handles
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				wd.switchTo().window(handle); // Switch to the pop-up window

				break;
			}
		}
	}

	/*public void newPopUP()*//*{
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		driver.get("https://example.com");

		// Allow the notification
		devTools.send(enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(responseReceived(), responseReceived -> {
			Headers headers = responseReceived.getResponse().getHeaders();
			if (headers.containsKey("Notification-Allowed")) {
				devTools.send(clearBrowserCookies());
			}
		});


	}*/

	public void clearText(By elementLocator) {
		WebElement element = wd.findElement(elementLocator);
		element.clear();
	}

	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
