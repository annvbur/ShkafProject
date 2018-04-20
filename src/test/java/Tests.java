import application.Shkaf;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import screen.Inventory;

import static org.testng.AssertJUnit.assertTrue;

public class Tests extends TestBase {

        @Test
        public void Login() {
            logger = extent.createTest("T1: User can log in");
            logger.assignCategory("Inventory Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Inventory().tapInventoryTab();
            assertTrue("Inventory Tab is NOT displayed", shkaf.Inventory().isInvenoryTabDisplayed());
            shkaf.Inventory().tapLoginFromList();
            shkaf.Inventory().selectUser();
            assertTrue("User info is NOT displayed", shkaf.Inventory().isUserLogedIn());
            assertTrue("LogOut button is NOT displayed", shkaf.Inventory().isLogoutBtnDisplayed());
            logger.log(Status.PASS, "Verify whether user can log in");
        }

        @Test
        public void Logout() {
            logger = extent.createTest("T2: User can log out");
            logger.assignCategory("Inventory Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Inventory().tapInventoryTab();
            assertTrue("Inventory Tab is NOT displayed", shkaf.Inventory().isInvenoryTabDisplayed());
            shkaf.Inventory().tapLoginFromList();
            shkaf.Inventory().selectUser();
            assertTrue("User info is NOT displayed", shkaf.Inventory().isUserLogedIn());
            assertTrue("LogOut button is NOT displayed", shkaf.Inventory().isLogoutBtnDisplayed());
            shkaf.Inventory().tapLogout();
            assertTrue("LogOut button is NOT tappable", shkaf.Inventory().isUserLogedOut());
            logger.log(Status.PASS, "Verify whether user can log out");
        }

        @Test
        public void EmployeesSearch() {//how to organize it properly
            logger = extent.createTest("T3: User can search through employees");
            logger.assignCategory("Employees Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Employees().tapEmployeesTab();
            assertTrue("Employees Tab is NOT displayed", shkaf.Employees().isEmployeesTabDisplayed());
            shkaf.Employees().tapSearchBar();//why can't I do .searchUserByKey()
            shkaf.Employees().searchUserByKey();
            assertTrue("Needed employee is NOT found", shkaf.Employees().isUserFound());
            assertTrue("Needed employee is found properly", shkaf.Employees().isUserFoundProperly());
            logger.log(Status.PASS, "Verify whether user can search through employees");
        }

        @Test
        public void SendByEmailLogic() {
            logger = extent.createTest("T4: Search by email button is shown after QR code is generated");
            logger.assignCategory("Employees Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Employees().tapEmployeesTab();
            assertTrue("Employees Tab is NOT displayed", shkaf.Employees().isEmployeesTabDisplayed());
            shkaf.Employees().tapFoundUser();
            assertTrue("Send By Email shown when should NOT be", shkaf.Employees().isSendByEmailNotShown());
            shkaf.Employees().tapCreateQRCodeBtn();
            assertTrue("Send By Email is NOT hown when should be", shkaf.Employees().isSendByEmailShown());
            logger.log(Status.PASS, "Verify whether Send By Email button is shown after QR code creation");
        }

        @Test
        public void ScrollToFindNeededDevice() {
            logger = extent.createTest("T5: Scroll list to find needed device");
            logger.assignCategory("Devices Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Devices().tapDevicesTab();
            assertTrue("Devices Tab is NOT displayed", shkaf.Devices().isDevicesTabDisplayed());
            shkaf.Devices().tapSearchedDevice();
            assertTrue("Needed device is NOT displayed", shkaf.Devices().isDevicesInfoDisplayed());
            logger.log(Status.PASS, "Verify user can find needed device and open details");
        }

        @Test
        public void PrintQRCodeWorks() {
            logger = extent.createTest("T6: Print of QR code works");
            logger.assignCategory("Devices Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Devices().tapDevicesTab();
            assertTrue("Devices Tab is NOT displayed", shkaf.Devices().isDevicesTabDisplayed());
            shkaf.Devices().tapSearchedDevice();
            shkaf.Devices().tapPrintDeviceQRBtnb();
            assertTrue("QR code is NOT displayed", shkaf.Devices().isQRPictureDisplayed());
            logger.log(Status.PASS, "Verify printQR btn generates and displays QR code");
        }

        @Test
        public void ResetButtonWorks() {
            logger = extent.createTest("T7: Reset button makes all switches to be ON");
            logger.assignCategory("Transactions Tab");
            logger.assignAuthor("Hanna Burianova");
            shkaf.Transactions().tapTransactionsTab();
            shkaf.Transactions().getBorrowSwitchValue();
            shkaf.Transactions().setOFFBorrowSwitch();
            assertTrue("Turn OFF borrow switch", shkaf.Transactions().isBorrowSwitchNOTSelected());
            shkaf.Transactions().setOFFtoStockSwitch();
            assertTrue("Turn OFF toStock switch", shkaf.Transactions().isToStockSwitchNOTSelected());
            shkaf.Transactions().tapResetButton();
            assertTrue("Switches are OFF", shkaf.Transactions().areAllSwitchesOn());
            logger.log(Status.PASS, "Reset button makes all switches to be ON");
        }
}
