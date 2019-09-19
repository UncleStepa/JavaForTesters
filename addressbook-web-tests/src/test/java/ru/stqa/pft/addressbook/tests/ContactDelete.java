package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDelete extends TestBase {

  @Test
  public void testDeleteOneContact() {
    if (!app.getContactHelper().isTeareContact()) {
      app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
              "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
              "stankevich@mail.ru", "test1"), true);
    }
    List<ContractInfo> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectFirstContact(before.size() - 1);
    app.getContactHelper().deleteOneContact();
    app.getContactHelper().submitDeleteContact();
    app.getNavigationHelper().goToHomePage();
    List<ContractInfo> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }
}
