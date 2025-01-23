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
 * Servlet implementation class AFTEReditbyId
 */
@WebServlet("/AFTEReditbyId")
public class AFTEReditbyId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AFTEReditbyId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
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
	        
	        minipojo pojo=new minipojo();
	        pojo.setId(Id);
	        pojo.setName(Name);
	        pojo.setPassword(Password);
	        pojo.setEmail(Email);
	        pojo.setCountry(Country);
	        abc=new empdaoimp();
	        try {
				result=abc.updateEmployee(pojo);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       if(result>0) {
	    	   writer.println("updated successfully"+pojo.getId());
	    	   System.out.println("updated successfully"+pojo.getId());
	            request.getRequestDispatcher("front.html").include(request, response);

	       }
	       else {
	    	   writer.println("update fail"+pojo.getId());
	    	   System.out.println("update fail"+pojo.getId());
	    	   

	       }
	        

	}

}
