package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContractInfo;

public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }


  public void fillContactGroup(ContractInfo personInfo) {
    type(By.name("firstname"), personInfo.getFirstname());
    type(By.name("middlename"), personInfo.getMiddlename());
    type(By.name("lastname"), personInfo.getLastname());
    type(By.name("nickname"), personInfo.getNickname());
    type(By.name("company"), personInfo.getCompanyWork());
    type(By.name("home"), personInfo.getCityName());
    type(By.name("address"), personInfo.getFullAddress());
    type(By.name("mobile"), personInfo.getFhoneNumber());
    type(By.name("email"), personInfo.getEmail());
  }



}
