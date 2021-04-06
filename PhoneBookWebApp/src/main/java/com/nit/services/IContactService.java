package com.nit.services;

import java.util.List;

import com.nit.model.Contact;

public interface IContactService {

	/**
	 * This method read FORM Data  as a model class
	 * @param c indicated ModelAttributes
	 * @return integer PK generated after save
	 */
	public Integer saveContact(Contact c);
	
	/**
	 * This method is send from DB to UI as a modelAttribute
	 * @return List<Contact> from UI
	 */
	public List<Contact> getAllContactRecord();
	
	/**
	 * This method is delete the record
	 * @param id
	 */
	
	public void deleteContact(Integer id);
	
	
	public Contact getOneContact(Integer id);
	
	
	public void updateContact(Contact c);
	
}
