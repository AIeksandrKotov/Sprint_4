package pagetest;

import org.junit.After;
import page.LoginPage;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;
import static page.LoginPage.ORDER_PLACED;


// Создаем поля где будут храниться параметры тестового метода
@RunWith(Parameterized.class)
public class TestPageLogin extends BaseTest {
    private final String USER_NAME;
    private final String FIRST_NAME;
    private final String ADDRESS;
    private final int METRO_NAME;
    private final String NUMBER_PHONE;
    private final String DATA_ORDER;
    private final int LEAS_PERIOD;
    private final String COLOR;
    private final String COMMENT;

    // Создаем конструктор, который принимает значение всех полей
    public TestPageLogin(String userName, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment) {
        this.USER_NAME = userName;
        this.FIRST_NAME = firstName;
        this.ADDRESS = address;
        this.METRO_NAME = metroName;
        this.NUMBER_PHONE = numberPhone;
        this.DATA_ORDER = dateOrder;
        this.LEAS_PERIOD = leasPeriod;
        this.COLOR = color;
        this.COMMENT = comment;
    }

    // Передаем тестовые данные
    @Parameterized.Parameters
    public static Object[][] getUserLogin() {
        return new Object[][]{
                {"Александр", "Котов", "Всеволожск", 2, "89110271187","19.09.2023", 2, "grey", ""},
                {"Иванов Иван", "Иванович", "Невский пр.", 4, "+79110271187","11.02.2022", 3, "black", ""},
        };

    }
    @Test
    public void orderRegistrationTopButton(){
        new LoginPage(driver)
                .loginButtonTop(USER_NAME, FIRST_NAME, ADDRESS, METRO_NAME, NUMBER_PHONE, DATA_ORDER, LEAS_PERIOD, COLOR, COMMENT);
        String text = driver.findElement(ORDER_PLACED).getText();
        MatcherAssert.assertThat("Заказ не оформлен",text, containsString("Заказ оформлен"));
    }
    @Test
    public void orderRegistrationLowerButton(){
        new LoginPage(driver)
                .loginButtonLower(USER_NAME, FIRST_NAME, ADDRESS, METRO_NAME, NUMBER_PHONE, DATA_ORDER, LEAS_PERIOD, COLOR, COMMENT);
        String text = driver.findElement(ORDER_PLACED).getText();
        MatcherAssert.assertThat("Заказ не оформлен",text, containsString("Заказ оформлен"));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}