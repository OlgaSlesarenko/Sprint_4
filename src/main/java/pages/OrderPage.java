package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

  private WebDriver driver;

  public static final String ORDER_PAGE = "https://qa-scooter.praktikum-services.ru/order";

  //заголовок страницы
  private static final By pageName = By.xpath(".//div[@class = 'Order_Header__BZXOb']");
  //поле для ввода имени
  private static final By inputName = By.xpath(".//input[@placeholder='* Имя']/..");
  //поле для ввода фамилии
  private static final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']/..");
  //поле для ввода адреса
  private static final By inputAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']/..");
  //поле для выбора станции метро
  private static final By dropdownMetroStation = By.xpath(".//input[@placeholder='* Станция метро']/..");
  //поле для ввода телефона
  private static final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']/..");
  //кнопка Далее
  private static final By buttonNext = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']");
  //поле даты доставки заказа
  private static final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']/..");
  //выпадающий список срока аренды
  private static final By rentTime = By.xpath(".//div[@class='Dropdown-control']");
  //выбор цвета "черный жемчуг" самоката
  private static final By blackColour = By.xpath(".//label[@for='black']");
  //выбор цвета "серая безысходность" самоката
  private static final By greyColour = By.xpath(".//label[@for='grey']");
  //поле Комментарий для курьера
  private static final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']/..");
  //кнопка Заказать
  private static final By buttonOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
  //кнопка "Да" подтверждения заказа
  private static final By buttonConfirmOrder = By.xpath(".//button[text() = 'Да']");
  //заголовок окна подтверждения заказа
  private static final By confirmOrderHeader = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");
//  //кнопка просмотра статуса
//  private static final By buttonCheckStatus = By.xpath(".//button[contains(text(), 'Посмотреть статус')]");

  // метод для проверки доступности редактирования поля, удаления текста из него и ввода нового значения из параметра
  public void fillInInput(By input, String newValue) {
    driver.findElement(input).isEnabled();
    driver.findElement(input).clear();
    driver.findElement(input).sendKeys(newValue);
  }

  //метод для выбора станции метро через data-index в локаторе
  public void selectStation(int dataIndex) {
    //поле выбора станции метро из дропдауна
    By metroStation = By.xpath(String.format(".//li[@data-index='%s']", dataIndex));
    driver.findElement(metroStation).click();
  }

  // метод кликает по нужному элементу
  public void clickElement(By element) {
    driver.findElement(element).click();
  }

  //метод для выбора rentTime в выпадающем списке
  public void selectRentTime(int position) {
    //поле выбора промежутка времени аренды
    By rentTime = By.xpath(String.format(".//div[@class='Dropdown-option']['%s']", position));
    driver.findElement(rentTime).click();
  }

  //метод для получения текста в элементе
  public String getElementText(By element) {
    return driver.findElement(element).getText();
  }

}
