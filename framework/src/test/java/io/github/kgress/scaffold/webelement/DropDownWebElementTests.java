package io.github.kgress.scaffold.webelement;

import io.github.kgress.scaffold.BaseUnitTest;
import io.github.kgress.scaffold.SharedTestVariables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DropDownWebElementTests extends BaseUnitTest {

    private final TestDropDownWebElement elementByCssSelector
            = new TestDropDownWebElement(SharedTestVariables.CSS_SELECTOR1);
    private final TestDropDownWebElement elementByClass =
            new TestDropDownWebElement(By.className(SharedTestVariables.CLASS_NAME));
    private final List<WebElement> getOptions = new ArrayList<>();

    @BeforeEach
    public void setup() {
        getOptions.add(mockRawWebElement);
    }

    @Test
    public void testDropDownWebElement_byCss_getOptionsText() {
        when(mockSelect.getOptions()).thenReturn(getOptions);
        var elementOptions = elementByCssSelector.getOptionsText();
        assertEquals(1, elementOptions.size());
    }

    @Test
    public void testDropDownWebElement_byCss_selectByIndex() {
        elementByCssSelector.selectByIndex(0);
        verify(mockSelect, times(1)).selectByIndex(0);
    }

    @Test
    public void testDropDownWebElement_byCss_selectByValue() {
        elementByCssSelector.selectByValue(SharedTestVariables.DROPDOWN_VALUE);
        verify(mockSelect, times(1)).selectByValue(SharedTestVariables.DROPDOWN_VALUE);
    }

    @Test
    public void testDropDownWebElement_byCss_selectByVisibleTest() {
        elementByCssSelector.selectByVisibleText("");
        verify(mockSelect, times(1)).selectByVisibleText("");
    }

    @Test
    public void testDropDownWebElement_byCss_click() {
        setBaseWhen(elementByCssSelector);
        setWhenScrollIntoViewSucceed();
        elementByCssSelector.click();
        verify(mockRawWebElement, times(1)).click();
    }

    @Test
    public void testDropDownWebElement_byCss_isEnabled() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.isEnabled()).thenReturn(true);
        assertTrue(elementByCssSelector.isEnabled());
    }

    @Test
    public void testDropDownWebElement_byCss_isDisabled() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.isEnabled()).thenReturn(false);
        assertFalse(elementByCssSelector.isEnabled());
    }

    @Test
    public void testDropDownWebElement_byCss_isDisplayed() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.isDisplayed()).thenReturn(true);
        assertTrue(elementByCssSelector.isDisplayed());
    }

    @Test
    public void testDropDownWebElement_byCss_isNotDisplayed() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.isDisplayed()).thenReturn(false);
        assertFalse(elementByCssSelector.isDisplayed());
    }

    @Test
    public void testDropDownWebElement_byCss_isActive() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.ACTIVE_CLASS_NAME);
        assertTrue(elementByCssSelector.isActive());
    }

    @Test
    public void testDropDownWebElement_byCss_isNotActive() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertFalse(elementByCssSelector.isActive());
    }

    @Test
    public void testDropDownWebElement_byCss_hasClass() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertTrue(elementByCssSelector.hasClass(SharedTestVariables.CLASS_NAME));
    }

    @Test
    public void testDropDownWebElement_byCss_doesNotHaveClass() {
        setBaseWhen(elementByCssSelector);
        var notExpectingText = "NOT HERE <.< >.>";
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertFalse(elementByCssSelector.hasClass(notExpectingText));
    }

    @Test
    public void testDropDownWebElement_byCss_getAttribute() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertEquals(SharedTestVariables.CLASS_NAME,
                elementByCssSelector.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE));
    }

    @Test
    public void testDropDownWebElement_byCss_getText() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getText()).thenReturn(SharedTestVariables.TEXT_1);
        assertEquals(SharedTestVariables.TEXT_1, elementByCssSelector.getText());
    }

    @Test
    public void testDropDownWebElement_byCss_getTagName() {
        setBaseWhen(elementByCssSelector);
        when(mockRawWebElement.getTagName()).thenReturn(SharedTestVariables.TAG_NAME_1);
        assertEquals(SharedTestVariables.TAG_NAME_1, elementByCssSelector.getTagName());
    }

    @Test
    public void testDropDownWebElement_byCss_getLocation() {
        setBaseWhen(elementByCssSelector);
        var testPoint = new Point(1, 1);
        when(mockRawWebElement.getLocation()).thenReturn(testPoint);
        assertEquals(testPoint, elementByCssSelector.getLocation());
    }

    @Test
    public void testDropDownWebElement_byCss_getSize() {
        setBaseWhen(elementByCssSelector);
        var testDimension = new Dimension(1,1);
        when(mockRawWebElement.getSize()).thenReturn(testDimension);
        assertEquals(testDimension, elementByCssSelector.getSize());
    }

    @Test
    public void testDropDownWebElement_byCss_getRect() {
        setBaseWhen(elementByCssSelector);
        var testRectangle = new Rectangle(1, 1, 1, 1);
        when(mockRawWebElement.getRect()).thenReturn(testRectangle);
        assertEquals(testRectangle, elementByCssSelector.getRect());
    }

    @Test
    public void testDropDownWebElement_byCss_getCssValue() {
        setBaseWhen(elementByCssSelector);
        var testCssProperty = "testProperty";
        var expectedTestCssValue = "Dagobah";
        when(mockRawWebElement.getCssValue(testCssProperty)).thenReturn(expectedTestCssValue);
        assertEquals(expectedTestCssValue, elementByCssSelector.getCssValue(testCssProperty));
    }

    @Test
    public void testDropDownWebElement_byCss_getRawWebElement_success() {
        setBaseWhen(elementByCssSelector);
        assertEquals(mockRawWebElement, elementByCssSelector.getRawWebElement());
    }

    @Test
    public void testDropDownWebElement_byCss_getRawWebElement_fail() {
        setBaseWhen(elementByCssSelector);
        when(elementByCssSelector.getRawWebElement()).thenThrow(TimeoutException.class);
        assertThrows(TimeoutException.class, elementByCssSelector::getRawWebElement);
    }

    @Test
    public void testDropDownWebElement_byCss_getRawParentWebElement_success() {
        setBaseWhen(elementByCssSelector);
        setWhenGetRawParentElementSucceed();
        assertEquals(mockParentRawWebElement, elementByCssSelector.getRawParentWebElement());
    }

    @Test
    public void testDropDownWebElement_byCss_getRawParentWebElement_fail() {
        setBaseWhen(elementByCssSelector);
        setWhenGetRawParentElementFail();
        assertThrows(TimeoutException.class, elementByCssSelector::getRawParentWebElement);
    }

    @Test
    public void testDropDownWebElement_byCss_scrollIntoView_success() {
        setBaseWhen(elementByCssSelector);
        setWhenScrollIntoViewSucceed();
        assertEquals(mockRawWebElement, elementByCssSelector.scrollIntoView());
    }

    @Test
    public void testDropDownWebElement_byCss_scrollIntoView_fail() {
        setBaseWhen(elementByCssSelector);
        setWhenScrollIntoViewFail();
        assertThrows(TimeoutException.class, elementByCssSelector::scrollIntoView);
    }

    @Test
    public void testDropDownWebElement_byClass_getOptionsText() {
        when(mockSelect.getOptions()).thenReturn(getOptions);
        var elementOptions = elementByClass.getOptionsText();
        assertEquals(1, elementOptions.size());
    }

    @Test
    public void testDropDownWebElement_byClass_selectByIndex() {
        elementByClass.selectByIndex(0);
        verify(mockSelect, times(1)).selectByIndex(0);
    }

    @Test
    public void testDropDownWebElement_byClass_selectByValue() {
        elementByClass.selectByValue(SharedTestVariables.DROPDOWN_VALUE);
        verify(mockSelect, times(1)).selectByValue(SharedTestVariables.DROPDOWN_VALUE);
    }

    @Test
    public void testDropDownWebElement_byClass_selectByVisibleTest() {
        elementByClass.selectByVisibleText("");
        verify(mockSelect, times(1)).selectByVisibleText("");
    }

    @Test
    public void testDropDownWebElement_byClass_click() {
        setBaseWhen(elementByClass);
        setWhenScrollIntoViewSucceed();
        elementByClass.click();
        verify(mockRawWebElement, times(1)).click();
    }

    @Test
    public void testDropDownWebElement_byClass_isEnabled() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.isEnabled()).thenReturn(true);
        assertTrue(elementByClass.isEnabled());
    }

    @Test
    public void testDropDownWebElement_byClass_isDisabled() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.isEnabled()).thenReturn(false);
        assertFalse(elementByClass.isEnabled());
    }

    @Test
    public void testDropDownWebElement_byClass_isDisplayed() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.isDisplayed()).thenReturn(true);
        assertTrue(elementByClass.isDisplayed());
    }

    @Test
    public void testDropDownWebElement_byClass_isNotDisplayed() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.isDisplayed()).thenReturn(false);
        assertFalse(elementByClass.isDisplayed());
    }

    @Test
    public void testDropDownWebElement_byClass_isActive() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.ACTIVE_CLASS_NAME);
        assertTrue(elementByClass.isActive());
    }

    @Test
    public void testDropDownWebElement_byClass_isNotActive() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertFalse(elementByClass.isActive());
    }

    @Test
    public void testDropDownWebElement_byClass_hasClass() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertTrue(elementByClass.hasClass(SharedTestVariables.CLASS_NAME));
    }

    @Test
    public void testDropDownWebElement_byClass_doesNotHaveClass() {
        setBaseWhen(elementByClass);
        var notExpectingText = "NOT HERE <.< >.>";
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertFalse(elementByClass.hasClass(notExpectingText));
    }

    @Test
    public void testDropDownWebElement_byClass_getAttribute() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE))
                .thenReturn(SharedTestVariables.CLASS_NAME);
        assertEquals(SharedTestVariables.CLASS_NAME,
                elementByClass.getAttribute(SharedTestVariables.CLASS_ATTRIBUTE));
    }

    @Test
    public void testDropDownWebElement_byClass_getText() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getText()).thenReturn(SharedTestVariables.TEXT_1);
        assertEquals(SharedTestVariables.TEXT_1, elementByClass.getText());
    }

    @Test
    public void testDropDownWebElement_byClass_getTagName() {
        setBaseWhen(elementByClass);
        when(mockRawWebElement.getTagName()).thenReturn(SharedTestVariables.TAG_NAME_1);
        assertEquals(SharedTestVariables.TAG_NAME_1, elementByClass.getTagName());
    }

    @Test
    public void testDropDownWebElement_byClass_getLocation() {
        setBaseWhen(elementByClass);
        var testPoint = new Point(1, 1);
        when(mockRawWebElement.getLocation()).thenReturn(testPoint);
        assertEquals(testPoint, elementByClass.getLocation());
    }

    @Test
    public void testDropDownWebElement_byClass_getSize() {
        setBaseWhen(elementByClass);
        var testDimension = new Dimension(1,1);
        when(mockRawWebElement.getSize()).thenReturn(testDimension);
        assertEquals(testDimension, elementByClass.getSize());
    }

    @Test
    public void testDropDownWebElement_byClass_getRect() {
        setBaseWhen(elementByClass);
        var testRectangle = new Rectangle(1, 1, 1, 1);
        when(mockRawWebElement.getRect()).thenReturn(testRectangle);
        assertEquals(testRectangle, elementByClass.getRect());
    }

    @Test
    public void testDropDownWebElement_byClass_getCssValue() {
        setBaseWhen(elementByClass);
        var testCssProperty = "testProperty";
        var expectedTestCssValue = "Dagobah";
        when(mockRawWebElement.getCssValue(testCssProperty)).thenReturn(expectedTestCssValue);
        assertEquals(expectedTestCssValue, elementByClass.getCssValue(testCssProperty));
    }

    @Test
    public void testDropDownWebElement_byClass_getRawWebElement_success() {
        setBaseWhen(elementByClass);
        assertEquals(mockRawWebElement, elementByClass.getRawWebElement());
    }

    @Test
    public void testDropDownWebElement_byClass_getRawWebElement_fail() {
        setBaseWhen(elementByClass);
        when(elementByClass.getRawWebElement()).thenThrow(TimeoutException.class);
        assertThrows(TimeoutException.class, elementByClass::getRawWebElement);
    }

    @Test
    public void testDropDownWebElement_byClass_getRawParentWebElement_success() {
        setBaseWhen(elementByClass);
        setWhenGetRawParentElementSucceed();
        assertEquals(mockParentRawWebElement, elementByClass.getRawParentWebElement());
    }

    @Test
    public void testDropDownWebElement_byClass_getRawParentWebElement_fail() {
        setBaseWhen(elementByClass);
        setWhenGetRawParentElementFail();
        assertThrows(TimeoutException.class, elementByClass::getRawParentWebElement);
    }

    @Test
    public void testDropDownWebElement_byClass_scrollIntoView_success() {
        setBaseWhen(elementByClass);
        setWhenScrollIntoViewSucceed();
        assertEquals(mockRawWebElement, elementByClass.scrollIntoView());
    }

    @Test
    public void testDropDownWebElement_byClass_scrollIntoView_fail() {
        setBaseWhen(elementByClass);
        setWhenScrollIntoViewFail();
        assertThrows(TimeoutException.class, elementByClass::scrollIntoView);
    }
}
