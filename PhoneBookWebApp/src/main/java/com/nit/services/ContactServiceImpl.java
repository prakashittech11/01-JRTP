package com.nit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.exception.ContactNotFoundException;
import com.nit.model.Contact;
import com.nit.repo.ContactRepositry;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private ContactRepositry repo;
	
	@Override
	public Integer saveContact(Contact c) {
		Contact issave = repo.save(c);
		return issave.getCid();
	}

	@Override
	public List<Contact> getAllContactRecord() {

		List<Contact> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteContact(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public Contact getOneContact(Integer id) {

		return repo.findById(id).orElseThrow(()->
								new ContactNotFoundException("Employee " +id+ " exist"));
		
	}

	@Override
	public void updateContact(Contact c) {

		repo.save(c);
		
	}
	

}
