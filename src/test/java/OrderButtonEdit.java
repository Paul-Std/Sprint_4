import PageObjectMain.PageGeneral;
import PageObjectMain.PageOrderOne;
import PageObjectMain.PageOrderTwo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// переменные для параметров теста
@RunWith(Parameterized.class)// добавь аннотацию с раннером
public class OrderButtonEdit {
    private String btn;
    private String name;
    private String surname;
    private String street;
    private String subway;
    private String phoneNumber;
    private String rootDate;
    private String rootTime;
    private String sctColor;
    private String orderComment;

    public OrderButtonEdit(String btn, String name, String surname, String street, String subway, String phoneNumber, String rootDate, String rootTime, String sctColor, String orderComment) {
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
                {".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']", "Мария", "Пироговская", "Усачева, 3", ".//li[@data-index='0']", "88005555555", ".//div[@aria-label='Choose воскресенье, 24-е мая 2026 г.']", ".//div[@class='Dropdown-option' and text()='двое суток']", ".//input[@class='Checkbox_Input__14A2w' and @id='black']", "Комментарий"},
                {"html/body/div/div/div/div/div/button[@class='Button_Button__ra12g']", "Сергей", "Петров", "Комсомольский проспект, 18", ".//li[@data-index='8']", "88202223344", ".//div[@aria-label='Choose воскресенье, 31-е мая 2026 г.']", ".//div[@class='Dropdown-option' and text()='сутки']", ".//input[@class='Checkbox_Input__14A2w' and @id='grey']", "Без комментариев"},
                {"html/body/div/div/div/div/div/button[@class='Button_Button__ra12g']", "Иван", "Иванов", "3-я Фрунзенская улица, 12", ".//li[@data-index='15']", "88301313131", ".//div[@aria-label='Choose среда, 27-е мая 2026 г.']", ".//div[@class='Dropdown-option' and text()='семеро суток']", ".//input[@class='Checkbox_Input__14A2w' and @id='black']", "..."}
        };
    }


    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void OrderButtonEditCheck() throws InterruptedException {
        // запуск браузера, поиск кнопки "заказать"
        WebDriver driver = driverFactory.getDriver();
        PageGeneral pageGeneral = new PageGeneral(driver);
        pageGeneral.openPage();
        WebElement elementButton = driver.findElement(By.xpath(btn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementButton);
        driver.findElement(By.xpath(btn)).click();
        Thread.sleep(1000);
        // Заполнение 1 страницы формы заказа
        PageOrderOne pageOrderOne = new PageOrderOne(driver);
        pageOrderOne.setClientName(name);
        pageOrderOne.setClientSurName(surname);
        pageOrderOne.setClientAdr(street);
        pageOrderOne.setClientStation();
        WebElement elementSubway = driver.findElement(By.xpath(subway));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementSubway);
        driver.findElement(By.xpath(subway)).click();
        pageOrderOne.setClientPhoneNumber(phoneNumber);
        Thread.sleep(1000);
        pageOrderOne.clickOnwardButton();
        Thread.sleep(1000);
        // Заполнение 2 страницы формы заказа
        PageOrderTwo pageOrderTwo = new PageOrderTwo(driver);
        pageOrderTwo.setDtPick();
        driver.findElement(By.xpath(rootDate)).click();
        pageOrderTwo.setRoot();
        WebElement elementRoot = driver.findElement(By.xpath(rootTime));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elementRoot);
        driver.findElement(By.xpath(rootTime)).click();
        driver.findElement(By.xpath(sctColor)).click();
        pageOrderTwo.setCommentClick();
        pageOrderTwo.setComment(orderComment);
        Thread.sleep(1000);
        // Подтверждение заказа, выход на основную страницу сайта.
        pageOrderTwo.clickOrderButton();
        driver.findElement(By.xpath(".//div/div/div/div/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath(".//div/div/div/div/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath(".//div[@class='Header_Logo__23yGT']")).click();
        Thread.sleep(1000);
    }

}
