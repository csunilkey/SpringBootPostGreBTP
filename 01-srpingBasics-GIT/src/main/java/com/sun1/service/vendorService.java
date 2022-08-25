package com.sun1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sun1.entities.Vendor;

@Component
@ComponentScan
public class vendorService {
	
	@Autowired
	IVendorPersistence vendor;
	
//	public List<E> = new List()
	
	public List<Vendor> getAllVendors() {
		return vendor.findAll();	
	}
	
//	public Vendor getSingleVendor(String code) {
//		return (Vendor)vendors.get(code);
//	}
	
	public Vendor postVendor(Vendor newVendorObject) {
		return vendor.save(newVendorObject);
	}
//	
//	public List<Vendor> findByCompanyName(String companyName) {
//		return vendor.findBycompanyName(companyName);
//	}
//	
//	public List<Vendor> getWildCardSearch(String wildcard1, String wildcard2) {
//		return vendor.wildCardLookUp(wildcard1, wildcard2);
//	}
//	
//	public List<Vendor> getWildCardPathSrch(String wildcard) {
//		return vendor.wildCardPath(wildcard);
//	}
//	
//	public Vendor updateVendor(Vendor putObj) {
//		Optional<Vendor> vendObj = vendor.findById(putObj.id);
//		
//		if(vendObj.isPresent()) {
//			return vendor.save(putObj);
//		}
//		else {
//			return new Vendor((long)0, "","","","","","",null);
//		}
//	}
//	
	public String deleteVendor(Long Id) {
		Optional<Vendor> delVendObj = vendor.findById(Id);
		
		if(delVendObj.isPresent()) {
			vendor.deleteById(Id);
			return "Deleted Successfully";
		}
		else {
			return "Could not find the record to Delete";
		}
	}
	
//	public Vendor putVendor(Vendor newPutObject) {
//		newPutObject.code = "26-Newly Put";
//		return newPutObject;
//	}
	
	

}
