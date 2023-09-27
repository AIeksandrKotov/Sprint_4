package PageTest;

import Page.MainPageQuestions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

// Создаем поля где будут храниться параметры тестового метода
@RunWith(Parameterized.class)
public class TextQuestions extends BaseTest {
    private final By Questions;
    private final By Response;
    public String TextResponse;


    // принимаем значение полей
    public TextQuestions(By questionsItem, By responsesItem, String TextResponse) {
        this.Questions = questionsItem;
        this.Response = responsesItem;
        this.TextResponse = TextResponse;
    }


    // Текст ответов
    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][]{
                {MainPageQuestions.oneQuestions, MainPageQuestions.oneResponse, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPageQuestions.twoQuestions, MainPageQuestions.twoResponse, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPageQuestions.threeQuestions, MainPageQuestions.threeResponse, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPageQuestions.fourQuestions, MainPageQuestions.fourResponse, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPageQuestions.fiveQuestions, MainPageQuestions.fiveResponse, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPageQuestions.sixQuestions, MainPageQuestions.sixResponse, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPageQuestions.sevenQuestions, MainPageQuestions.sevenResponse, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPageQuestions.eightQuestions, MainPageQuestions.eightResponse, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }
    @Test
    public void testQuestionsDropdowns() {
        MainPageQuestions MainPageQuestions = new MainPageQuestions(driver);

        MainPageQuestions.clickQuestion(Questions);
        MainPageQuestions.closeCookie();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String resultText = MainPageQuestions.getResponse(Response);
        assertEquals("Ошибка в тексте элемента выпадающего списка", TextResponse, resultText);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}

