package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDelete extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (! app.getContactHelper().isTeareContact()) {

      app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
              "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
              "stankevich@mail.ru", "test1"), true);
    }
  }

  @Test
  public void testDeleteOneContact() {
    List<ContractInfo> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().delete(index);
    List<ContractInfo> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
