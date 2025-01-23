package com.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllemployee
 */
@WebServlet("/viewAllemployee")
public class viewAllemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllemployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO abc;
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		List<minipojo> emp2=new ArrayList<>();
		minipojo emp3=new minipojo();
		abc = new empdaoimp();
		try {
			emp2=abc.getalldata();
			writer.print("<table border='1' width='150'");
			writer.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			for(minipojo ab:emp2) {
				writer.print("<tr><td>"+ab.getId()+"</td><td>"+ab.getName()+"</td><td>"+ab.getPassword()
				+"</td><td>"+ab.getEmail()+"</td><td>"+ab.getCountry()+"</td><td>"
                + "<a href='editbyId?id=" + ab.getId() + "'>edit</a>   </td><td>"
                + "<a href='deleteById?id=" + ab.getId() + "'>delete</a> </td></tr>");
				
			}
				writer.print("</table");
				writer.println("<br>");
				writer.println("<br>"+"<a href ='front.html'>add more employee</a>");
				//request.getDispatcherType()
				writer.close();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
