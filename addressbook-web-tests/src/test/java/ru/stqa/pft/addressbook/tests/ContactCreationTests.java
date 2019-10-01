package ru.stqa.pft.addressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";;
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContractInfo.class);
    List<ContractInfo> groups = (List<ContractInfo>)xstream.fromXML(xml);
    return groups.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContractInfo contact) throws Exception {
    Contacts before = app.contact().all();
    app.contact().createContact(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
