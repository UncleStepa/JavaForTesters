package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }


    public void fillContactGroup(ContractInfo personInfo, boolean creation) {
        type(By.name("firstname"), personInfo.getFirstname());
        type(By.name("middlename"), personInfo.getMiddlename());
        type(By.name("lastname"), personInfo.getLastname());
        type(By.name("nickname"), personInfo.getNickname());
        type(By.name("company"), personInfo.getCompanyWork());
        type(By.name("home"), personInfo.getCityName());
        type(By.name("address"), personInfo.getFullAddress());
        type(By.name("mobile"), personInfo.getFhoneNumber());
        type(By.name("email"), personInfo.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personInfo.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }
    }

    public void selectFirstContact() {
        click(By.name("selected[]"));
    }

    public void deleteOneContact() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void goToContactCreationPage() {
        click(By.linkText("add new"));
    }

    public void submitDeleteContact() {
        alert();
    }

    public void selectEditContract() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateModificationContract() {
        click(By.name("update"));
    }

    public void createContact(ContractInfo contractInfo, boolean creation) {
        goToContactCreationPage();
        fillContactGroup(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
                "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
                "stankevich@mail.ru", "test1"), true);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isTeareContact() {
        return isElementPresent(By.linkText("selected[]"));
    }
}
