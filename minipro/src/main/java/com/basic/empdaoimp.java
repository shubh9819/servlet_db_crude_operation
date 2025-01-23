package com.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empdaoimp implements DAO {
	public static final String saveEmp="insert into emp (id ,name,password,email,country) values(?,?,?,?,?)";
	
	public static final String updateEmp="update emp set id=? ,name=? ,password=? ,email=? ,country=? where id=?";

	public static final String deleteEmp="delete from emp where id =?";

    public static final String getempEmpbyid="select * from emp where id=?";

    public static final String getallEmp="select * from emp";


	@Override
	public int saveEmployee(minipojo employee) throws SQLException,ClassNotFoundException {
		int status=0;
   Connection con=DBconnection.getconnection();
   PreparedStatement ps=con.prepareStatement(saveEmp);
   ps.setNString(1,employee.getId());
   
   ps.setNString(2,employee.getName());

   ps.setNString(3,employee.getPassword());

   ps.setNString(4,employee.getEmail());

   ps.setNString(5,employee.getCountry());
   status=ps.executeUpdate();
        return status;
	}

	@Override
	public int updateEmployee(minipojo employee) throws ClassNotFoundException, SQLException {
		int status=0;
		   Connection con=DBconnection.getconnection();
		   PreparedStatement ps=con.prepareStatement( updateEmp);
		   ps.setNString(1,employee.getId());
		   
		   ps.setNString(2,employee.getName());

		   ps.setNString(3,employee.getPassword());

		   ps.setNString(4,employee.getEmail());

		   ps.setNString(5,employee.getCountry());
		   ps.setString(6, employee.getId());
	        System.out.println(ps);
	        status = ps.executeUpdate();
	    
	        return status;
		
	}
	

//	 public int deleteEmployee(int Id) throws SQLException, ClassNotFoundException {
//	        int status = 0;
//	        Connection con = DBconnection.getconnection();
//	        PreparedStatement ps = con.prepareStatement(deleteEmp);
//
//	        ps.setInt(1, Id);
//	        System.out.println(ps);
//	        status = ps.executeUpdate();
//	        return status;
//	    }
   
	//@Override
	public minipojo getid(String id) throws ClassNotFoundException, SQLException {
		  int status = 0;
	        Connection con = DBconnection.getconnection();
	        PreparedStatement ps = con.prepareStatement(getempEmpbyid);
	        ps.setString(1,id);
	        System.out.println(ps);
	        ResultSet rs = ps.executeQuery();
	        minipojo emp = new minipojo();
	        while (rs.next()) {
	            emp.setId(rs.getString(1));
	            emp.setName(rs.getString(2));
	            emp.setPassword(rs.getString(3));
	            emp.setEmail(rs.getString(4));
	            emp.setCountry(rs.getString(5));

	        }
	        return emp;
	}

	@Override
	public List<minipojo> getalldata() throws ClassNotFoundException, SQLException {
		 List<minipojo> elist = new ArrayList<>();
	        int status = 0;
	        Connection con = DBconnection.getconnection();
	        PreparedStatement ps = con.prepareStatement(getallEmp);
	        System.out.println(ps);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            minipojo emp = new minipojo();
	            emp.setId(rs.getString(1));
	            emp.setName(rs.getString(2));
	            emp.setPassword(rs.getString(3));
	            emp.setEmail(rs.getString(4));
	            emp.setCountry(rs.getString(5));
	            elist.add(emp);
	        }
	        return elist;
	}

	@Override
	public minipojo getid1(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteEmployee(String Id) throws ClassNotFoundException, SQLException {
		int status = 0;
        Connection con = DBconnection.getconnection();
        PreparedStatement ps = con.prepareStatement(deleteEmp);

        ps.setString(1, Id);
        System.out.println(ps);
        status = ps.executeUpdate();
     
        return status;

	}

}
