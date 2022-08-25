package com.sun1.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun1.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, Long>{
	
	public List<Address> findByZipCode(String srchFld);

}
