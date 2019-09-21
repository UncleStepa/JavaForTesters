package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.List;

public class ContactDelete extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (! app.contact().isTeareContact()) {
      app.contact().createContact(new ContractInfo().
              whithFirstname("Vasya").whithMiddlename("Igorevich").whithLastname("Stankevich").whithNickname("UncleStepa").whithCompanyWork("Neoflex")
              .whithCityName("Saratov").whithFullAddress("City Saratov, House 3").whithFhoneNumber("+7923145444").whithEmail("stankevich@mail.ru")
              .whithGroup("test1"), true);
    }
  }

  @Test
  public void testDeleteOneContact() {
    List<ContractInfo> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContractInfo> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
