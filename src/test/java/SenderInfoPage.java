import org.testng.Assert;

public class SenderInfoPage extends BasePage {

    public void enterSenderInfo() throws Exception {
        chooseWayForSendingGift();
        enterSenderName();
        continueToPurchasePage();
    }

    private void chooseWayForSendingGift() throws Exception {
        // Choose way of sending gift - Email
        clickElement(Constants.senderPageChooseEmail);

        // Enter email of receiver
        sendKeysToElement(Constants.senderPageEnterEmailField, Constants.EMAIL);
    }

    // Enter sender name
    private void enterSenderName() throws Exception {
        clickElement(Constants.senderPageEnterSenderNameField);
        sendKeysToElement(Constants.senderPageEnterSenderNameField, Constants.SENDERNAME);

        String findSender = WebDriverSingleton.getDriverInstance().findElement(Constants.senderPageEnterSenderNameField).getAttribute("value");
        Assert.assertEquals(findSender, Constants.SENDERNAME);
    }

    private void continueToPurchasePage() throws Exception {
        clickElement(Constants.submitButton);
    }
}