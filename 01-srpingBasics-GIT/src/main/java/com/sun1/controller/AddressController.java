package com.sun1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun1.entities.Address;
import com.sun1.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addrServ;	
	
//	@RequestMapping("/address/addressId")
//	public List<Address> getAddress(@RequestParam Long id){
//		return addrServ.getAllAddresses(id);
//	}
	
	@RequestMapping("/address")
	public List<Address> getAddresses(){
		return addrServ.getAllAddresses();
	}
	
	@RequestMapping("/address/getByZip")
	public List<Address> getAddressByField(@RequestParam String zip) {
		return addrServ.findAddressByField(zip);
	}
	
//	@RequestMapping("/address/getByZip/{zip}")
//	public List<Address> getAddressByField(@PathVariable("zip") String zip) {
//		return addrServ.findAddressByField(zip);
//	}
	
	@RequestMapping("/addressPost")
	public Address createAddress(@RequestBody Address payLoad) {
		return addrServ.postAddress(payLoad);
	}

}
