package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupCountList();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupCountList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
    Comparator<? super GroupData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
}
}
