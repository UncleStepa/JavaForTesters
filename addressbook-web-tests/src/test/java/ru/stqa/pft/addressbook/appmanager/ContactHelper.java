package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectFirstContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public void selectEditContract(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void updateModificationContract() {
        click(By.name("update"));
    }

    public void createContact(ContractInfo contractInfo, boolean creation) {
        goToContactCreationPage();
        fillContactGroup(contractInfo);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactGroup(ContractInfo contractInfo) {
        if(contractInfo.getFirstname() != null) {
            type(By.name("firstname"), contractInfo.getFirstname());
        }
        type(By.name("middlename"), contractInfo.getMiddlename());
        type(By.name("lastname"), contractInfo.getLastname());
        type(By.name("nickname"), contractInfo.getNickname());
        type(By.name("companyWork"), contractInfo.getCompanyWork());
        type(By.name("cityName"), contractInfo.getCityName());
        type(By.name("fullAddress"), contractInfo.getFullAddress());
        type(By.name("fhoneNumber"), contractInfo.getFhoneNumber());
        type(By.name("email"), contractInfo.getEmail());
        type(By.name("group"), contractInfo.getGroup());
    }


    public boolean isTeareContact() {
        return isElementPresent(By.name("selected[]"));
    }

  public List<ContractInfo> getContactList() {
      List<ContractInfo> contacts = new ArrayList<>();
      List<WebElement> elements = wd.findElements(By.name("entry"));
      for(WebElement element:elements){
          int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
          String lastname = element.findElement(By.xpath(".//td[2]")).getText();
          String firstname = element.findElement(By.xpath(".//td[3]")).getText();
          ContractInfo contact = new ContractInfo(firstname, null, lastname,null,null,null,null,null,null
          ,null, id);
          contacts.add(contact);
      }
      return contacts;
  }
}
