import static pages.MainPage.BODY_ORDER_BUTTON;
import static pages.MainPage.MAIN_PAGE;
import static pages.MainPage.HEADER_ORDER_BUTTON;
import static pages.OrderPage.ORDER_PAGE;
import static pages.OrderPage.BUTTON_CONFIRM_ORDER;
import static pages.OrderPage.BUTTON_NEXT;
import static pages.OrderPage.BUTTON_ORDER;
import static pages.OrderPage.CONFIRM_ORDER_HEADER;
import static pages.OrderPage.PAGE_NAME_CUSTOMER;
import static pages.OrderPage.PAGE_NAME_RENT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

  WebDriver driver;

  @Before
  public void startUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
//    WebDriverManager.firefoxdriver().setup();
//    driver = new FirefoxDriver();
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

  @Parameterized.Parameters
  public static Object[][] getOrderData() {
    return new Object[][]{
        {"Иван", "Иванов", "ул.Иванова, д.1", 0, "+71112223344", "01.07.2024", 0, "Какой-то комментарий"},
        {"Петр", "Петров", "ул.Петрова, д.2", 1, "+72112223344", "02.07.2024", 1, "Какой-то комментарий"},
        {"Ирина", "Иринина", "ул.Ирининой, д.3", 2, "+73112223344", "03.07.2024", 2, "Какой-то комментарий"},
        {"Татьяна", "Татьянина", "ул.Татьяниной, д.4", 3, "+74112223344", "04.07.2024", 3, "Какой-то комментарий"},
    };
  }

  @Test
  public void orderTestWithHeaderButton() {
    driver.get(MAIN_PAGE);
    MainPage mainPage = new MainPage(driver);
    mainPage.clickElement(HEADER_ORDER_BUTTON);
    createOrder();
  }

  @Test
  public void orderTestWithBodyButton() {
    driver.get(MAIN_PAGE);
    MainPage mainPage = new MainPage(driver);
    mainPage.scrollToBodyOrderButton();
    mainPage.clickElement(BODY_ORDER_BUTTON);
    createOrder();
  }

  private void createOrder() {
    driver.get(ORDER_PAGE);
    OrderPage orderPage = new OrderPage(driver);
    //заполнение формы заказчика
    new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(PAGE_NAME_CUSTOMER));
    orderPage.fillInFormPerson(name, surname, adress, dataIndex, phone);
    orderPage.clickElement(BUTTON_NEXT);
    //заполнение формы заказа
    new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(PAGE_NAME_RENT));
    orderPage.fillInFormOrder(date, position, comment);
    orderPage.clickElement(BUTTON_ORDER);
    //проверка подтверждения заказа
    orderPage.clickElement(BUTTON_CONFIRM_ORDER);
    new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_ORDER_HEADER));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
