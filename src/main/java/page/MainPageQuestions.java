package page;

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
    private static final By COOKIE = By.xpath("//button[@class='App_CookieButton__3cvqF']");

    // Вопросы
    private static final By ONE_QUESTION = By.id("accordion__heading-0");
    private static final By TWO_QUESTION = By.id("accordion__heading-1");
    private static final By THREE_QUESTION = By.id("accordion__heading-2");
    private static final By FOUR_QUESTION = By.id("accordion__heading-3");
    private static final By FIVE_QUESTION = By.id("accordion__heading-4");
    private static final By SIX_QUESTION = By.id("accordion__heading-5");
    private static final By SEVEN_QUESTION = By.id("accordion__heading-6");
    private static final By EIGHT_QUESTION = By.id("accordion__heading-7");


    // Текст ответов
    private static final By ONE_RESPONSE = By.id("accordion__panel-0");
    private static final By TWO_RESPONSE = By.id("accordion__panel-1");
    private static final By THREE_RESPONSE = By.id("accordion__panel-2");
    private static final By FOUR_RESPONSE = By.id("accordion__panel-3");
    private static final By FIVE_RESPONSE = By.id("accordion__panel-4");
    private static final By SIX_RESPONSE = By.id("accordion__panel-5");
    private static final By SEVEN_RESPONSE = By.id("accordion__panel-6");
    private static final By EIGHT_RESPONSE = By.id("accordion__panel-7");


    // Кликаем на куки
    public void closeCookie() {
        driver.findElement(COOKIE).click();
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


    // Сделал все поля приватными что-бы соблюсти принцип инкапсуляции
    public static By getOneQuestions() {
        return ONE_QUESTION;}
    public static By getTwoQuestions() {
        return TWO_QUESTION;}
    public static By getThreeQuestions() {
        return THREE_QUESTION;}
    public static By getFourQuestions() {
        return FOUR_QUESTION;}
    public static By getFiveQuestions() {
        return FIVE_QUESTION;}
    public static By getSixQuestions() {
        return SIX_QUESTION;}
    public static By getSevenQuestions() {
        return SEVEN_QUESTION;}
    public static By getEightQuestions() {
        return EIGHT_QUESTION;}
    public static By getOneResponse() {
        return ONE_RESPONSE;}
    public static By getTwoResponse() {
        return TWO_RESPONSE;}
    public static By getThreeResponse() {
        return THREE_RESPONSE;}
    public static By getFourResponse() {
        return FOUR_RESPONSE;}
    public static By getFiveResponse() {
        return FIVE_RESPONSE;}
    public static By getSixResponse() {
        return SIX_RESPONSE;}
    public static By getSevenResponse() {
        return SEVEN_RESPONSE;}
    public static By getEightResponse() {
        return EIGHT_RESPONSE;}

}
