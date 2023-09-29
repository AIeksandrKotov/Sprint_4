package pagetest;

import page.MainPageQuestions;
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
    private final By QUESTIONS;
    private final By RESPONSE;
    private final String TEXT_RESPONSE;


    // принимаем значение полей
    public TextQuestions(By questionsItem, By responsesItem, String TextResponse) {
        this.QUESTIONS = questionsItem;
        this.RESPONSE = responsesItem;
        this.TEXT_RESPONSE = TextResponse;
    }


    // Текст ответов
    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][]{
                {MainPageQuestions.getOneQuestions(), MainPageQuestions.getOneResponse(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPageQuestions.getTwoQuestions(), MainPageQuestions.getTwoResponse(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPageQuestions.getThreeQuestions(), MainPageQuestions.getThreeResponse(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPageQuestions.getFourQuestions(), MainPageQuestions.getFourResponse(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPageQuestions.getFiveQuestions(), MainPageQuestions.getFiveResponse(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPageQuestions.getSixQuestions(), MainPageQuestions.getSixResponse(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPageQuestions.getSevenQuestions(), MainPageQuestions.getSevenResponse(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPageQuestions.getEightQuestions(), MainPageQuestions.getEightResponse(), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }
    @Test
    public void testQuestionsDropdowns() {
        MainPageQuestions MainPageQuestions = new MainPageQuestions(driver);

        MainPageQuestions.clickQuestion(QUESTIONS);
        MainPageQuestions.closeCookie();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String resultText = MainPageQuestions.getResponse(RESPONSE);
        assertEquals("Ошибка в тексте элемента выпадающего списка", TEXT_RESPONSE, resultText);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}

