import static org.hamcrest.CoreMatchers.is;
import static pages.MainPage.MAIN_PAGE;
import static pages.MainPage.FAQ_TITLE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

@RunWith(Parameterized.class)
public class ScooterQuestionTest {

  WebDriver driver;

  @Before
  public void startUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
//    WebDriverManager.firefoxdriver().setup();
//    driver = new FirefoxDriver();
    driver.manage().window().maximize();
  }

    private final int number;
    private final String answer;

    public ScooterQuestionTest(int number, String answer) {
      this.number = number;
      this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
      return new Object[][]{
          {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
          {1,
              "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
          {2,
              "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
          {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
          {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
          {5,
              "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
          {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
          {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
      };
    }

  @Test
  public void checkFAQForExpectedText() {
    driver.get(MAIN_PAGE);
    MainPage mainPage = new MainPage(driver);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(FAQ_TITLE));
    new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(FAQ_TITLE));
    mainPage.clickQuestionGetAnswer(number);
    MatcherAssert.assertThat(mainPage.clickQuestionGetAnswer(number), is(answer));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
