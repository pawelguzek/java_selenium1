package pl.guzek.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.guzek.appmanager.ApplicationManager;

/**
 * Created by Pawel on 30.04.2017.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
}

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
