package com.sun1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun1.entities.Vendor;
import com.sun1.service.vendorService;

@RestController
public class VendorController {
	
	@Autowired
	vendorService vserv;	
	
	@RequestMapping("/vendor")
	public List<Vendor> getvendors() {
		return vserv.getAllVendors();
	}
	
//	@RequestMapping("/vendor/{code}")	
//	public Vendor getVendorById(@PathVariable("code") String code) {		
//		return vserv.getSingleVendor(code);
//	}
	
	@PostMapping("/vendorPost")
	public Vendor postVendor(@RequestBody Vendor newVendorObject) {		
		return vserv.postVendor(newVendorObject);
	}
//	
//	@RequestMapping("/vendor/search")
//	public List<Vendor> searchByCompany(@RequestParam String companyName) {
//		return vserv.findByCompanyName(companyName);
//	}
//	
//	@RequestMapping("/vendor/contains")
//	public List<Vendor> searchByWildCard(@RequestParam String wildcard1, String wildcard2) {
//		return vserv.getWildCardSearch(wildcard1, wildcard2);
//	}
//	
//	@RequestMapping("/vendor/contains/{wildcard}")
//	public List<Vendor> searchByWildCard_Path(@PathVariable("wildcard") String wildcard) {
//		return vserv.getWildCardPathSrch(wildcard);
//	}
//	
//	@RequestMapping("/vendorPut")
//	public Vendor putVendorObj(@RequestBody Vendor newPutObject) {
//		return vserv.updateVendor(newPutObject);
//	}
//	
	@RequestMapping("/vendorDelete/{id}")
	public String delVendorObj(@PathVariable("id") Long Id) {
		return vserv.deleteVendor(Id);
	}
	
//	@RequestMapping(method = RequestMethod.PUT, value = "/vendorPut")
//	public Vendor putVendor(@RequestBody Vendor newPutObject) {
//		return vserv.putVendor(newPutObject);
//	}
	
	
	
	
	


}
