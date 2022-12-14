package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPageElements {
    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountHeader;
    @FindBy(xpath = "//*[@id=\"content\"]/h2")
    public WebElement addressBookHeader;
    @FindBy(xpath = "//a[text()='Newsletter']")
    public WebElement newsletterButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    public WebElement subscribeYesRadioButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    public WebElement subscribeNoRadioButton;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[text()='Edit Account']")
    public WebElement editAccountButton;

    @FindBy(id = "input-firstname")
    public WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    public WebElement lastNameInput;

    @FindBy(xpath = "//a[text()='Address Book']")
    public WebElement addressBookButton;

    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAddressButton;

    @FindBy(id = "input-address-1")
    public WebElement address1Input;

    @FindBy(id = "input-city")
    public WebElement cityInput;

    @FindBy(id = "input-postcode")
    public WebElement postalCodeInput;

    @FindBy(id = "input-country")
    public WebElement countryDropdown;

    @FindBy(xpath = ("//select[@id='input-zone']"))
    public WebElement stateDropdown;

    @FindBy(xpath = "(//input[@name='default'])[1]")
    public WebElement defaultAddressYesRadioButton;

    @FindBy(xpath = "(//input[@name='default'])[2]")
    public WebElement defaultAddressNoRadioButton;

    @FindBy(xpath = "(//*[@id=\"content\"]/form/div/div[2]/input)")
    public WebElement addressAddContinueButton;
    @FindBy(xpath = "//*[text()= ' Your address has been successfully added']")
    public WebElement addAddressSuccessMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a[1]")
    public WebElement editAddressBookButton;

    @FindBy(xpath = "//*[text()= ' Your address has been successfully updated']")
    public WebElement updateAddressSuccessMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[2]")
    public WebElement deleteAddressBookButton;
    @FindBy(xpath = "//*[text()= ' Your address has been successfully deleted']")
    public WebElement deleteAddressSuccessMessage;

    @FindAll({@FindBy(css = "a[class='btn btn-info']")})
    public List<WebElement> editButtonList;

}
