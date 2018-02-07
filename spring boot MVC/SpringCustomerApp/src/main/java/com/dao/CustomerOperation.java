package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.model.Customer;
import com.model.Order;

public interface CustomerOperation extends JpaRepository<Customer, Long> {

	Customer findCustomerBycustIDPK(int id);
    
	@Query("update Customer set title = :title,firstName = :fname,middleName = :mname,lastName = :lname,suffix = :suffix,email = :email,company = :company,displayName = :display,prStringOnCheckAs = :check  where custIDPK = :id")
	boolean updateCustomer(@Param("title") String title,@Param("fname") String fname,@Param("mname") String mname,@Param("lname") String lname,@Param("suffix") String suffix,@Param("company") String company,@Param("display") String display,@Param("check") String check,@Param("id") int id);
	

}
