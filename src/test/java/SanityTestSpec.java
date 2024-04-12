import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SanityTestSpec {

    // Create report variables, path & name
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test = extent.createTest("Buy Me Sanity Test", "(Some description...)");
    String timeNow = String.valueOf(System.currentTimeMillis());

    @BeforeTest
    public void beforeAll() throws Exception {

        // Create report objects
        String url = BasePage.getData("URL");
        String cwd = System.getProperty("user.dir");

        // Add date & time to report
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html" + (dateFormat.format(date)));

        // Attach reporter
        extent.attachReporter(htmlReporter);

        // log results
        test.log(Status.INFO, "@Before class");

        try {
            WebDriverSingleton.getDriverInstance().get(url);
            WebDriverSingleton.getDriverInstance().manage().window().maximize();
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }
    }

    // Choose gift on home screen
    @Test
    public void test01_chooseGift() throws Exception {
        try {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.chooseGift();
            test.pass("Choose gift - 1# Test Pass");
        } catch (Exception e) {
            e.printStackTrace(); // to be looked up
            test.log(Status.FAIL, "Choose gift - 1# Test Fail" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    // Enter gift page & Enter price amount
    @Test
    public void test02_pickBusiness() throws Exception {
        try {
            Assert.assertEquals(Constants.businessPageURLAssertion, WebDriverSingleton.getDriverInstance().getCurrentUrl());
            PickBusiness pickBusiness = new PickBusiness();
            pickBusiness.pickBusiness();
            test.pass("Pick business - 2# Test Fail Pass");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Pick business - 2# Test Fail" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    // Enter Receiver Info
    @Test
    public void test03_enterReceiverInfo() throws Exception {
        try {
            ReceiverInfoPage enterReceiverInfo = new ReceiverInfoPage();
            enterReceiverInfo.enterReceiverInfo();
            test.pass("Enter Receiver Info  - 3# Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Enter receiver info  - 3# Test Fail" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    // Enter Sender Info
    @Test
    public void test04_enterSenderInfo() throws Exception {
        try {
            SenderInfoPage enterSenderInfo = new SenderInfoPage();
            enterSenderInfo.enterSenderInfo();
            test.pass("Enter Sender Info  - 4# Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Enter sender info  - 4# Test Fail" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    // Create login
    @Test
    public void test05_login() throws Exception {
        try {
            LoginPage loginPage = new LoginPage();
            loginPage.login();
            test.log(Status.PASS, "Login - 5# Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Login - 5# Test Fail" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    // Build and flush report
    @AfterClass
    public static void afterClass() throws Exception {
        test.log(Status.INFO, "@After test");
        WebDriverSingleton.getDriverInstance().quit();
        extent.flush();
    }

    // Create screenshot method
    public static String takeScreenShot(String ImagesPath) throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");

        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
            System.out.println("Screenshot saved: " + ImagesPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        return ImagesPath + ".png";
    }
}