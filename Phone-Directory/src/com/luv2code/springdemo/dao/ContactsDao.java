package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Contacts;

public interface ContactsDao {

	public List<Contacts> getContacts();

	public void saveContacts(Contacts theContacts);

	public Contacts getContacts(int theId);

	public void deleteContacts(int theId);

	public List<Contacts> searchContact(String theSearchName);

	public List<Contacts> searchNumber(String theNumber);

	
}
