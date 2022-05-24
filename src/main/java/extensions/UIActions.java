package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {


    @Step("Click on Element")
    public static void  click (WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step ("Update Text Element")
    public static void updateText(WebElement elem , String text)
    {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
    }
    @Step ("Update Dropdown element")
    public static void updateDropDown(WebElement elem ,String text)
    {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }
    @Step("MouseHover element")
    public static void mouseHover(WebElement elem1 ,WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
