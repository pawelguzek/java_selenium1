package pl.guzek.tests;

import org.testng.annotations.Test;
import pl.guzek.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Alfatest1321", "BetaTest", "YpsilonTest"));
        app.getGroupHelper().sumbitGroupCreation();
        app.getNavigationHelper().gotoGroupPage();
    }

}
