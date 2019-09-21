package ru.stqa.pft.addressbook.model;

public class ContractInfo {
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String companyWork;
  private  String cityName;
  private  String fullAddress;
  private  String fhoneNumber;
  private  String email;
  private String group;
  private int id = Integer.MAX_VALUE;

  public ContractInfo whithFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContractInfo whithMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContractInfo whithLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContractInfo whithNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContractInfo whithCompanyWork(String companyWork) {
    this.companyWork = companyWork;
    return this;
  }

  public ContractInfo whithCityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

  public ContractInfo whithFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return this;
  }

  public ContractInfo whithFhoneNumber(String fhoneNumber) {
    this.fhoneNumber = fhoneNumber;
    return this;
  }

  public ContractInfo whithEmail(String email) {
    this.email = email;
    return this;
  }

  public ContractInfo whithGroup(String group) {
    this.group = group;
    return this;
  }

  public ContractInfo whithId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompanyWork() {
    return companyWork;
  }

  public String getCityName() {
    return cityName;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public String getFhoneNumber() {
    return fhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public  String getGroup() { return  group;}

  @Override
  public String toString() {
    return "ContractInfo{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContractInfo that = (ContractInfo) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }
}
