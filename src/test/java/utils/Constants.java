package utils;

import org.openqa.selenium.By;

public class Constants {
    // Set up utils.Constants
    public static final String SENDERNAME = "Hindy";
    public static final String RECEIVERNAME = "Israel";
    public static final String EMAIL = "hindyqa@gmail.com";
    public static final String PASSWORD = "Pa$$w0rd";

    // Set up Driver
    public static final String CHROMEDRIVER_PATH = "C:\\Users\\User\\Downloads\\New_folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
    // Upgrade Chrome driver at: https://googlechromelabs.github.io/chrome-for-testing/

    public static final String EDGEDRIVER_PATH = "\"C:\\Users\\User\\Downloads\\New_folder\\edgedriver_win64\\msedgedriver.exe";
    // Upgrade Edge driver at: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/

    public static final String businessPageURLAssertion = "https://buyme.co.il/search?budget=3&category=22&region=14";


    // Set up general elements for few pages
    public static final By openDropdown = By.className("selected-name");
    public static final By submitButton = By.cssSelector("button[type=submit]"); // clickElement(utils.Constants.submitButton);


    // pages.HomeScreen
    public static final By homeScreenPriceRange200_299 = By.id("ember1128");
    public static final By homeScreenRegionJerusalem = By.id("ember1167");
    public static final By homeScreenCategoryFashionBrands = By.id("ember1229");
    public static final By homeScreenSubmitGiftButton = By.id("ember1253");


    // pages.PickBusiness
    public static final By pickBusinessBuyMeFashionVoucher = By.id("ember2057");
    public static final By pickBusinessEnterChosenAmount = By.cssSelector("input[type=tel]");


    // pages.ReceiverInfoPage
    public static final By receiverPageReceiverNameField = By.id("ember2426");
    public static final By receiverPageEventDropdownBirthday = By.cssSelector("li[value='10']");
    public static final By receiverPageTextarea = By.xpath("//*[@id=\"ember2437\"]/textarea");
    public static final By receiverPageVideoButtonOpenPane = By.id("ember1932");
    public static final By receiverPageChooseVideo = By.id("ember2597");


    // pages.SenderInfoPage
    public static final By senderPageChooseEmail = By.cssSelector("svg[gtm=method-email]");
    public static final By senderPageEnterEmailField = By.id("email");
    public static final By senderPageEnterSenderNameField = By.id("ember2657");


    // pages.LoginPage
    public static final By loginPageList = By.className("social-btn");
    public static final By loginPageEnterEmailOnlyField = By.id("ember2116");
    public static final By loginPageLoginWithPasswordButton = By.xpath("//*[@id=\"ember1016\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[4]/span");
    public static final By loginPageEnterEmailField = By.id("ember2148");
    public static final By loginPageEnterPasswordField = By.id("ember2155");
}