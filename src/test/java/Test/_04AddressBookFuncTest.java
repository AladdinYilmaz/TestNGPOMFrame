package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _04AddressBookFuncTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    public void login(){

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("aaa@aaaa.com");
        loginPageElements.passwordInput.sendKeys("aaaaaa");
        loginPageElements.loginButton.click();

    }


    @Test(priority = 1)
    public void addNewAddress(){
        login();
        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(myAccountHeaderText, "My Account");
        myAccountPageElements.addressBookButton.click();
        myAccountPageElements.newAddressButton.click();
        myAccountPageElements.firstNameInput.sendKeys("ddddddddd1");
        myAccountPageElements.lastNameInput.sendKeys("ddddd1");
        myAccountPageElements.address1Input.sendKeys("address dddddddddddd1");
        myAccountPageElements.cityInput.sendKeys("city ddd1");
        myAccountPageElements.postalCodeInput.sendKeys("1545551");
        Select selectCountry=new Select(myAccountPageElements.countryDropdown);
        selectCountry.selectByVisibleText("Turkey");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.stateDropdown));
//       myAccountPageElements.stateDropdown.click();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.stateDropdown));
        Select selectState=new Select(myAccountPageElements.stateDropdown);
        selectState.selectByVisibleText("Ankara");
        myAccountPageElements.defaultAddressNoRadioButton.click();
        myAccountPageElements.addressAddContinueButton.click();
        String expectedMessage="Your address has been successfully added";

        Assert.assertEquals(myAccountPageElements.addAddressSuccessMessage.getText(),expectedMessage);


}

   @Test(priority = 3)
    public void editAddress(){
        login();
       String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();
       Assert.assertEquals(myAccountHeaderText, "My Account");
       myAccountPageElements.addressBookButton.click();

       myAccountPageElements.editAddressBookButton.click();
       myAccountPageElements.firstNameInput.clear();
       myAccountPageElements.firstNameInput.sendKeys("ddddddddd5");
       myAccountPageElements.lastNameInput.clear();
       myAccountPageElements.lastNameInput.sendKeys("ddddd5");
       myAccountPageElements.address1Input.clear();
       myAccountPageElements.address1Input.sendKeys("address dddddddddddd5");
       myAccountPageElements.cityInput.clear();
       myAccountPageElements.cityInput.sendKeys("city ddd5");
       myAccountPageElements.postalCodeInput.clear();
       myAccountPageElements.postalCodeInput.sendKeys("154333");
       Select selectCountry=new Select(myAccountPageElements.countryDropdown);
       selectCountry.selectByVisibleText("Sudan");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.stateDropdown));
       Select selectState=new Select(myAccountPageElements.stateDropdown);
       selectState.selectByVisibleText("Kassala");
       myAccountPageElements.defaultAddressNoRadioButton.click();
       myAccountPageElements.addressAddContinueButton.click();
       String expectedMessage="Your address has been successfully updated";
       Assert.assertEquals(myAccountPageElements.updateAddressSuccessMessage.getText(),expectedMessage);



    }

    @Test(priority = 5)
    public void deleteAddress(){
        login();
        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(myAccountHeaderText, "My Account");
        myAccountPageElements.addressBookButton.click();

        myAccountPageElements.deleteAddressBookButton.click();
        String expectedMessage="Your address has been successfully deleted";
        Assert.assertEquals(myAccountPageElements.deleteAddressSuccessMessage.getText(),expectedMessage);

    }


}
