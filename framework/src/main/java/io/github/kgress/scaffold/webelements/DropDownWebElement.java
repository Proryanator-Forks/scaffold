package io.github.kgress.scaffold.webelements;

import io.github.kgress.scaffold.BaseWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Scaffold's strongly typed interpretation of a dropdown element.
 */
public class DropDownWebElement extends BaseClickableWebElement {

    /**
     * Creates a new {@link DropDownWebElement}. It is highly recommended using {@link By#cssSelector(String)} over
     * another method, such as {@link By#xpath(String)}, in almost all cases as it can be less flaky and less reliant
     * on DOM hierarchy.
     *
     * @see BaseWebElement#BaseWebElement(String)
     * @param cssSelector   the value of the {@link By#cssSelector(String)}
     */
    public DropDownWebElement(String cssSelector) {
        super(cssSelector);
    }

    /**
     * Use this constructor when you'd like to locate an element with a {@link By} method different from
     * {@link By#cssSelector(String)}. We strongly recommend using {@link #DropDownWebElement(String cssSelector)}
     * in almost all cases.
     *
     * @see BaseWebElement#BaseWebElement(By)
     * @param by    the {@link By} locator
     */
    public DropDownWebElement(By by) {
        super(by);
    }

    /**
     * Use this constructor when you'd like to locate an element with a child and parent {@link By} together. Useful
     * when you want a more verbose element definition in context of your websites' DOM.
     *
     * @see BaseWebElement#BaseWebElement(By, By)
     * @param by        the {@link By} locator for the child element
     * @param parentBy  the {@link By} locator for the parent element
     */
    public DropDownWebElement(By by, By parentBy) {
        super(by, parentBy);
    }

    /**
     * Returns a list of options in the DropDown
     *
     * @return the list of options.
     */
    public List<String> getOptionsText() {
        return getSelectElement().getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Selects an option in the dropdown based on the index provided.
     *
     * @see Select#selectByIndex(int)
     * @param index     the index to select
     */
    public void selectByIndex(int index) {
        getSelectElement().selectByIndex(index);
    }

    /**
     * Selects an option in the dropdown based on the value provided.
     *
     * @see Select#selectByValue(String) (int)
     * @param value     the value to select
     */
    public void selectByValue(String value) {
        getSelectElement().selectByValue(value);
    }

    /**
     * Sets the dropdown to the option contained in the visible to the option tag. If the value is blank, leave the
     * field alone. If someone is doing data-driven tests that contain many variables, we don't want to require
     * them to surround every instance of this method with the same if block.
     *
     * @param value     the value to select
     */
    public void selectByVisibleText(String value) {
        if (value.isBlank()) {
            getSelectElement().selectByVisibleText(value);
        }
    }

    /**
     * Return a Selenium {@link Select} object (a combo box) based on the underlying {@link WebElement}
     *
     * @return the {@link Select} object
     */
    protected Select getSelectElement() {
        return new Select(this.getRawWebElement());
    }
}
