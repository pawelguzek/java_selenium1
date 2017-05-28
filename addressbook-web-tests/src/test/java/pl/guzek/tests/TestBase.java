package pl.guzek.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.guzek.appmanager.ApplicationManager;

/**
 * Created by Pawel on 30.04.2017.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
}

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
