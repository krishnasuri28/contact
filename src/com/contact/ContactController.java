package com.contact;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	@Autowired
	private ContactDao contactDao;

	@RequestMapping(value = "/")
	public ModelAndView getContacts(ModelAndView modelAndView) {
		List<Contact> contacts = contactDao.list();
		modelAndView.addObject("listContact", contacts);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView getNewContact(ModelAndView modelAndView) {
		Contact newContact = new Contact();
		modelAndView.addObject("contact", newContact);
		modelAndView.setViewName("contact_form");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute Contact contact) {
		if(contact.getContact_id() == null) {
		contactDao.save(contact);
		}
		else {
			contactDao.update(contact);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editContact(@RequestParam Integer id) {
		Contact contact = contactDao.get(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contact", contact);
		modelAndView.setViewName("contact_form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		contactDao.delete(id);
		return new ModelAndView("redirect:/");
	}
}
