package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactModification extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().selectEditContract();
        app.getContactHelper().fillContactGroup(new ContractInfo("Fedor", "Fedyav", "Restov", "Povelitel",
                "Neoflex", "Samara", "City Samara, House 3", "+79231451234",
                "Fedor@mail.ru"));
        app.getContactHelper().updateModificationContract();
        app.getContactHelper().returnToHomePage();
    }
}
