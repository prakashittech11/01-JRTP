package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.Contact;
import com.nit.services.ContactServiceImpl;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactServiceImpl services;
	
	/**
	 * show register page
	 * on enter /register url
	 */
	@GetMapping("/register")
	public String loadForm() {
		return "ContactRegister";
	}
	
	@PostMapping("/save")
	public String saveContactDetails(@ModelAttribute Contact c,Model model) {
		Integer isSaved = services.saveContact(c);
		model.addAttribute("success", "Contact Saved");
		return "ContactRegister";
	}
	
	@GetMapping("/display")
	public String displayAllContact(Model model) {
		List<Contact> list = services.getAllContactRecord();
		model.addAttribute("list", list);
		return "ContactData";
	}
	
	@GetMapping("/delete")
	public String deleteContactRecord(@RequestParam Integer id,Model model) {
		services.deleteContact(id);
		model.addAttribute("deletemsg", "Contact Deleted");
		model.addAttribute("list",services.getAllContactRecord());
		return "ContactData";
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,Model model) {
		Contact c = services.getOneContact(id);
		model.addAttribute("contact", c);
		return "editContact";
	}
	
	@PostMapping("/update")
	public String updateContactRecord(@ModelAttribute Contact c,Model model) {
		services.updateContact(c);
		return "redirect:display";
	}
}
