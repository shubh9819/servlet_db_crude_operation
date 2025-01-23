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
 * Servlet implementation class edit
 */
@WebServlet("/editbyId")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO abc;
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String Id=request.getParameter("id");
		abc=new empdaoimp();
		minipojo emp4=new minipojo();
		
		try {
			emp4=abc.getid(Id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//hiden field
		writer.println("<form name=\" edit form\" action=\"AFTEReditbyId\">");
        writer.println("<input type='hidden' name='id' value="+Id+"><br><br>");
        writer.println("Id:<input type=\"text\" name=\"id\" value="+emp4.getId()+"><br>");
        writer.println("Name:<input type=\"text\" name=\"Name\" value="+emp4.getName()+"><br>");
        writer.println("Password:<input type=\"text\" name=\"password\" value="+emp4.getPassword()+"><br>");
        writer.println("Email:<input type=\"text\" name=\"email\" value="+emp4.getEmail()+"><br>");
        writer.println("Country: <select name=\"country\">");
        writer.println("<option value=\"India\">INDIA</option>");
        writer.println("<option value=\"Pakistan\">PAKISTAN</option>");
        writer.println("<option value=\"Russia\">RUSSIA</option>");
        writer.println("<option value=\"Nepal\">NEPAL</option>");
        writer.println("<option value=\"Bhutan\">BHUTAN</option>");
        writer.println("</select><br><br>");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");

        writer.close();
	}

}
