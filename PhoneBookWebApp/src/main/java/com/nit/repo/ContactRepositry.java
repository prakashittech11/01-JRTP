package com.nit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Contact;

public interface ContactRepositry extends JpaRepository<Contact, Serializable>{

}
