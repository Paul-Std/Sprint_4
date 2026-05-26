package PageObjectMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOrderTwo {
    private WebDriver driver;
    private final By DtPickField = By.xpath(".//div[@class='react-datepicker__input-container']");
    private final By rootField = By.xpath(".//div[@class='Dropdown-root']");
    private final By cComment = By.xpath("html/body/div/div/div/div/div/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

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
}