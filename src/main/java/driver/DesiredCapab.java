package driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DesiredCapab {

    public static IOSDriver setup() throws MalformedURLException, IllegalAccessException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Simulator");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
        dc.setCapability("platformName", "iOS");
        dc.setCapability(MobileCapabilityType.APP, "/Users/hburianova/Library/Developer/Xcode/DerivedData/DeviceInventory-facnmbvhylrnobbmhzhybgrepkeu/Build/Products/Debug-iphonesimulator/DeviceInventory.app");
        dc.setCapability(IOSMobileCapabilityType.APP_NAME, "Device Locator");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.lohika.deviceinventory");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("xcodeOrgId", "96KHWMMBV3");
        dc.setCapability("xcodeSigningId", "iPhone Developer");
        dc.setCapability("noReset", true);// if no simulator - false
        dc.setCapability("showXcodeLog", true);


        // dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
        // dc.setCapability("deviceName", "iPad 4 (KV, #1)"); //Here you have to provide exact Device Name
        //dc.setCapability("app","/Users/intelligrapesoftware/Downloads/dotrips.ipa");//change it
        //dc.setCapability("udid", "ec07296cc9f5ab340614ae2db188889aad98da7c");
        //dc.setCapability(MobileCapabilityType.APP, "/Users/hburianova/Desktop/DeviceInventory/DeviceInventory.ipa");


        return new IOSDriver (new URL("http://127.0.0.1:4723/wd/hub"), dc);}
}
