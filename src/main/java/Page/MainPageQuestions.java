package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPageQuestions {
    private WebDriver driver;
    public MainPageQuestions(WebDriver driver) {
        this.driver = driver;

        // Находим нужный элемент на странице
        WebElement element = driver.findElement(By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']"));
        // Используем JavascriptExecutor для выполнения JavaScript-кода на странице
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Куки
    private final By cookie = By.xpath("//button[@class='App_CookieButton__3cvqF']");
    // Вопросы
    public static  final By oneQuestions = By.id("accordion__heading-0");
    public static  final By twoQuestions = By.id("accordion__heading-1");
    public static  final By threeQuestions = By.id("accordion__heading-2");
    public static  final By fourQuestions = By.id("accordion__heading-3");
    public static  final By fiveQuestions = By.id("accordion__heading-4");
    public static  final By sixQuestions = By.id("accordion__heading-5");
    public static  final By sevenQuestions = By.id("accordion__heading-6");
    public static  final By eightQuestions = By.id("accordion__heading-7");


    // Текст ответов
    public static  final By oneResponse = By.id("accordion__panel-0");
    public static  final By twoResponse = By.id("accordion__panel-1");
    public static  final By threeResponse = By.id("accordion__panel-2");
    public static  final By fourResponse = By.id("accordion__panel-3");
    public static  final By fiveResponse = By.id("accordion__panel-4");
    public static  final By sixResponse = By.id("accordion__panel-5");
    public static  final By sevenResponse = By.id("accordion__panel-6");
    public static  final By eightResponse = By.id("accordion__panel-7");


    // Кликаем на куки
    public void closeCookie() {
        driver.findElement(cookie).click();
    }

    // Кликаем на вопрос
    public void clickQuestion(By Questions) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(Questions));
        driver.findElement(Questions).click();
    }

    // Получаем текст ответа
    public String getResponse(By Response) {
        return driver.findElement(Response).getText();
    }


}
