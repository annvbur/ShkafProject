package screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.Swipe;

public class Transactions extends BaseScreen{

    @iOSFindBy(accessibility = "Transactions")
    MobileElement transactionsTab;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Borrowing\"]")//value = 0 if switched off and 1 when switched on
    MobileElement borrowingSwitch;

//    @iOSFindBy(id = "Borrowing")//value = 0 if switched off and 1 when switched on
//    MobileElement borrowingSwitch;

    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"To Stock\"]")//value = 0 if switched off and 1 when switched on
    MobileElement toStockSwitch;

    @iOSFindBy(accessibility = "Reset")
    MobileElement resetBtn;

    public Transactions(IOSDriver driver) {super(driver);}

    public void tapTransactionsTab(){transactionsTab.click();}

    public boolean isTransactionsTabDisplayed(){return isElementDisplayed(transactionsTab);}

    public void getBorrowSwitchValue(){borrowingSwitch.getAttribute("value");}

    public void setOFFBorrowSwitch(){borrowingSwitch.setValue("0");}

    public void getToStockSwitchValue(){toStockSwitch.getAttribute("value");}

    public void setOFFtoStockSwitch(){toStockSwitch.setValue("0");}

    public boolean isBorrowSwitchNOTSelected(){return !borrowingSwitch.isSelected();}

    public boolean isToStockSwitchNOTSelected(){return !toStockSwitch.isSelected();}

    public boolean isBorrowSwitchSelected(){return borrowingSwitch.isSelected();}

    public boolean isToStockSwitchSelected(){return toStockSwitch.isSelected();}

    public void tapResetButton(){
        Swipe.down(driver);
        resetBtn.click();
    }

    public boolean areAllSwitchesOn(){return toStockSwitch.isSelected()&&borrowingSwitch.isSelected();}

}
