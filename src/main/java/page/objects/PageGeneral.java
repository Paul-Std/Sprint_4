package page.objects;

import org.openqa.selenium.*;


public class PageGeneral {
    private WebDriver driver;

    private final By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']"); //Кнопка "заказать" в верху страницы.
    private final By orderButtonLower = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "заказать" в середине страницы.


    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public PageGeneral(WebDriver driver) {
        this.driver = driver;
    }

    // Кликнуть кнопку "заказть" в верху страницы
    public WebElement clickOrderButtonUp() {
        return driver.findElement(orderButtonTop);
    }

    // Кликнуть кнопку "заказть" в центре страницы
    public WebElement clickOrderButtonLower() {
       return driver.findElement(orderButtonLower);
    }

    //Нажатие на кнопки выпадающего списка:

    public WebElement dropListButton(Integer qNumber) {
        return driver.findElement(By.id("accordion__heading-" + qNumber));
    }

    public WebElement dropListAnswer(Integer qAnswer) {
        return driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-" + qAnswer + "']"));
    }
}
