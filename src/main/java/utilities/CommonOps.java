package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;


public class CommonOps extends Base{


    public static String getData (String nodeName)
    {
        File fxmlFile ;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc= dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase(getData("BrowserName")))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser type");

        driver.manage().window().setPosition(new Point(0,0));
       // driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getData("Timeout"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getData("Timeout"))));
        driver.get(getData("Url"));
        ManagePages.initGrafana();
        action = new Actions(driver);

    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    @BeforeClass

    public void startSession ()
    {
        String platform  = "web";
        if (platform.equalsIgnoreCase("web"))
            initBrowser("chrome");
//        else if (platform.equalsIgnoreCase("mobile"))
//            initiMobie();
        else
            throw new RuntimeException("Invalid platform name");
        softassert = new SoftAssert();

    }



    @AfterClass
    public void closeSession(){
        driver.quit();
    }

    @AfterMethod
    public void afterMethod()
    {
        //After every test , Return to the Grafana main page
        driver.get(getData("Url"));
    }

}
