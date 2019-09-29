package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;
import java.util.Iterator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    List<File> photo = new ArrayList<File>();
    list.add(new Object[] {new ContractInfo().withFirstname("Igor").withLastname("Stankevich").withFullAddress("Saratov, greb").withHome_phone("+7 111111")
            .withEmail("124214@gmail.com").withGroup("TestGroup").withPhoto(new File("src/test/resources/stru.png"))});
    list.add(new Object[] {new ContractInfo().withFirstname("Vasya").withLastname("Stankevich").withFullAddress("Saratov, gre").withHome_phone("+7 222331333")
            .withEmail("124214@gmail.com").withGroup("TestGroup1").withPhoto(new File("src/test/resources/stru.png"))});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContractInfo contact) throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    app.contact().createContact(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
