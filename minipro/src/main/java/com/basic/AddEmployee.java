package com.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO abc;
		int result=0;
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		 String Id = request.getParameter("id");
	        String Name = request.getParameter("name");
	        String Password = request.getParameter("email");
	        String Email = request.getParameter("password");
	        String Country = request.getParameter("country");

	        minipojo emp1 = new minipojo();
	        emp1.setId(Id);
	        emp1.setName(Name);
	        emp1.setPassword(Password);
	        emp1.setEmail(Email);
	        emp1.setCountry(Country);
	        
	        abc = new empdaoimp();
	        try {
	            result = abc.saveEmployee(emp1);
	        } catch (SQLException | ClassNotFoundException e) {
	            System.out.println(e);
	            throw new RuntimeException(e);
	        }
	        if (result > 0) {
	            System.out.println("Employee added successfully..");
	            writer.println("Employee added successfully..");
	            request.getRequestDispatcher("front.html").include(request, response);
	        } else {
	            System.out.println("\"Employee addition failed..\"");
	            writer.println("Employee addition failed..");
	            request.getRequestDispatcher("front.html").include(request, response);

	        }
		
	}

}
