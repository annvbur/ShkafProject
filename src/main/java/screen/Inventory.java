package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.Swipe;

public class Inventory extends BaseScreen{

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Inventory\"]")//or name Inventory
    MobileElement inventoryTab;

    @iOSFindBy(accessibility = "Login from List")
    MobileElement loginFromListBtn;

    @iOSFindBy(accessibility = "Iurii Pleskatch")
    MobileElement userName;

    @iOSFindBy(accessibility = "Name")
    MobileElement userNotLoggedInName;

    @iOSFindBy(accessibility = "Log Out")
    MobileElement logOutBtn;

    public Inventory(IOSDriver driver) {super(driver);}
    //public Home(AppiumDriver driver) {this.driver = driver;}


    public void tapInventoryTab(){inventoryTab.click();}

    public boolean isInvenoryTabDisplayed(){return isElementDisplayed(inventoryTab);}

    //public boolean isInvenoryTabSelected(){return isElementDisplayed(inventoryTab.getCssValue('1'));} how to check wether element has value or value is 1

    public void tapLoginFromList(){loginFromListBtn.click();}

    public void selectUser(){userName.click();}

    public void tapLogout(){logOutBtn.click();}

    public boolean isUserLogedIn(){return !isElementDisplayed(userNotLoggedInName);}

    public boolean isLogoutBtnDisplayed(){return isElementDisplayed(logOutBtn);}

    public boolean isUserLogedOut(){return isElementDisplayed(userNotLoggedInName);}




}
