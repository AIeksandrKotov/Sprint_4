package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cookie = By.xpath("//button[@class='App_CookieButton__3cvqF']"); // Куки
    private final By buttonOrderTop = By.xpath("//button[@class='Button_Button__ra12g']"); // Верхняя кнопка заказать
    private final By buttonOrderLower = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"); // Нижняя кнопка заказать
    private final By orderName = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > input"); // Строка с именем
    private final By orderFirstName = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > input"); // Строка с Фамилией
    private final By orderAddress = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input"); // Строка с адресом
    private final By orderMetro = By.cssSelector("div.Order_Form__17u6u > div:nth-child(4) > div > div"); //Строка с выбором метро
    private final By orderTelephone = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input"); // Строка с телефоном
    private final By buttonNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка далее

    // Второе окно регистрации
    private final By orderData = By.xpath("//div[@class='react-datepicker__input-container']/input[@type='text']"); // Дата когда привести
    private final By orderLease = By.xpath("//div[@class='Dropdown-root']"); // Строка аренды
    private final By orderColor = By.xpath("//div[@class='Order_Checkboxes__3lWSI']"); // Строка выбора цвета
    private final By orderComment = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"); // Строка комментарий
    private final By buttonRequest = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Кнопка заказать
    private final By buttonOrderConfirmation = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']"); // Кнопка Да


    // Кликаем на куки
        public void clickCookie(){
            driver.findElement(cookie).click();
        }

    // Кликаем по кнопке заказать (Верхняя или нижняя)
    public LoginPage clickButtonOrder() {
        if (driver.findElement(buttonOrderTop).isDisplayed()) {
            driver.findElement(buttonOrderTop).click();
        } else {
            driver.findElement(buttonOrderLower).click();
        }
        return this;
    }


    // Кликаем на поле и передаем параметр Имя для ввода
    public LoginPage setUserName(String userName) {
        driver.findElement(orderName).click();
        driver.findElement(orderName).sendKeys(userName);
        return this;
    }

    // Кликаем на поле и передаем параметр Фамилии для ввода
    public LoginPage setFirstName(String firstName) {
        driver.findElement(orderFirstName).click();
        driver.findElement(orderFirstName).sendKeys(firstName);
        return this;
    }

    // Кликаем на поле и передаем параметр адрес для ввода
    public LoginPage setAddress(String address) {
        driver.findElement(orderAddress).click();
        driver.findElement(orderAddress).sendKeys(address);
        return this;
    }

    // Кликаем на поле и выбираем метро
    public LoginPage setOrderMetro(int metroName) {
        driver.findElement(orderMetro).click();
        driver.findElement(By.xpath(String.format("//ul/li[%s]", metroName))).click();
        return this;
    }

    // Кликаем по полю и передаем параметр телефона
    public LoginPage setTelephone(String numberPhone) {
        driver.findElement(orderTelephone).click();
        driver.findElement(orderTelephone).sendKeys(numberPhone);
        return this;
    }
    // Кликаем по кнопке next
    public LoginPage setButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }
    // Кликаем по полю и передаем параметр даты
    public LoginPage setOrderData(String dateOrder){
        driver.findElement(orderData).click();
        driver.findElement(orderData).sendKeys(dateOrder);
        driver.findElement(orderData).sendKeys(Keys.ENTER);
        return this;
    }
    // Кликаем по полю и передаем параметр аренды

    public LoginPage setOrderLease(int leasPeriod){
        driver.findElement(orderLease).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-menu']/div[%s]", leasPeriod))).click();
        return this;

    }
    // Кликаем по полю и передаем параметр цвета

    public LoginPage setOrderColor(String color){
        driver.findElement(orderColor).click();
        driver.findElement(By.xpath(String.format("//div[@class='Order_Checkboxes__3lWSI']/label/input[@id='%s']", color))).click();
        return this;
    }
    // Кликаем по полю и передаем параметр комментария
    public LoginPage setOrderComment(String comment){
        driver.findElement(orderComment).click();
        driver.findElement(orderComment).sendKeys(comment);
        return this;
    }
    // Кликаем по кнопке заказать
    public LoginPage setButtonRequest(){
        driver.findElement(buttonRequest).click();
        return this;
    }
    // Кликаем на кнопку ДА
    public LoginPage setButtonConfirm(){
        driver.findElement(buttonOrderConfirmation).click();
        return this;
    }

    // Метод авторизации в приложении
    public void Login(String username, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment){
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
}
