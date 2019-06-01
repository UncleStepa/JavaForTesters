package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactFirstDelete extends TestBase {

  @Test
  public void testDeleteOneContact() {
    if (!app.getContactHelper().isTeareContact()) {
      app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
              "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
              "stankevich@mail.ru", "test1"), true);
    }
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteOneContact();
    app.getContactHelper().submitDeleteContact();
    app.getNavigationHelper().goToHomePage();
  }
}
