package workflows;
import extensions.UIActions;
import io.qameta.allure.Step;

import utilities.CommonOps;

public class WebFlows extends CommonOps {
    @Step("Business Flow: Login")
    public static void login (String user, String pass)
    {
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);

    }
    @Step("Business Flow: Create A new User")
    public static void createNewUser(String name , String email ,String userName ,String pass)
    {
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name,name);
        UIActions.updateText(grafanaAddNewUser.txt_email,email );
        UIActions.updateText(grafanaAddNewUser.txt_userName, userName);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.click(grafanaAddNewUser.btn_create);
    }
    @Step("Business Flow: Delete last User")
    public static void deleteLastUser()
    {
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1));
        UIActions.click(grafanaEditUser.btn_DeleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }
}
