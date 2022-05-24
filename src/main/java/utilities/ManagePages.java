package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.serverAdminMenuPage;

public class ManagePages extends Base{

    public static void initGrafana ()
    {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver,pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, pageObjects.grafana.serverAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, pageObjects.grafana.serverAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, pageObjects.grafana.AddNewUserPage.class);
        grafanaEditUser = PageFactory.initElements(driver, pageObjects.grafana.EditUserPage.class);

    }
}
