package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereaGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test1"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupCountList();
        app.getGroupHelper().selectgroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("res", "res1", "res2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupCountList();
        Assert.assertEquals(after.size(), before.size());
    }
}
