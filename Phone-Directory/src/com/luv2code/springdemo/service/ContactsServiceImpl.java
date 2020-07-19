package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.ContactsDao;
import com.luv2code.springdemo.entity.Contacts;

@Service
public class ContactsServiceImpl implements ContactsService{

	@Autowired
	private ContactsDao contactsDao;
	
	@Override
	@Transactional
	public List<Contacts> getContacts() {
		
		return contactsDao.getContacts();
	}

	@Override
	@Transactional
	public void saveContacts(Contacts theContacts) {
		
		contactsDao.saveContacts(theContacts);
		
	}

	@Override
	@Transactional
	public Contacts getContacts(int theId) {
		
		return contactsDao.getContacts(theId);
	}

	@Override
	@Transactional
	public void deleteContacts(int theId) {
		// TODO Auto-generated method stub
		contactsDao.deleteContacts(theId);
	}

	@Override
	@Transactional
	public List<Contacts> searchContact(String theSearchName) {
		
		return contactsDao.searchContact(theSearchName);
	}

	@Override
	@Transactional 
	public List<Contacts> searchNumber(String theNumber) {
		
		return contactsDao.searchNumber(theNumber);
	}

	
	

}
