package com.sun1.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sun1.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long>{
	
//	List<Vendor> findBycompanyName(String companyName);
//	
//	@Query(nativeQuery=true, 
//			value="select * from public.vendor where FIRST_NAME like %?1% "
//					+ "and COMAPANY_NAME like %?2% ")
//	List<Vendor> wildCardLookUp(String wildcard1, String wildcard2);
//	
//	@Query(nativeQuery=true, 
//			value="select * from public.vendor where COMAPANY_NAME like %?1% ")
//	List<Vendor> wildCardPath(String wildcard);
	

}
