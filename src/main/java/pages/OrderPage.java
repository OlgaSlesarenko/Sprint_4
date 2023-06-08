package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

  private final WebDriver driver;

  public static final String ORDER_PAGE = "https://qa-scooter.praktikum-services.ru/order";

  //заголовок страницы "Для кого самокат"
  public static final By PAGE_NAME_CUSTOMER = By.xpath(".//div[@class = 'Order_Header__BZXOb' and  contains(text(), 'Для кого самокат')]");
  //заголовок страницы "Про аренду"
  public static final By PAGE_NAME_RENT = By.xpath(".//div[@class = 'Order_Header__BZXOb' and  contains(text(), 'Про аренду')]");
  //поле для ввода имени
  private static final By INPUT_NAME = By.xpath(".//input[@placeholder='* Имя']");
  //поле для ввода фамилии
  private static final By INPUT_SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
  //поле для ввода адреса
  private static final By INPUT_ADRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
  //поле для выбора станции метро
  private static final By DROPDOWN_METRO_STATION = By.xpath(".//input[@placeholder='* Станция метро']");
  //поле для ввода телефона
  private static final By INPUT_PHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
  //кнопка Далее
  public static final By BUTTON_NEXT = By.xpath(".//button[contains(text(), 'Далее')]");
  //поле даты доставки заказа
  private static final By INPUT_DELIVERY_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
  //выпадающий список срока аренды
  private static final By DROPDOWN_RENT_TIME = By.xpath(".//span[@class = 'Dropdown-arrow']");
  //выбор цвета "черный жемчуг" самоката
  private static final By BLACK_COLOUR = By.xpath(".//label[@for='black']");
  //выбор цвета "серая безысходность" самоката
  private static final By GREY_COLOUR = By.xpath(".//label[@for='grey']");
  //поле Комментарий для курьера
  private static final By INPUT_COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
  //кнопка Заказать
  public static final By BUTTON_ORDER = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
  //кнопка "Да" подтверждения заказа
  public static final By BUTTON_CONFIRM_ORDER = By.xpath(".//button[text() = 'Да']");
  //заголовок окна подтверждения заказа
  public static final By CONFIRM_ORDER_HEADER = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

  public OrderPage(WebDriver driver) {
    this.driver = driver;
  }
  // метод для проверки доступности редактирования поля, удаления текста из него и ввода нового значения из параметра
  public void fillInInput(By input, String newValue) {
    driver.findElement(input).sendKeys(newValue);
  }
  //метод для выбора станции метро через data-index в локаторе
  public void selectStation(int dataIndex) {
    //поле выбора станции метро из дропдауна
    By metroStation = By.xpath(String.format(".//li[@data-index='%s']", dataIndex));
    driver.findElement(metroStation).click();
  }
  //заполление формы инфо о заказчике:
  public void fillInFormPerson(String name, String surname, String adress, int dataIndex, String phone) {
    fillInInput(INPUT_NAME, name);
    fillInInput(INPUT_SURNAME, surname);
    fillInInput(INPUT_ADRESS, adress);
    clickElement(DROPDOWN_METRO_STATION);
    selectStation(dataIndex);
    fillInInput(INPUT_PHONE, phone);
  }
  //заполнение формы инфо о заказе:
  public void fillInFormOrder(String deliveryDate, int position, String comment) {
    fillInInput(INPUT_DELIVERY_DATE, deliveryDate);
    clickElement(DROPDOWN_RENT_TIME);
    selectRentTime(position);
    clickElement(BLACK_COLOUR);
    clickElement(GREY_COLOUR);
    fillInInput(INPUT_COMMENT, comment);
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

}
