import org.junit.Assert;
import page.objects.PageGeneral;
import page.objects.PageOrderOne;
import page.objects.PageOrderTwo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// переменные для параметров теста
@RunWith(Parameterized.class)// добавь аннотацию с раннером
public class OrderButtonEdit {
    private String btn;
    private String name;
    private String surname;
    private String street;
    private Integer subway;
    private String phoneNumber;
    private String rootDate;
    private String rootTime;
    private String sctColor;
    private String orderComment;

    public OrderButtonEdit(String btn, String name, String surname, String street, Integer subway, String phoneNumber, String rootDate, String rootTime, String sctColor, String orderComment) {
        this.btn = btn;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.rootDate = rootDate;
        this.rootTime = rootTime;
        this.sctColor = sctColor;
        this.orderComment = orderComment;
    }

    // параметры теста
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"buttonLower", "Мария", "Пироговская", "Усачева, 3", 0, "88005555555", "воскресенье, 24-е мая 2026 г.", "двое суток", "black", "Комментарий"},
                {"buttonUp", "Сергей", "Петров", "Комсомольский проспект, 18", 8, "88202223344", "воскресенье, 31-е мая 2026 г.", "сутки", "grey", "Без комментариев"},
                {"buttonUp", "Иван", "Иванов", "3-я Фрунзенская улица, 12", 15, "88301313131", "среда, 27-е мая 2026 г.", "семеро суток", "black", "..."}
        };
    }


    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void orderButtonEditCheck() throws InterruptedException {
        // запуск браузера, поиск кнопки "заказать"
        WebDriver driver = driverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        PageGeneral pageGeneral = new PageGeneral(driver);
        pageGeneral.openPage();
        if (btn == "buttonLower") {
            WebElement elementButtonLower = pageGeneral.clickOrderButtonLower();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementButtonLower);
            elementButtonLower.click();
        } else {
            WebElement elementButtonUp = pageGeneral.clickOrderButtonUp();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementButtonUp);
            elementButtonUp.click();
        }
        // Заполнение 1 страницы формы заказа
        PageOrderOne pageOrderOne = new PageOrderOne(driver);
        pageOrderOne.setClientName(name);
        pageOrderOne.setClientSurName(surname);
        pageOrderOne.setClientAdr(street);
        pageOrderOne.setClientStation();
        WebElement elementSubway = pageOrderOne.findSubway(subway);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementSubway);
        elementSubway.click();
        pageOrderOne.setClientPhoneNumber(phoneNumber);
        pageOrderOne.clickOnwardButton();
        // Заполнение 2 страницы формы заказа
        PageOrderTwo pageOrderTwo = new PageOrderTwo(driver);
        pageOrderTwo.setDtPick();
        pageOrderTwo.findRentData(rootDate).click();
        pageOrderTwo.setRoot();
        WebElement elementRent = pageOrderTwo.findRentTime(rootTime);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementRent);
        elementRent.click();
        pageOrderTwo.scooterColor(sctColor).click();
        pageOrderTwo.setCommentClick();
        pageOrderTwo.setComment(orderComment);
        // Подтверждение заказа, выход на основную страницу сайта.
        pageOrderTwo.clickOrderButton();
        pageOrderTwo.confirmOrder();
        WebElement orderData = pageOrderTwo.checkOrderId();
        Assert.assertTrue("Элемент не найден или не отображается!", orderData.isDisplayed());
        pageOrderTwo.checkData();
        pageOrderTwo.backToMainPage();
    }
}
