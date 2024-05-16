import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class LoginPage extends BasePage{

    public void login() throws Exception {
        registrationProcess();
        enterValues();
        clickRegistrationSubmission();
    }

    // Open the registration pane & Choose registration way (out of list)
    private void registrationProcess() throws Exception {
        List<WebElement> regElementList = WebDriverSingleton.getDriverInstance().findElements(Constants.loginPageList);
        WebElement regLink = getWebElementFromList(regElementList, 1);
        clickElementFromList(regLink);

        // Login pane - Enter email
        sendKeysToElement(Constants.loginPageEnterEmailOnlyField, Constants.EMAIL);
        String findEmail = WebDriverSingleton.getDriverInstance().findElement(Constants.loginPageEnterEmailOnlyField).getAttribute("value");
        Assert.assertEquals(findEmail, Constants.EMAIL);
        clickElement(Constants.submitButton);

        // Choose option of - Login with password
        clickElement(Constants.loginPageLoginWithPasswordButton);
    }

    // Perform registration
    private void enterValues() throws Exception {
        // Enter email
        sendKeysToElement(Constants.loginPageEnterEmailField, Constants.EMAIL);
        String findEmail = WebDriverSingleton.getDriverInstance().findElement(Constants.loginPageEnterEmailField).getAttribute("value");
        Assert.assertEquals(findEmail, Constants.EMAIL);

        // Enter password
        sendKeysToElement(Constants.loginPageEnterPasswordField, Constants.PASSWORD);
        String findPassword = WebDriverSingleton.getDriverInstance().findElement(Constants.loginPageEnterPasswordField).getAttribute("value");
        Assert.assertEquals(findPassword, Constants.PASSWORD);
    }

    // Submit registration & login
    private void clickRegistrationSubmission() throws Exception {
        clickElement(Constants.submitButton);
    }

    // Captcha could be displayed
}