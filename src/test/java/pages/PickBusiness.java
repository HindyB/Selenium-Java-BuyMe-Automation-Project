package pages;

import core.BasePage;
import utils.Constants;

public class PickBusiness extends BasePage {
    public void pickBusiness() throws Exception {
        selectBusiness();
        enterChosenPrice();
        submitBusiness();
    }

    // Choose business - BUYME FASHION voucher
    private void selectBusiness() throws Exception {
        clickElement(Constants.pickBusinessBuyMeFashionVoucher);
    }

    // Enter chosen amount
    private void enterChosenPrice() throws Exception {
        sendKeysToElement(Constants.pickBusinessEnterChosenAmount, "200");
    }

    // Choose business
    private void submitBusiness() throws Exception {
        clickElement(Constants.submitButton);
    }
}