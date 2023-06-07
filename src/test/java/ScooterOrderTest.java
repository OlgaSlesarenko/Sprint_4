import static pages.MainPage.MAIN_PAGE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

  WebDriver driver;

  @Before
  public void startUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  private final String name;
  private final String surname;
  private final String adress;
  private final int dataIndex;
  private final String phone;
  private final String date;
  private final int position;
  private final String comment;

  public ScooterOrderTest(String name, String surname, String adress, int dataIndex, String phone, String date, int position,
      String comment) {
    this.name = name;
    this.surname = surname;
    this.adress = adress;
    this.dataIndex = dataIndex;
    this.phone = phone;
    this.date = date;
    this.position = position;
    this.comment = comment;
  }

  // Тестовые данные
  @Parameterized.Parameters
  public static Object[][] getOrderCredentials() {
    return new Object[][] {
        { "Иван", "Иванов", "ул.Иванова, д.1", 0, "+71112223344", "01.07.2024", 0, "Какой-то комментарий"},
        { "Петр", "Петров", "ул.Петрова, д.2", 1, "+72112223344", "02.07.2024", 1, "Какой-то комментарий"},
        { "Ирина", "Иринина", "ул.Ирининой, д.3", 2, "+73112223344", "03.07.2024", 2, "Какой-то комментарий"},
        { "Татьяна", "Татьянина", "ул.Татьяниной, д.4", 3, "+74112223344", "04.07.2024", 3, "Какой-то комментарий"},

    };
  }

  @Test
  public void loginTest() {
    // Запускаем браузер, переходим на сайт и нажимаем кнопку заказа самоката
    WebDriver driver = new ChromeDriver();
    driver.get(MAIN_PAGE);
    MainPage mainPage = new MainPage(driver);
    mainPage.clickElement(mainPage.getHeaderOrderButton());
    OrderPage orderPage = new OrderPage();


//    driver.findElement(By.className("email")).sendKeys(email);
//    driver.findElement(By.className("password")).sendKeys(password);
//    driver.findElement(By.className("form")).click();

    // Если логин прошел успешно (result = true), элемент profile отображается на экране
    // В противном случае элемент не виден
//    assertEquals(result, driver.findElement(By.className("profile")).isDisplayed());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
