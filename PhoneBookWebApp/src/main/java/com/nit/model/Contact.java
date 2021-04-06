package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "contact_tab")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "con_cid_col")
	private Integer cid;

	@Column(name = "con_cname_col")
	private String cname;

	@Column(name = "con_email_col")
	private String email;

	@Column(name = "con_cno_col")
	private Long contactno;

	@Column(name = "con_createddate_col",insertable = true)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "con_updateddate_col",updatable = false)
	private Date updatedDate;
}
