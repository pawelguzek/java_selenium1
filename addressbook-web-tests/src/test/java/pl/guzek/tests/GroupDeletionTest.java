package pl.guzek.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.guzek.model.GroupData;
import pl.guzek.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().goTo();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }

    }


    @Test
    public void testGroupDeletion() {

        Groups before = app.group().all();
        GroupData deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);
        assertThat(app.group().getGroupCount(),equalTo(before.size() -1));
        Groups after = app.group().all();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deleteGroup)));




    }




}
