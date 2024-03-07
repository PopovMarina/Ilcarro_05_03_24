package tests;

import config.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import helpers.TopMenuItem;

public class TestClass extends BaseTest {

    @Test
    public void test001() throws InterruptedException{
        HomePage hp = new HomePage(getDriver());
        LoginPage logInPage = hp.openTopMenu(TopMenuItem.LOGIN);
        logInPage.openTopMenu(TopMenuItem.SEARCH);
        Thread.sleep(3000);
    }

}
