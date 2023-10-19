package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.BrowserUtility;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class loginPage {

    public static void main(String[] args) throws SQLException, InterruptedException {


        /*LoginPageMethod();
        DashboardPageMethod();*/
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C://Users//DELL//git//SeleNTry//JuneAutomationFW//driver//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver wd = new ChromeDriver();
        BrowserUtility bu = new BrowserUtility(wd);



        /*LoginPage*/

        bu.goToWebsite("https://saas-ability-4162.my.salesforce.com/");
        bu.maximizeScreen();
        By userNameTextBoxLocator = By.id("username");
        bu.enterText(userNameTextBoxLocator, "nikhilakunapareddy-7nq1@force.com");
        By passwordTextBoxLocator = By.id("password");
        bu.enterText(passwordTextBoxLocator, "Monday@1");
        By signInButtonLocator = By.xpath("//div//input[@id='Login']");
        bu.clickOnButton(signInButtonLocator);
        System.out.println("Logged in successfully");
        String pageTitle = wd.getTitle();
        String mainhandle =wd.getWindowHandle();
        System.out.println(pageTitle + wd.getWindowHandle());
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        options.addArguments("--disable-notifications");
        wd.switchTo().window(mainhandle);
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.TAB).click();




        /*PopUp*/
        //wd.getWindowHandles();
        /*Dashboard & click on Account*/
       // bu.PoppsUp();
        //wd.switchTo().defaultContent();

        /*AllowNotificationAutoIT allowNotificationAutoIT = new AllowNotificationAutoIT();
        allowNotificationAutoIT.allownoti();*/
        System.out.println("Entered Dashboard");
        Thread.sleep(2000);
        //By AccountTab =  By.xpath("//div//nav//a//span[contains(text(),'Accounts') and @class='slds-truncate']");
       // System.out.println(AccountTab.toString().compareTo("Accounts"));
       // Thread.sleep(10000);
        WebElement AccountTab = wd.findElement(By.xpath("//one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[3]/a"));
        AccountTab.click();
        Thread.sleep(10000);
        Duration duration = Duration.ofSeconds(5);
        /*WebDriverWait wait = new WebDriverWait(wd,duration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Dropdown));

        // Scroll the element into view using JavaScript
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);*/

        // Click the element
       /* element.click();

        Dropdown.click();*/
        System.out.println("Entered the Accounts Tab");


        //Account page
        By NewButton = By.xpath("//div//a//div[contains(text(),'New')]");
        bu.clickOnButton(NewButton);


        DashBoardPage dbu = new DashBoardPage();
        bu.WindowHandles();
        By AccountName = By.name("Name");
        bu.enterText(AccountName,dbu.fakeName());

        By BillingAddress = By.xpath("//input[@id='combobox-input-355']");
        bu.enterText(BillingAddress,"Daniel Island");

        By BillingStreet = By.xpath("//textarea[@name='street']");
        bu.enterText(BillingStreet,"2620 Jerry Dove Drive");

        By BillingCity = By.xpath("//input[@name='city']");
        bu.enterText(BillingCity,"Daniel Island");

        By BillingProvince = By.xpath("//input[@name='province']");
        bu.enterText(BillingProvince," South Carolina");

        By BillingPostalCode= By.xpath("//input[@name='postalCode']");
        bu.enterText(BillingPostalCode,"29492");

        By BillingCountry = By.xpath("//input[@name='country']");
        bu.enterText(BillingCountry,"United States");

        By SaveButton = By.xpath("//button[@name='SaveEdit']");
        bu.clickOnButton(SaveButton);




    }

    /*public static void LoginPageMethod(){


    }


    public static void DashboardPageMethod(){

    }*/
}
