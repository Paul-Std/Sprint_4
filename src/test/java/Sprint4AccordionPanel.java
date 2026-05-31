import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.PageGeneral;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)// добавь аннотацию с раннером
public class Sprint4AccordionPanel {
    private Integer findWay;
    private String expected;
    private Integer actual;

    public Sprint4AccordionPanel(Integer findWay, String expected, Integer actual) {
        this.findWay = findWay;
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void accordionPanelCheck() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        PageGeneral pageGeneral = new PageGeneral(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageGeneral.openPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement elementQuestion = pageGeneral.dropListButton(findWay);
        elementQuestion.click();
        WebElement elementActual = pageGeneral.dropListAnswer(actual);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(elementActual));
        Assert.assertEquals(expected, elementActual.getText());
    }
}