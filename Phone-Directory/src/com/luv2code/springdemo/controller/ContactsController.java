package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Contacts;
import com.luv2code.springdemo.service.ContactsService;

@Controller
@RequestMapping("/directory")
public class ContactsController {

	@Autowired
	private ContactsService contactsService;
	
	@GetMapping("/list")
	private String list(Model theModel)
	{
		
		List<Contacts> contacts=contactsService.getContacts();
		
		theModel.addAttribute("contacts",contacts);
		
		return "contacts-list";
	}
	
	@GetMapping("/showFormForAdd")
	private String showFormForAdd(Model theModel)
	{
	    theModel.addAttribute("contacts",new Contacts());
	    
	    return "contacts-form";
	}
	
	@GetMapping("/SearchForm")
	private String SearchForm(Model theModel)
	{
	    theModel.addAttribute("contacts",new Contacts());
	    
	    return "search-form";
	}
	
	@PostMapping("/saveContacts")
	private String saveContacts(@ModelAttribute("contacts") Contacts theContacts)
	{
		contactsService.saveContacts(theContacts);
		
		return "redirect:/directory/list";
	}
	
	@GetMapping("/showFormForUpdate")
	private String updateContacts(@RequestParam("contactsId") int theId, Model theModel)
	{
		Contacts theContacts = contactsService.getContacts(theId);
		
		theModel.addAttribute("contacts",theContacts);
		
		return "contacts-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("contactsId") int theId, Model theModel)
	{
		//delete the customer
		contactsService.deleteContacts(theId);
		
		//send over to form
		return "redirect:/directory/list";	
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("theSearchName") String theSearchName, Model theModel)
	{
		//delete the customer
		List<Contacts> theContacts = contactsService.searchContact(theSearchName);
		
		theModel.addAttribute("contacts",theContacts);
		
		//send over to form
		return "contacts-list";	
	}
	
	@GetMapping("/search1")
	public String SearchNumber(@RequestParam("theSearchNumber") String theNumber, Model theModel)
	{
		//delete the customer
		List<Contacts> theContacts = contactsService.searchNumber(theNumber);
		
		theModel.addAttribute("contacts",theContacts);
		
		//send over to form
		return "contacts-list";	
	}
}
