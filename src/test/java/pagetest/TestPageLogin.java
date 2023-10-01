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
    private final String button;
    private final String userName;
    private final String firstName;
    private final String address;
    private final int metroName;
    private final String numberPhone;
    private final String dateOrder;
    private final int leasPeriod;
    private final String color;
    private final String comment;

    // Создаем конструктор, который принимает значение всех полей
    public TestPageLogin(String button, String userName, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment) {
        this.button = button;
        this.userName = userName;
        this.firstName = firstName;
        this.address = address;
        this.metroName = metroName;
        this.numberPhone = numberPhone;
        this.dateOrder = dateOrder;
        this.leasPeriod = leasPeriod;
        this.color = color;
        this.comment = comment;
    }

    // Передаем тестовые данные
    @Parameterized.Parameters
    public static Object[][] getUserLogin() {
        return new Object[][]{
                {"topButton", "Александр", "Котов", "Всеволожск", 2, "89110271187", "19.09.2023", 2, "grey", ""},
                {"lowerButton", "Иванов Иван", "Иванович", "Невский пр.", 4, "+79110271187", "11.02.2022", 3, "black", ""},
        };

    }

    @Test
    public void orderRegistration() {
        new LoginPage(driver)
                .login(button, userName, firstName, address, metroName, numberPhone, dateOrder, leasPeriod, color, comment);
        String text = driver.findElement(ORDER_PLACED).getText();
        MatcherAssert.assertThat("Заказ не оформлен", text, containsString("Заказ оформлен"));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
