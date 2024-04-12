import org.openqa.selenium.WebElement;
import java.util.List;

public class HomeScreen extends BasePage{
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
        webDriverWait(Constants.openDropdown);
        WebElement chooseGiftLists = getWebElementFromList(elementList, 0);
        clickElementFromList(chooseGiftLists);

        // Choose price range - 200-299
        webDriverWait(Constants.homeScreenPriceRange200_299);
        clickElement(Constants.homeScreenPriceRange200_299);
    }

    // Choose location region
    private void pickRegion() throws Exception {
        // Open region dropdown list
        webDriverWait(Constants.openDropdown);
        WebElement chooseGiftLists = getWebElementFromList(elementList, 1);
        clickElementFromList(chooseGiftLists);

        // Choose Jerusalem
        webDriverWait(Constants.homeScreenRegionJerusalem);
        clickElement(Constants.homeScreenRegionJerusalem);
    }

    // Choose category - Brandes makes Gift card
    private void pickCategory() throws Exception {
        // Open category dropdown list
        webDriverWait(Constants.openDropdown);
        WebElement chooseGiftLists = getWebElementFromList(elementList, 2);
        clickElementFromList(chooseGiftLists);

        // Choose gift category - Gift card for fashion brands
        webDriverWait(Constants.homeScreenCategoryFashionBrands);
        clickElement(Constants.homeScreenCategoryFashionBrands);
    }

    // Submit gift
    private void clickChooseMyGift() throws Exception {
        clickElement(Constants.homeScreenSubmitGiftButton);
    }
}