package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteOneGroup extends TestBase {

  @Test
  public void testDeleteOneGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectgroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
