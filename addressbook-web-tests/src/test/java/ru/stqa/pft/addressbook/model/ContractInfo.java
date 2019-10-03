package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContractInfo {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private  String firstname;

  @Column(name = "lastname")
  private  String lastname;

  @Column(name = "address")
  @Type(type = "text")
  private  String fullAddress;

  @Column(name = "email")
  @Type(type = "text")
  private  String email;

  @Column(name = "email2")
  @Type(type = "text")
  private  String email1;

  @Column(name = "email3")
  @Type(type = "text")
  private  String email2;

  @Transient
  private String group;

  @Transient
  private String allFhones;

  @Column(name = "home")
  @Type(type = "text")
  private String home_phone;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile_phone;

  @Column(name = "work")
  @Type(type = "text")
  private String work_phone;

  @Transient
  private String allEmails;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContractInfo withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContractInfo withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContractInfo withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContractInfo withFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return this;
  }

  public ContractInfo withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public ContractInfo withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContractInfo withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContractInfo withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContractInfo withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContractInfo setAllFhones(String allFhones) {
    this.allFhones = allFhones;
    return this;
  }

  public ContractInfo withId(int id) {
    this.id = id;
    return this;
  }

  public ContractInfo withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContractInfo withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContractInfo withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public  String getGroup() { return  group;}

  public String getAllFhones() {
    return allFhones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContractInfo that = (ContractInfo) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }


  @Override
  public String toString() {
    return "ContractInfo{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}
