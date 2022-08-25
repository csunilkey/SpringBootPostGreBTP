package com.sun1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vendor")
public class Vendor {
	
	@Id
	@Column(nullable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(nullable = false, name = "COMAPANY_NAME")
	public String companyName;
	@Column(nullable = false, name = "FIRST_NAME")
	public String firstName;
	@Column(nullable = false, name = "LAST_NAME")
	public String lastName;
	@Column(nullable = false, name = "WEBSITE")
	public String website;
	@Column(nullable = false, name = "EMAILID")
	public String email;
	@Column(nullable = false, name = "STATUS")
	public String status;
	@Column(nullable = false, name = "GST_NO")
	public String gstNo;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor", referencedColumnName = "ID")
	public List<Address> address = new ArrayList<Address>();
	
		
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Vendor() {
		
	}
	
	public Vendor(Long id, String companyName, String firstName, String lastName, String website, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}	

}
