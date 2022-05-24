package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Verification extends CommonOps {
    @Step("Verify Text in Element")
    public static void verifyTextInElement(WebElement elem ,String expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected);
    }

    @Step("verify Number of Elements")
    public static void numberOfElements (List<WebElement> elems , int expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals( elems.size() , expected);
    }
    @Step("Verify Visibility of Elements(Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems)
    {
        for (WebElement elem : elems) {
            softassert.assertTrue(elem.isDisplayed(), "Sorry" + elem.getText() + " not displayed");
        }
        softassert.assertAll("Some elements ware not displayed");
    }


}