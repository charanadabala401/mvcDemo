package com.dao;

public interface Queries {

	
	String LOGIN="select e.*,r.* from employee e,roles r "
			+ "where e.role_id=r.role_id and e.email=? and e.password=?";
	String ADDBANK="insert into bank(bank_name,ifsc,address)values(?,?,?)";
	String VIEWALLBANKS="select * from bank";
	String SEARCHBANK="select * from bank where bank_id=?";
}
