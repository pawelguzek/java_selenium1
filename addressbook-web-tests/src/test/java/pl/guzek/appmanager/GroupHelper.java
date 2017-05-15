package pl.guzek.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.guzek.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 30.04.2017.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

        public void sumbitGroupCreation() {
            click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupPage() {
        click(By.linkText("grupy"));
    }

    public void deleteSelectedGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));

    }

    public void createGroup(GroupData group) {

        initGroupCreation();
        fillGroupForm(group);
        sumbitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            GroupData group = new GroupData(id, name,null, null);
            groups.add(group);
        }
        return groups;
    }
}
