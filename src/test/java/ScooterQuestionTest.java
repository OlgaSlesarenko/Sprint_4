import static org.hamcrest.CoreMatchers.is;
import static pages.MainPage.MAIN_PAGE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class ScooterQuestionTest {

  WebDriver driver;

  @Before
  public void startUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

//  @RunWith(Parameterized.class)
//  public class TestClass {
//
//    private int number;
//    //    private String question;
//    private String answer;
//
//    public TestClass(int number, String answer) {
//      this.number = number;
//      this.answer = answer;
//    }
//
//    @Parameterized.Parameters
//    public Object[][] getCities() {
//      //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
//      return new Object[][]{
//          {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
//          {1,
//              "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
//          {2,
//              "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
//          {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
//          {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
//          {5,
//              "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
//          {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
//          {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
//      };
//    }

  @Test
  public void checkFAQForExpectedText() {

    driver.get(MAIN_PAGE);
    MainPage mainPage = new MainPage(driver);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(mainPage.getFaqTitle()));

    //миже проверки выборочных трех ответов, появляющихся при клике на вопросы
    mainPage.checkElementIsDisplayedAfterClick(mainPage.getFirstFAQHeader(), mainPage.getFirstFAQAnswer());
    MatcherAssert.assertThat(mainPage.getElementText(mainPage.getFirstFAQAnswer()), is("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));

    mainPage.checkElementIsDisplayedAfterClick(mainPage.getFourthFAQHeader(), mainPage.getFourthFAQAnswer());
    MatcherAssert.assertThat(mainPage.getElementText(mainPage.getFourthFAQAnswer()), is("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));

    mainPage.checkElementIsDisplayedAfterClick(mainPage.getEighthFAQHeader(), mainPage.getEighthFAQAnswer());
    MatcherAssert.assertThat(mainPage.getElementText(mainPage.getEighthFAQAnswer()), is("Да, обязательно. Всем самокатов! И Москве, и Московской области."));

  }




  @After
  public void tearDown() {
    driver.quit();
  }

}
