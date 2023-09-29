package pagetest;

import page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru";
    public WebDriver driver;


    @Before
    public void setUp() {


        /*WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get(mainPage);
        LoginPage objMainPage = new LoginPage(driver);*/




        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.get(MAIN_PAGE);
        LoginPage objMainPage = new LoginPage(driver);
        //objMainPage.clickCookie();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);}

    }

