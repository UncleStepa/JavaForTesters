package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactModification extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isTeareContact()) {
            app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
                    "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
                    "stankevich@mail.ru", "test1"), true);
        }
        app.getContactHelper().selectEditContract();
        app.getContactHelper().fillContactGroup(new ContractInfo("Fedor", "Fedyav", "Restov", "Povelitel",
                "Neoflex", "Samara", "City Samara, House 3", "+79231451234",
                "Fedor@mail.ru", null), false);
        app.getContactHelper().updateModificationContract();
        app.getContactHelper().returnToHomePage();
    }
}
