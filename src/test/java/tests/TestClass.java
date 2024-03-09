package tests;

import config.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LogInPage;
import pages.TopMenuItem;

public class TestClass extends BaseTest {

    @Test
    public void test001() throws InterruptedException{
        HomePage hp = new HomePage(getDriver());
        LogInPage logInPage = hp.openTopMenu(TopMenuItem.LOGIN);
        //logInPage.openTopMenu(TopMenuItem.SEARCH);
        logInPage.tryToFindElement();
        LetTheCarWorkPage lcwp = logInPage.openTopMenu(TopMenuItem.LET_THE_CAR_WORK);
        lcwp.setManufacturer("BMW").addLocation("Montana").setFuelType().
                photoAttachment("/Users/marina/Desktop/мои трейды/1e5fb2a7-aa90-4d74-a28c-098f04f45ba3.jpg");

        Thread.sleep(3000);
    }

}
