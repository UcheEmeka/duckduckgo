package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search_Test {

    private WebDriver driver;

    public void setUp() throws InterruptedException
    {

        System.setProperty("webdriver.gecko.driver","E:/test_automation/resources/geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://duckduckgo.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Lesson");
        driver.findElement(By.id("search_button_homepage")).click();

        driver.findElement(By.className("result__a")).click();
        String browserTitle = driver.getTitle();
        String expectedTitle = "https://www.toptal.com/";

        if (browserTitle != expectedTitle)
        {
            System.out.println("wrong URL returned");
        }

        driver.close();
    }

    public static void main(String args[]) throws InterruptedException
    {
        Search_Test test = new Search_Test();
        test.setUp();
    }
}
