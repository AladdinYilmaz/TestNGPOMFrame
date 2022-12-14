package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01LoginTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

 @Test
    public void loginPositiveTest() {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);
        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();
        loginPageElements.emailInput.sendKeys("aaa@aaaa.com");
        loginPageElements.passwordInput.sendKeys("aaaaaa");
        loginPageElements.loginButton.click();
        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(myAccountHeaderText, "My Account");

    }

    @Test
    public void loginNegativeTest() {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("test@technostudy.com");
        loginPageElements.passwordInput.sendKeys("Test1234!!!");
        loginPageElements.loginButton.click();

        String errorActualText = loginPageElements.errorMessage.getText();
        boolean isErrorDisplayed = loginPageElements.errorMessage.isDisplayed();

        Assert.assertTrue(isErrorDisplayed);
        Assert.assertEquals(errorActualText, "Warning: No match for E-Mail Address and/or Password.");

    }

}
