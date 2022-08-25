package com.sun1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sun1.entities.Address;

@Component
@ComponentScan
public class AddressService {
	
	@Autowired
	IAddressPersistence addr;

	public List<Address> getAllAddresses() {
		return addr.findAll();
	}
	
	public List<Address> findAddressByField(String srchFld) {
		return addr.findByZipCode(srchFld);
	}
	
	public Address postAddress(Address payLoad) {
		return addr.save(payLoad);
	}
	
}
