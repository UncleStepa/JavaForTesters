package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContractInfo().
              withFirstname("Vasya").withMiddlename("Igorevich").withLastname("Stankevich").withNickname("UncleStepa").withCompanyWork("Neoflex")
              .withCityName("Saratov").withFullAddress("City Saratov, House 3").withFhoneNumber("+7923145444").withEmail("stankevich@mail.ru")
              .withGroup("test1"), true);
    }
  }


  @Test
  public void testContactPhones() {
    ContractInfo contact = app.contact().all().iterator().next();
    ContractInfo contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHome_phone(), equalTo(contactInfoFromEditForm.getHome_phone()));
    assertThat(contact.getMobile_phone(), equalTo(contactInfoFromEditForm.getMobile_phone()));
    assertThat(contact.getWork_phone(), equalTo(contactInfoFromEditForm.getWork_phone()));
  }
}
