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
 * Servlet implementation class deleteempdata
 */
@WebServlet("/deleteById")
public class deleteempdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteempdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO abc;
		int status=0;
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String Id=request.getParameter("id");
		abc=new empdaoimp();
		
		try {
			status=abc.deleteEmployee(Id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if (status>0){
	            writer.println("Record deleted.."+Id);
	            System.out.println("Record deleted successfully."+Id);
	            request.getRequestDispatcher("/front.html").include(request, response);
	        }else {
	            writer.println("deletion failed."+Id);
	            System.out.println("deletion failed.."+Id);
	        }
		
		
			}

}
