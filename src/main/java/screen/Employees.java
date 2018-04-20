package screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Employees extends BaseScreen{

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Employees\"]")//or name
    MobileElement employeesTab;

    @iOSFindBy(accessibility = "Search")
    MobileElement searchBtn;

    @iOSFindBy(accessibility = "scopeBar")//or "Search User" if doesn't work
    MobileElement searchBar;

    @iOSFindBy(accessibility = "All")
    MobileElement searchAll;

    @iOSFindBy(accessibility = "Name")
    MobileElement searchName;

    @iOSFindBy(accessibility = "Email")
    MobileElement searchEmail;

    @iOSFindBy(xpath = "(//XCUIElementTypeImage[@name=\"user\"])[1]")
    MobileElement firstFoundUser;

    @iOSFindBy(accessibility = "Create QR Code")
    MobileElement createQRCodeBtn;

    @iOSFindBy(accessibility = "Send by Mail")//no this button in inspector
    MobileElement sendByMailBtn;

    @iOSFindBy(accessibility = "ipleskach@lohika.com")//email of found user that is shown on left side
    MobileElement foundUser;

    @iOSFindBy(accessibility = "ipleskach@lohika.com")
    MobileElement searchedKey;//should it be like this or just string here or in the method

    public Employees(IOSDriver driver) {super(driver);}

    public void tapEmployeesTab(){employeesTab.click();}

    public boolean isEmployeesTabDisplayed(){return isElementDisplayed(employeesTab);}

    //public boolean isEmployeesTabSelected(){return isElementDisplayed(employeesTab.getCssValue('1'));} how to check wether element has value or value is 1

    public void tapSearchBar(){searchBar.click();}

    public void tapSearchAll(){searchAll.click();}

    public void tapSearchName(){searchName.click();}

    public void tapSearchEmail(){searchEmail.click();}

    public void searchUserByKey(){searchBar.sendKeys("ipleskach");}//should it be this way?

    public void searchInAllByKey(){searchAll.sendKeys("ipleskach");}//should it be this way?

    public boolean isUserFound(){return isElementDisplayed(firstFoundUser);}

    public void tapFoundUser(){firstFoundUser.click();}

    public boolean isUserFoundProperly(){return isElementDisplayed(foundUser);}

    public void tapCreateQRCodeBtn(){createQRCodeBtn.click();}

    public void tapSendByMailBtn(){sendByMailBtn.click();}

    public boolean isSendByEmailShown(){return isElementDisplayed(sendByMailBtn);}

    public boolean isSendByEmailNotShown(){return !isElementDisplayed(sendByMailBtn);}

}
