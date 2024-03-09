package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='dates']")
    WebElement datesField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement yallaButton;

    public HomePage(WebDriver driver) {
        super(driver);
        //??super(driver); что значит супер?
        driver.get("https://ilcarro.web.app/");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);

    }

//   как писать методы для выбора значений из списка??
//   ??? public HomePage fillCityField(String city) {
//        cityField.sendKeys(city);
//        return this;
//    }

//    ??? public HomePage fillDatesField(String dates) {
//
//    }

    public Alert clickByYallaButton() {
        yallaButton.click();
        return getAlertIfPresent();
    }
    //после кликанья на Ялла Баттон - перекидывает на страницу - нет
    //свободных машин. Как ее описать?

    private Alert getAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait((driver), Duration.ofMillis(5000));
            return wait.until(ExpectedConditions.alertIsPresent());
        }catch (TimeoutException e) {
            System.out.println("Allert isue " + e);
            return null;
        }
    }

    public void doSmth(){
        WebElement el = driver.findElement(By.xpath("//div[@class='header']//a[contains(text(),'Search')]"));
        el.click();
    }

}