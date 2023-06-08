package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

  public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";

  private final WebDriver driver;

  //кнопка "Заказать" в Header
  public static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
  //кнопка "Заказать" в Body
  public static final By BODY_ORDER_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
  //Заголовок раздела "Вопросы о важном"
  public static final By FAQ_TITLE = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");
  // метод кликает по нужному элементу
  public void clickElement(By element) {
    driver.findElement(element).click();
  }

  public String clickQuestionGetAnswer(int number) {
    clickQuestion(number);
    return getAnswer(number);
  }

  public void clickQuestion(int number) {
    //Header пункта раскрывающегося списка "Вопросы о важном"
    By faqHeader = By.xpath(String.format(".//div[@id='accordion__heading-%s']", number));
    driver.findElement(faqHeader).click();
  }
  public String getAnswer(int number) {
    ///Header пункта раскрывающегося списка "Вопросы о важном"
    By faqAnswer = By.xpath(String.format(".//div[@id = 'accordion__panel-%s']/p", number));
    driver.findElement(faqAnswer).isDisplayed();
    return getElementText(faqAnswer);
  }
  //метод для получения текста в элементе
  public String getElementText(By element) {
    return driver.findElement(element).getText();
  }
  //скролл до кнопки заказа в body
  public void scrollToBodyOrderButton() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(BODY_ORDER_BUTTON));
  }

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

}


