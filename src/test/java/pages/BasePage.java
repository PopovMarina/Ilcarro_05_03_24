package pages;

import helpers.TopMenuItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver) {

        driver = webDriver;
    }
    public <T extends BasePage> T openTopMenu(TopMenuItem topMenuItem) {
        String menuItemName = topMenuItem.getLabel();
        WebElement menuItem = driver.findElement(By
                .xpath("//div[@class='header']//a[contains(text(),'"
                        + menuItemName + "')]"));
        menuItem.click();

        switch (topMenuItem) {
            case SEARCH:
                return (T) new SearchPage(driver);
            case TERMS_OF_USE:
                return (T) new TermsOfUsePage(driver);
            case LOGIN:
                return (T) new LoginPage(driver);
            case SIGN_UP:
                return (T) new SignUpPage(driver);
            case LET_THE_CAR_WORK:
                return (T) new LetTheCarWorkPage(driver);
            default:
                throw new IllegalArgumentException("Something is wrong " + topMenuItem);

        }
    }
    }

