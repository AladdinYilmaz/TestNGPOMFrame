package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03EditAccountTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    String expectedMessage = "Success: Your account has been successfully updated.";

    @Test
    public void editAccountTest() {

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

        myAccountPageElements.editAccountButton.click();

        myAccountPageElements.firstNameInput.clear();
        myAccountPageElements.firstNameInput.sendKeys("Kevin");

        myAccountPageElements.lastNameInput.clear();
        myAccountPageElements.lastNameInput.sendKeys("Debruyne");

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessage);

    }
}
