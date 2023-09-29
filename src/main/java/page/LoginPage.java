package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COOKIE = By.xpath("//button[@class='App_CookieButton__3cvqF']"); // Куки
    private final By BUTTON_ORDER_TOP = By.xpath("//button[@class='Button_Button__ra12g']"); // Верхняя кнопка заказать
    private final By BUTTON_ORDER_LOWER = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"); // Нижняя кнопка заказать
    private final By ORDER_NAME = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > input"); // Строка с именем
    private final By ORDER_FIRS_NAME = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > input"); // Строка с Фамилией
    private final By ORDER_ADDRESS = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input"); // Строка с адресом
    private final By ORDER_METRO = By.cssSelector("div.Order_Form__17u6u > div:nth-child(4) > div > div"); //Строка с выбором метро
    private final By ORDER_TELEPHONE = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input"); // Строка с телефоном
    private final By BUTTON_NEXT = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка далее

    // Второе окно регистрации
    private final By ORDER_DATA = By.xpath("//div[@class='react-datepicker__input-container']/input[@type='text']"); // Дата когда привести
    private final By ORDER_LEASE = By.xpath("//div[@class='Dropdown-root']"); // Строка аренды
    private final By ORDER_COLOR = By.xpath("//div[@class='Order_Checkboxes__3lWSI']"); // Строка выбора цвета
    private final By ORDER_COMMENT = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"); // Строка комментарий
    private final By BUTTON_REQUEST = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка заказать
    private final By BUTTON_ORDER_CONFIRMATION = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']"); // Кнопка Да

    public static final By ORDER_PLACED = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");



    // Кликаем на куки
        public void clickCookie(){
            driver.findElement(COOKIE).click();
        }

    // Кликаем по кнопке заказать (Верхняя или нижняя)
    public LoginPage clickButtonOrder() {
        driver.findElement(BUTTON_ORDER_TOP).isDisplayed();
        driver.findElement(BUTTON_ORDER_TOP).click();
        return this;
    }

    public LoginPage clickButtonLower(){
        driver.findElement(BUTTON_ORDER_LOWER).isDisplayed();
        driver.findElement(BUTTON_ORDER_LOWER).click();
        return this;
    }


    // Кликаем на поле и передаем параметр Имя для ввода
    public LoginPage setUserName(String userName) {
        driver.findElement(ORDER_NAME).click();
        driver.findElement(ORDER_NAME).sendKeys(userName);
        return this;
    }

    // Кликаем на поле и передаем параметр Фамилии для ввода
    public LoginPage setFirstName(String firstName) {
        driver.findElement(ORDER_FIRS_NAME).click();
        driver.findElement(ORDER_FIRS_NAME).sendKeys(firstName);
        return this;
    }

    // Кликаем на поле и передаем параметр адрес для ввода
    public LoginPage setAddress(String address) {
        driver.findElement(ORDER_ADDRESS).click();
        driver.findElement(ORDER_ADDRESS).sendKeys(address);
        return this;
    }

    // Кликаем на поле и выбираем метро
    public LoginPage setOrderMetro(int metroName) {
        driver.findElement(ORDER_METRO).click();
        driver.findElement(By.xpath(String.format("//ul/li[%s]", metroName))).click();
        return this;
    }

    // Кликаем по полю и передаем параметр телефона
    public LoginPage setTelephone(String numberPhone) {
        driver.findElement(ORDER_TELEPHONE).click();
        driver.findElement(ORDER_TELEPHONE).sendKeys(numberPhone);
        return this;
    }
    // Кликаем по кнопке next
    public LoginPage setButtonNext() {
        driver.findElement(BUTTON_NEXT).click();
        return this;
    }
    // Кликаем по полю и передаем параметр даты
    public LoginPage setOrderData(String dateOrder){
        driver.findElement(ORDER_DATA).click();
        driver.findElement(ORDER_DATA).sendKeys(dateOrder);
        driver.findElement(ORDER_DATA).sendKeys(Keys.ENTER);
        return this;
    }
    // Кликаем по полю и передаем параметр аренды

    public LoginPage setOrderLease(int leasPeriod){
        driver.findElement(ORDER_LEASE).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-menu']/div[%s]", leasPeriod))).click();
        return this;

    }
    // Кликаем по полю и передаем параметр цвета

    public LoginPage setOrderColor(String color){
        driver.findElement(ORDER_COLOR).click();
        driver.findElement(By.xpath(String.format("//div[@class='Order_Checkboxes__3lWSI']/label/input[@id='%s']", color))).click();
        return this;
    }
    // Кликаем по полю и передаем параметр комментария
    public LoginPage setOrderComment(String comment){
        driver.findElement(ORDER_COMMENT).click();
        driver.findElement(ORDER_COMMENT).sendKeys(comment);
        return this;
    }
    // Кликаем по кнопке заказать
    public LoginPage setButtonRequest(){
        driver.findElement(BUTTON_REQUEST).click();
        return this;
    }
    // Кликаем на кнопку ДА
    public LoginPage setButtonConfirm(){
        driver.findElement(BUTTON_ORDER_CONFIRMATION).click();
        return this;
    }

    // Метод авторизации в приложении
    public void loginButtonTop(String username, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment){
        clickCookie();
        clickButtonOrder();
        setUserName(username);
        setFirstName(firstName);
        setAddress(address);
        setOrderMetro(metroName);
        setTelephone(numberPhone);
        setButtonNext();
        setOrderData(dateOrder);
        setOrderLease(leasPeriod);
        setOrderColor(color);
        setOrderComment(comment);
        setButtonRequest();
        setButtonConfirm();
    }
    public void loginButtonLower(String username, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment){
        clickCookie();
        clickButtonLower();
        setUserName(username);
        setFirstName(firstName);
        setAddress(address);
        setOrderMetro(metroName);
        setTelephone(numberPhone);
        setButtonNext();
        setOrderData(dateOrder);
        setOrderLease(leasPeriod);
        setOrderColor(color);
        setOrderComment(comment);
        setButtonRequest();
        setButtonConfirm();
    }
}
