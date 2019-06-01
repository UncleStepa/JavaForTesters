package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().fillContactGroup(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
            "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
            "stankevich@mail.ru", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
