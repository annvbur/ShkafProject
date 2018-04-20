package application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import screen.Devices;
import screen.Employees;
import screen.Inventory;
import screen.Transactions;

public class Shkaf{
    private IOSDriver driver;

    public Shkaf(IOSDriver driver) throws IllegalAccessException
    {
        this.driver = driver;
    }

    public Inventory Inventory()
    {
        return new Inventory(driver);
    }

    public Devices Devices()
    {
        return new Devices(driver);
    }

    public Employees Employees()
    {
        return new Employees(driver);
    }

    public Transactions Transactions()
    {
        return new Transactions(driver);
    }

}
