package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DeleteOneGroup extends TestBase {

  @Test
  public void testDeleteOneGroup() throws Exception {
    app.gotoGroupPage();
    app.selectgroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }

}
