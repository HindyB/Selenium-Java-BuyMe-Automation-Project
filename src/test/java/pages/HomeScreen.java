package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import core.BasePage;
import utils.Constants;

import java.util.List;

public class HomeScreen extends BasePage {
    List<WebElement> elementList = WebDriverSingleton.getDriverInstance().findElements(Constants.openDropdown);

    public HomeScreen() throws Exception {
    }

    public void chooseGift() throws Exception {
        pickPricePoint();
        pickRegion();
        pickCategory();
        clickChooseMyGift();
    }

    // Choose price region
    private void pickPricePoint() throws Exception {
        // Open price dropdown list
        WebElement chooseGiftLists = getWebElementFromList(elementList, 0);
        clickElementFromList(chooseGiftLists);

        // Choose price range - 200-299
        clickElement(Constants.homeScreenPriceRange200_299);
    }

    // Choose location region
    private void pickRegion() throws Exception {
        // Open region dropdown list
        WebElement chooseGiftLists = getWebElementFromList(elementList, 1);
        clickElementFromList(chooseGiftLists);

        // Choose Jerusalem
        clickElement(Constants.homeScreenRegionJerusalem);
    }

    // Choose category - Brandes makes Gift card
    private void pickCategory() throws Exception {
        // Open category dropdown list
        WebElement chooseGiftLists = getWebElementFromList(elementList, 2);
        clickElementFromList(chooseGiftLists);

        // Choose gift category - Gift card for fashion brands
        clickElement(Constants.homeScreenCategoryFashionBrands);
    }

    // Submit gift
    private void clickChooseMyGift() throws Exception {
        clickElement(Constants.homeScreenSubmitGiftButton);
    }
}