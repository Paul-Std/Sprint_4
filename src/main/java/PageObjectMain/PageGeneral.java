package PageObjectMain;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;


public class PageGeneral {
    private WebDriver driver;

    private final By orderButtonTop = By.xpath("html/body/div/div/div/div/div/button[@class='Button_Button__ra12g']"); //Кнопка "заказать" в верху страницы.
    private final By orderButtonLower = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "заказать" в середине страницы.
    private final By qMark1 = By.id("accordion__heading-0");//Вопрос: Сколько это стоит? И как оплатить?
    private final By qMark2 = By.id("accordion__heading-1"); //Вопрос: Хочу сразу несколько самокатов! Так можно?
    private final By qMark3 = By.id("accordion__heading-2"); //Вопрос: Как рассчитывается время аренды?
    private final By qMark4 = By.id("accordion__heading-3"); //Вопрос: Можно ли заказать самокат прямо на сегодня?
    private final By qMark5 = By.id("accordion__heading-4"); //Вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    private final By qMark6 = By.id("accordion__heading-5"); //Вопрос: Вы привозите зарядку вместе с самокатом?
    private final By qMark7 = By.id("accordion__heading-6"); //Вопрос: Можно ли отменить заказ?
    private final By qMark8 = By.id("accordion__heading-7"); //Вопрос: Я жизу за МКАДом, привезёте?

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public PageGeneral(WebDriver driver) {
        this.driver = driver;
    }

    // Кликнуть кнопку "заказть" в верху страницы
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonTop).click();
    }

    // Кликнуть кнопку "заказть" в центре страницы
    public void clickOrderButtonLower() {
        WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        driver.findElement(orderButtonLower).click();
    }

    //Нажатие на кнопки выпадающего списка:
    // Вопрос 1
    public void clickDropList1() throws InterruptedException {
        driver.findElement(qMark1).click();
        Thread.sleep(1000);
    }

    // Вопрос 2
    public void clickDropList2() throws InterruptedException {
        driver.findElement(qMark2).click();
        Thread.sleep(1000);
    }

    // Вопрос 3
    public void clickDropList3() throws InterruptedException {
        driver.findElement(qMark3).click();
        Thread.sleep(1000);
    }

    // Вопрос 4
    public void clickDropList4() throws InterruptedException {
        driver.findElement(qMark4).click();
        Thread.sleep(1000);
    }

    // Вопрос 5
    public void clickDropList5() throws InterruptedException {
        driver.findElement(qMark5).click();
        Thread.sleep(1000);
    }

    // Вопрос 6
    public void clickDropList6() throws InterruptedException {
        driver.findElement(qMark6).click();
        Thread.sleep(1000);
    }

    // Вопрос 7
    public void clickDropList7() throws InterruptedException {
        driver.findElement(qMark7).click();
        Thread.sleep(1000);
    }

    // Вопрос 8
    public void clickDropList8() throws InterruptedException {
        driver.findElement(qMark8).click();
        Thread.sleep(1000);
    }
}
