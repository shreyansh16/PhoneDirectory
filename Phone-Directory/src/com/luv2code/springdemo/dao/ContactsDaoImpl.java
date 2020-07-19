package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Contacts;

@Repository
public class ContactsDaoImpl implements ContactsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Contacts> getContacts() {
		
		Session session= sessionFactory.getCurrentSession();
		
		Query<Contacts> query= session.createQuery("from Contacts", Contacts.class);
		
		List<Contacts> theContacts= query.getResultList();
		
		return theContacts;
		
	}

	@Override
	public void saveContacts(Contacts theContacts) {
		
		Session session= sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theContacts);
		
	}

	@Override
	public Contacts getContacts(int theId) {
		
		Session session= sessionFactory.getCurrentSession();
		
		Contacts theContacts = session.get(Contacts.class, theId);
		
		return theContacts;
	}

	@Override
	public void deleteContacts(int theId) {
		
      Session session= sessionFactory.getCurrentSession();
		
		Contacts theContacts = session.get(Contacts.class, theId);
		
		session.delete(theContacts);
	}

	@Override
	public List<Contacts> searchContact(String theSearchName) {
		
		Session session= sessionFactory.getCurrentSession();
		
		Query theQuery;
		
		if(theSearchName!=null && theSearchName.trim().length()>0)
		{
			theQuery = session.createQuery("from Contacts where lower(firstName) like :theName or lower(lastName) like :theName", Contacts.class);
			theQuery.setParameter("theName", "%"+ theSearchName.toLowerCase() +"%");
		}
		else
		{
			theQuery = session.createQuery("from Contacts", Contacts.class);
		}
		
		List<Contacts> theContacts = theQuery.getResultList();
		
		return theContacts;
		
	}

	@Override
	public List<Contacts> searchNumber(String theNumber) {
Session session= sessionFactory.getCurrentSession();
		
		Query theQuery;
		
		if(theNumber!=null && theNumber.trim().length()>0)
		{
			theQuery = session.createQuery("from Contacts where phoneNumber like :theName", Contacts.class);
			theQuery.setParameter("theName", "%"+ theNumber +"%");
		}
		else
		{
			theQuery = session.createQuery("from Contacts", Contacts.class);
		}
		
		List<Contacts> theContacts = theQuery.getResultList();
		
		return theContacts;
	}


}
