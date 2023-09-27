package PageTest;

import Page.LoginPage;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;


// Создаем поля где будут храниться параметры тестового метода
@RunWith(Parameterized.class)
public class TestPageLogin extends BaseTest {
    private final String userName;
    private final String firstName;
    private final String address;
    private final int metroName;
    private final String numberPhone;
    private final String dateOrder;
    private final int leasPeriod;
    private final String color;
    private final String comment;
    // Создаем локатор для поиска элемента
    public static final By orderPlaced =
            By.xpath("//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    // Создаем конструктор, который принимает значение всех полей
    public TestPageLogin(String userName, String firstName, String address, int metroName, String numberPhone, String dateOrder, int leasPeriod, String color, String comment) {
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
                {"Александр", "Котов", "Всеволожск", 2, "89110271187","19.09.2023", 2, "grey", ""},
        };

    }
    @Test
    public void orderRegistrationSuccess(){
        new LoginPage(driver)
                .Login(userName, firstName, address, metroName, numberPhone, dateOrder, leasPeriod, color, comment);
        String text = driver.findElement(orderPlaced).getText();
        MatcherAssert.assertThat("Заказ не оформлен",text, containsString("Заказ оформлен"));
    }
}