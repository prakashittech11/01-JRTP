package com.nit.exception;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException {

	public ContactNotFoundException() {
		super();
	}
	
	public ContactNotFoundException(String msg) {
		super(msg);
	}
	

	
}
