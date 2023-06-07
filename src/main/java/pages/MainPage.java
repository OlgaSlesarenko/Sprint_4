package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

  public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";

  private WebDriver driver;
//  private int number;

  //кнопка "Заказать" в Header
  private final By headerOrderButton = By.className("Button_Button__ra12g");
  //кнопка "Статус заказа" в Хедере
  private final By orderStatusButton = By.className("Header_Link__1TAG7");
  //кнопка "Заказать" в Body
  private final By bodyOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
  //Заголовок раздела "Вопросы о важном"
  private final By faqTitle = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");
  //Header первого пункта раскрывающегося списка "Вопросы о важном"
  private final By firstFAQHeader = By.id("accordion__heading-0");


//  //Header пункта раскрывающегося списка "Вопросы о важном"
//  private By faqHeader = By.xpath(String.format(".//div[@id='accordion__heading-%s']", number));
//  //Текст первого пункта раскрывающегося списка "Вопросы о важном"
//  private By faqAnswer = By.xpath(String.format(".//div[@id = 'accordion__panel-%s']/p", number));
//
//  public By getNumberFaqHeader(int number) {
//    faqHeader = By.xpath(String.format(".//div[@id='accordion__heading-%s']", number));
//    return faqHeader;
//  }
//  public By getNumberFaqAnswer(int number) {
//    faqHeader = By.xpath(String.format(".//div[@id = 'accordion__panel-%s']/p']", number));
//    return faqHeader;
//  }


  //Текст первого пункта раскрывающегося списка "Вопросы о важном"
  private final By firstFAQAnswer = By.xpath(".//div[@id = 'accordion__panel-0']/p");
  //Header четвертого пункта раскрывающегося списка "Вопросы о важном"
  private final By fourthFAQHeader = By.id("accordion__heading-3");
  //Текст четвертого пункта раскрывающегося списка "Вопросы о важном"
  private final By fourthFAQAnswer = By.xpath(".//div[@id = 'accordion__panel-3']/p");
  //Header восьмого пункта раскрывающегося списка "Вопросы о важном"
  private final By eighthFAQHeader = By.id("accordion__heading-7");
  //Текст восьмого пункта раскрывающегося списка "Вопросы о важном"
  private final By eighthFAQAnswer = By.xpath(".//div[@id = 'accordion__panel-7']/p");

  // метод кликает по нужному элементу
  public void clickElement(By element) {
    driver.findElement(element).click();
  }

  //метод для проверки того, что после клика по одному элементу другой отображается на странице
  public void checkElementIsDisplayedAfterClick(By clickedElement, By checked) {
    driver.findElement(clickedElement).click();
    driver.findElement(checked).isDisplayed();
  }
  //метод для получения текста в элементе
  public String getElementText(By element) {
    String textInElement = driver.findElement(element).getText();
    return textInElement;
  }

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

//  public WebDriver getDriver() {
//    return driver;
//  }
//
  public By getHeaderOrderButton() {
    return headerOrderButton;
  }

//  public By getOrderStatusButton() {
//    return orderStatusButton;
//  }
//
//  public By getBodyOrderButton() {
//    return bodyOrderButton;
//  }

  public By getFaqTitle() {
    return faqTitle;
  }

  public By getFirstFAQHeader() {
    return firstFAQHeader;
  }

  public By getFirstFAQAnswer() {
    return firstFAQAnswer;
  }

  public By getFourthFAQHeader() {
    return fourthFAQHeader;
  }

  public By getFourthFAQAnswer() {
    return fourthFAQAnswer;
  }

  public By getEighthFAQHeader() {
    return eighthFAQHeader;
  }

  public By getEighthFAQAnswer() {
    return eighthFAQAnswer;
  }
}


