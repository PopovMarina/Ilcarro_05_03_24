package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//a[contains(text(),'terms')]")
    WebElement termsOfUseLink;

    //@FindBy(xpath = "") ?? как описать чек-бокс?

    @FindBy(xpath = "//span[contains(text(),'Click')]")
    WebElement clickHereLink;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement yallaButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public SignUpPage fillNameField(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public SignUpPage fillLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public SignUpPage fillEmailField(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage fillPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }










}
