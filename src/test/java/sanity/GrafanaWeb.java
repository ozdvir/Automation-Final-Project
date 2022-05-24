package sanity;


import extensions.UIActions;
import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {


    @Test(description = "Test01 Verify Header")
    @Description("This Test Verify Login and Main Header")
    public void test01_VerifyHeader()
    {
        WebFlows.login("admin","admin");
        Verification.verifyTextInElement(grafanaMain.head_Dashboard , "Home Dashboard");
    }


    @Test(description = "Test02 Verify Default users")
    @Description("This Test Verifies the default users")
    public void test02_VerifyDefaultUsers()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        Verification.numberOfElements(grafanaServerAdminMain.rows,1);
    }


    @Test(description = "Test03 Verify New User")
    @Description("This Test Verifies new user had been added")
    public void test03_VerifyNewUser()
    {

        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.createNewUser("oz","ozdvir@gmail.com","ozdvir","1234");
        Verification.numberOfElements(grafanaServerAdminMain.rows,2);
    }

    @Test(description = "Test04 Verify user Deletion")
    @Description("This Test Verifies the deletion of a user")
    public void test04_VerifyDeletionUser()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminMenu.link_users);
        WebFlows.deleteLastUser();
        Verification.numberOfElements(grafanaServerAdminMain.rows,1);
    }

    @Test(description = "Test05 Verify Progress Steps")
    @Description("This Test Verifies the default progress steps are displayed")
    public void test05_VerifyProgressSteps()
    {
        Verification.visibilityOfElements(grafanaMain.list_progressSteps);
    }


}
