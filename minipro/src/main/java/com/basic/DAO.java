package com.basic;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	
	public int saveEmployee(minipojo employee) throws SQLException, ClassNotFoundException;
	public int updateEmployee(minipojo employee) throws ClassNotFoundException, SQLException;
	public int deleteEmployee(String Id) throws ClassNotFoundException, SQLException;
	public minipojo getid1(String id) throws ClassNotFoundException, SQLException;
	public List<minipojo> getalldata() throws ClassNotFoundException, SQLException;
	public minipojo getid(String id) throws ClassNotFoundException, SQLException;
	
	

}
