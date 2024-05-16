import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {

    // Create click element
    public void clickElement(By locator) throws Exception {
        webDriverWait(locator);
        getWebElement(locator).click();
    }

    // Create click element from list
    public void clickElementFromList(WebElement locator) {
        locator.click();
    }

    // Create send keys element
    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    // Create clear element
    public void clearElement(By locator) throws Exception {
        getWebElement(locator).clear();
    }

    private WebElement getWebElement(By locator) throws Exception {
        return WebDriverSingleton.getDriverInstance().findElement(locator);
    }

    // Create function to send a value to an element that is part of a list
    public WebElement getWebElementFromList(List<WebElement> list, int index) {
        return list.get(index);
    }

    // Create an Explicit wait function - Element Clickable
    public void webDriverWait (By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getDriverInstance(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    // Read data from XML
    static String getData(String keyName) throws Exception{
        ClassLoader classLoader = SanityTestSpec.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}