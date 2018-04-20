package screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.Swipe;

public class Devices extends BaseScreen{

    @iOSFindBy(accessibility = "Devices")
    MobileElement devicesTab;

    @iOSFindBy(accessibility = "Nexus 10")////XCUIElementTypeStaticText[@name="Nexus 10"] - xpath
    MobileElement searchedDevice;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nexus 10\"])[2]")
    MobileElement deviceInfoOpened;

    @iOSFindBy(accessibility = "Print QR for this device")
    MobileElement printDeviceQRBtn;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Device Locator\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther")
    MobileElement qrPicture;

    public Devices(IOSDriver driver) {super(driver);}

    public void tapDevicesTab(){devicesTab.click();}

    public boolean isDevicesTabDisplayed(){return isElementDisplayed(devicesTab);}


     public void tapSearchedDevice(){
        Swipe.down(driver);
        searchedDevice.click();
    }

     public boolean isDevicesInfoDisplayed(){return isElementDisplayed(deviceInfoOpened);}

     public void tapPrintDeviceQRBtnb(){printDeviceQRBtn.click();}

     public boolean isQRPictureDisplayed(){return isElementDisplayed(qrPicture);}


}
