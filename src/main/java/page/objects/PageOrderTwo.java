package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageOrderTwo {
    private WebDriver driver;
    private final By DtPickField = By.xpath(".//div[@class='react-datepicker__input-container']");
    private final By rootField = By.xpath(".//div[@class='Dropdown-root']");
    private final By cComment = By.xpath("html/body/div/div/div/div/div/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Подтверждение заказа и возврат на главную страницу
    private final By confirmButton = By.xpath(".//div/div/div/div/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By orderId = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final By CheckState = By.xpath(".//div/div/div/div/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By returnLogo = By.xpath(".//div[@class='Header_Logo__23yGT']");

    public PageOrderTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void setDtPick() {
        driver.findElement(DtPickField).click();
    }

    public void setRoot() {
        driver.findElement(rootField).click();
    }

    public void setCommentClick() {
        driver.findElement(cComment).click();
    }

    public void setComment(String comment) {
        driver.findElement(cComment).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public WebElement findRentData(String rentData) {
        return driver.findElement(By.xpath(".//div[@aria-label='Choose " + rentData + "']"));
    }

    public WebElement findRentTime(String rentTime) {
        return driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentTime + "']"));
    }

    public WebElement scooterColor(String scColor) {
        return driver.findElement(By.xpath(".//input[@class='Checkbox_Input__14A2w' and @id='" + scColor + "']"));
    }

    public void confirmOrder() {
        driver.findElement(confirmButton).click();
    }

    public void checkData() {
        driver.findElement(CheckState).click();
    }

    public void backToMainPage() {
        driver.findElement(returnLogo).click();
    }

    public WebElement checkOrderId() {
        return driver.findElement(orderId);
    }
}