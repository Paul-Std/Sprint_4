import PageObjectMain.PageGeneral;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;


public class Sprint4AccordionPanel {


    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void AccordionPanelCheck() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        PageGeneral pageGeneral = new PageGeneral(driver);
        pageGeneral.openPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pageGeneral.clickDropList1();
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-0']")).getText());
        pageGeneral.clickDropList2();
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-1']")).getText());
        pageGeneral.clickDropList3();
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-2']")).getText());
        pageGeneral.clickDropList4();
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-3']")).getText());
        pageGeneral.clickDropList5();
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-4']")).getText());
        pageGeneral.clickDropList6();
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-5']")).getText());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pageGeneral.clickDropList7();
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-6']")).getText());
        pageGeneral.clickDropList8();
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(By.xpath(".//div[@role='region' and @id='accordion__panel-7']")).getText());
    }
}