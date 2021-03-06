package pl.guzek.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.guzek.mantis.appmanager.ApplicationManager;

/**
 * Created by Anna on 2016-12-10.
 */
public class TestBase {



    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun =  true)
    public void tearDown() {
        app.stop();
    }


}