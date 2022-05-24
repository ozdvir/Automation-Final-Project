package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;

    protected static SoftAssert softassert;

//Pages objects
    protected static pageObjects.grafana.LoginPage grafanaLogin ;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected static pageObjects.grafana.serverAdminMenuPage grafanaServerAdminMenu;
    protected static pageObjects.grafana.serverAdminMainPage grafanaServerAdminMain;
    protected static pageObjects.grafana.AddNewUserPage grafanaAddNewUser;

    protected static pageObjects.grafana.EditUserPage grafanaEditUser;


}
