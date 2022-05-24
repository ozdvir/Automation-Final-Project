package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_server;

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][5]")
    public WebElement btn_configuration;

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][4]")
    public WebElement btn_alerting;

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][3]")
    public WebElement btn_explore;

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][2]")
    public WebElement btn_dashboards;

    @FindBy (how = How.XPATH , using = "//div[@class='sidemenu-item dropdown'][1]")
    public WebElement btn_create;


}
