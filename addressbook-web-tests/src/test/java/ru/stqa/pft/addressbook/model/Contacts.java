package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContractInfo> {

  private Set<ContractInfo> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContractInfo>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<>();
  }

  public Contacts(Collection<ContractInfo> contacts) { this.delegate = new HashSet<ContractInfo>(contacts); }

  @Override
  protected Set<ContractInfo> delegate() {
    return delegate;
  }

  public Contacts withAdded (ContractInfo contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts withOut(ContractInfo contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}