package io.github.kgress.scaffold;

import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static io.github.kgress.scaffold.SharedTestVariables.EXPECTED_COMBINED_SELECTOR;
import static org.mockito.Mockito.when;

/**
 * You might be wondering what this is and why this is here when {@link BaseUnitTest.TestBaseWebElement} already
 * exists. Well, that's a great question! {@link BaseWebElement#findElement(Class, By)} and
 * {@link BaseWebElement#findElements(Class, By)} uses reflection when creating a new instance of a Scaffold element.
 * Unfortunately, this means {@link BaseUnitTest.TestBaseWebElement} is built with the parent class and fails when
 * trying to find the constructor specified. The test code starts to get hideous when trying to work around it, so
 * it's just easier to copy the code over here as a parent class.
 */
public class MockBaseWebElement extends BaseWebElement {

    public WebDriverWrapper mockWebDriverWrapper = Mockito.mock(WebDriverWrapper.class);
    public WebElementWait mockWebElementWait = Mockito.mock(WebElementWait.class);
    public WebElement mockRawWebElement1 = Mockito.mock(WebElement.class);
    public WebElement mockRawWebElement2 = Mockito.mock(WebElement.class);

    public MockBaseWebElement(String cssSelector) {
        super(cssSelector);
    }

    public MockBaseWebElement(By by) {
        super(by);
    }

    public MockBaseWebElement(By by, By parentBy) {
        super(by, parentBy);
    }

    public MockBaseWebElement(WebElement webElement) {
        super(webElement);
    }

    public MockBaseWebElement(By by, WebElement webElement) {
        super(by, webElement);
    }

    public MockBaseWebElement(By by, By parentBy, WebElement webElement) {
        super(by, parentBy, webElement);
    }

    @Override
    public void setWebElementWait() {}

    @Override
    public WebDriverWrapper getWebDriverWrapper() {
        // This is the "best way" to set expectation for the find elements method
        List<WebElement> listOfRawWebElements = new ArrayList<>();;
        listOfRawWebElements.add(mockRawWebElement1);
        listOfRawWebElements.add(mockRawWebElement2);
        when(mockWebDriverWrapper.findElements(By.cssSelector(EXPECTED_COMBINED_SELECTOR)))
                .thenReturn(listOfRawWebElements);

        return mockWebDriverWrapper;
    }

    @Override
    public WebElementWait getWebElementWait() {
        return mockWebElementWait;
    }
}
