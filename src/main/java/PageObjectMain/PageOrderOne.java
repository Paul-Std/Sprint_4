package PageObjectMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOrderOne {
    private WebDriver driver;
    private final By nameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    private final By surNameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    private final By stationField = By.xpath(".//div[@class='select-search']");
    private final By phoneField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    private final By onwardButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public PageOrderOne(WebDriver driver) {
        this.driver = driver;
    }

    public void setClientName(String firstName) {
        driver.findElement(nameField).sendKeys(firstName);
    }

    public void setClientSurName(String secondName) {
        driver.findElement(surNameField).sendKeys(secondName);
    }

    public void setClientAdr(String ordAdr) {
        driver.findElement(addressField).sendKeys(ordAdr);
    }

    public void setClientStation() {
        driver.findElement(stationField).click();
    }

    public void setClientPhoneNumber(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickOnwardButton() {
        driver.findElement(onwardButton).click();
    }
}