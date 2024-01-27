package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    private WebDriverWait wait;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        String currentURL = driver.getCurrentUrl();
        String expectedTitle = "google";
        if (currentURL.contains(expectedTitle)) {
            System.out.println("The URL contains the expected title" + " " + expectedTitle);
        } else {
            System.out.println("The URL does not contain the expected title" + " " + expectedTitle);
        }
        WebElement searchbar = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
        searchbar.sendKeys("calculator");
        searchbar.submit();

        WebElement calculator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorText = calculator.getText();
        if (!calculatorText.equals("0")) {
            System.out.println("Failed: Google Calculator did not load with initial display of zero");
        } else {
            System.out.println("Passed: Google Calculator loaded with initial display of zero");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement searchbar = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
        searchbar.sendKeys("calculator");
        searchbar.submit();
        WebElement num1 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='5']")));
        num1.click();
        WebElement add = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe MEdqYd' and text()='+']")));
        add.click();
        WebElement num2 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='7']")));
        num2.click();
        WebElement equals = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe UUhRt' and text()='=']")));
        equals.click();
        WebElement calculator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorText = calculator.getText();
        if (!calculatorText.equals("12")) {
            System.out.println("Failed: The expected result is not 12");
        } else {
            System.out.println("Passed: The expected result is 12");
        }

        WebElement num3 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='1']")));
        num3.click();
        WebElement num4 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='5']")));
        num4.click();
        WebElement sub = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe MEdqYd' and @aria-label='minus']")));
        sub.click();
        WebElement num5 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='8']")));
        num5.click();
        WebElement equals1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe UUhRt' and text()='=']")));
        equals1.click();
        WebElement calculatorres = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorresText = calculatorres.getText();
        if (!calculatorresText.equals("7")) {
            System.out.println("Failed: The expected result is not 7");
        } else {
            System.out.println("Passed: The expected result is 7");
        }

        System.out.println("end Test case: testCase02");

    }

    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");
        WebElement searchbar = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
        searchbar.sendKeys("calculator");
        searchbar.submit();
        WebElement AC = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe MEdqYd' and @aria-label='all clear']")));
        AC.click();
        WebElement calculator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorText = calculator.getText();
        if (!calculatorText.equals("0")) {
            System.out.println("Failed: The All Clear button did not cleared the display");
        } else {
            System.out.println("Passed: The All Clear button cleared the display");
        }
        WebElement num1 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='1']")));
        num1.click();
        WebElement num2 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='0']")));
        num2.click();
        WebElement mult = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe MEdqYd' and @aria-label='multiply']")));
        mult.click();
        WebElement num3 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='3']")));
        num3.click();
        WebElement equals = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe UUhRt' and text()='=']")));
        equals.click();
        WebElement calculatorres = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorresText = calculatorres.getText();
        if (!calculatorresText.equals("30")) {
            System.out.println("Failed: The expected result is not 30");
        } else {
            System.out.println("Passed: The expected result is 30");
        }

        System.out.println("end Test case: testCase03");
 }

     public void testCase04(){
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com");
        WebElement searchbar = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
        searchbar.sendKeys("calculator");
        searchbar.submit();
        WebElement num1 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='2']")));
        num1.click();
        WebElement num2 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='0']")));
        num2.click();
        WebElement div = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe MEdqYd' and @aria-label='divide']")));
        div.click();
        WebElement num3 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe AOvabd' and text()='4']")));
        num3.click();
        WebElement equals = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XRsWPe UUhRt' and text()='=']")));
        equals.click();
        WebElement calculator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
        String calculatorText = calculator.getText();
        if (!calculatorText.equals("5")) {
            System.out.println("Failed: The expected result is not 5");
        } else {
            System.out.println("Passed: The expected result is 5");
        }

        
     }

}
