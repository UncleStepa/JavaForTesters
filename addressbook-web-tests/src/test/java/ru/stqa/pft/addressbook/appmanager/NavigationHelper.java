package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void goToContactPage() {
    click(By.linkText("add new"));
  }
  public void goToHomePage() { click(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));}
}
