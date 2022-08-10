package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
//Scenario - Search Functionality:
//        - Navigate http://opencart.abstracta.us/ (you already have this part in your beforeMethod)
//        - Search for an item (like mac or sony)
//        - Validate all the items in result page contains your search keyword


public class _05SearchFunctionality extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;


    @Test
    public void searchFunctionality(){
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);
        String searchItem="mac";
        homePageElements.searchText.sendKeys(searchItem);
        homePageElements.searchButton.click();
        Assert.assertEquals(homePageElements.searchResultText.getText(),("Search - "+searchItem));

        for (WebElement element : homePageElements.searchItemList) {
            String textOfElement = element.getText();
            System.out.println(textOfElement);
            Assert.assertTrue(textOfElement.toLowerCase().contains(searchItem));
        }




    }








}
