import org.testng.Assert;

public class ReceiverInfoPage extends BasePage {

    public void enterReceiverInfo() throws Exception {
        enterReceiverName();
        chooseEvent();
        enterBlessing();
        uploadVideo();
        continueToReceiverPage();
    }

    private void enterReceiverName() throws Exception {
        // Enter receiver name
        sendKeysToElement(Constants.receiverPageReceiverNameField, Constants.RECEIVERNAME);
        String findReceiver = WebDriverSingleton.getDriverInstance().findElement(Constants.receiverPageReceiverNameField).getAttribute("value");
        Assert.assertEquals(findReceiver, Constants.RECEIVERNAME);
    }

    private void chooseEvent() throws Exception {
        // Open dropdown
        clickElement(Constants.openDropdown);

        // Choose event out of dropdown - birthday
        clickElement(Constants.receiverPageEventDropdownBirthday);
    }

    private void enterBlessing() throws Exception {
        // Clear text
        clearElement(Constants.receiverPageTextarea);

        // Enter new blessing
        sendKeysToElement(Constants.receiverPageTextarea, "Mazal tov!!\nMay you live till 120\nIn happiness and joy!");
    }

    // Add video
    private void uploadVideo() throws Exception {
        // Open video pane window
        clickElement(Constants.receiverPageVideoButtonOpenPane);

        // Choose video
        clickElement(Constants.receiverPageChooseVideo);
    }

    private void continueToReceiverPage() throws Exception {
        clickElement(Constants.submitButton);
    }
}