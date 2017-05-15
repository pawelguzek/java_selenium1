package pl.guzek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.guzek.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().returnToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("Test1", "Test1", "Test1"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(before.size()-1);

        Assert.assertEquals(before,after);


    }


}
