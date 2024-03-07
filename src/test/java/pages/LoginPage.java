package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    // может быть таким же как в Сайн ап?

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(),'Click')]")
    WebElement clickHereLink;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement yallaButton;


    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    public LoginPage fillEmailField(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public BasePage clickByYallaButton() {
        yallaButton.click();
       Alert alert = getAlertIfPresent();
       if(alert != null) {
           alert.accept();
           return new LoginPage(driver);
       }else
       {
           return new SearchPage(driver);
       }
    }

    private Alert getAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait((driver), Duration.ofMillis(5000));
            return wait.until(ExpectedConditions.alertIsPresent());
        }catch (TimeoutException e) {
            System.out.println("Allert isue " + e);
            return null;
        }
    }
}
//
//public void tryToFindElement() {
//    List<WebElement> list = driver.findElements(By.xpath("//a"));
//    System.out.println("SIZE :" + list.size());
//}
//}

