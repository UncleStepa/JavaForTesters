package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModification extends TestBase {



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
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContractInfo modifyContact = before.iterator().next();
        ContractInfo contact = new ContractInfo().
                withFirstname("Fedor").withMiddlename("Revov").withLastname("Perfecto").withNickname("Netu").withCompanyWork("Neoflex")
                .withCityName("Saratov").withFullAddress("City Saratov, House 3").withFhoneNumber("+7923145444").withEmail("stankevich@mail.ru")
                .withGroup("test1").withId(modifyContact.getId());
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));
    }
}
