package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetScreenshot {private final static String scrShotDir = System.getProperty("user.home") + File.separator + "Reports";
    private static String destFile;

    public static String capture(AppiumDriver driver) throws IOException
    {
        File scrFile = (driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(scrShotDir).mkdirs();

        destFile = dateFormat.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(scrShotDir + File.separator + destFile));
        } catch (IOException e) {
            System.out.println("Image not transfered to screenshot folder");
            e.printStackTrace();
        }
        return destFile;
    }
}
