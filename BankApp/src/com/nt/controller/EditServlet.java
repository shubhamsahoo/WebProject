package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editcontroller")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String request = null;
		RequestDispatcher rd = null;
		//get PrintWriter
		pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		request = req.getParameter("request");
		pw.println("<head>");
		pw.println("<title>Edit | Details...</title>");
		pw.println("<link rel='icon' href='sbi-logo.png'>");
		pw.println("<style>"
				+ "a{"
				+ "text-decoration:none;"
				+ "}"
				+ "</style>");
		pw.println("</head>");
		pw.println("<body bgcolor='cyan'>");
		if (request.equalsIgnoreCase("changename")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Name</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New Name::<input type='text' name='new'><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Father Name::<input type='text' name='fname'><br>");
			pw.println("DOB::<input type='date' name='dob'><br>");
			pw.println("<input type=\"hidden\" value=\"changename\" name=\"vflag\"/><br>");
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else if (request.equalsIgnoreCase("changeadhar")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Adhar Number</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New Adhar::<input type='text' name='new' maxlength=\"12\"><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Customer Name::<input type='text' name='name'><br>");
			pw.println("DOB::<input type='date' name='dob'><br>");
			pw.println("<input type=\"hidden\" value=\"changeadhar\" name=\"vflag\"/><br>");
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else if (request.equalsIgnoreCase("changeemail")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Email</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New Email::<input type='text' name='new'><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Customer Name::<input type='text' name='name'><br>");
			pw.println("DOB::<input type='date' name='dob'><br>");
			pw.println("<input type=\"hidden\" value=\"changeemail\" name=\"vflag\"/><br>");			
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else if (request.equalsIgnoreCase("changemobilenumber")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Mobile Number</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New Mobile Number::<input type='text' name='new' maxlength='10'><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Customer Name::<input type='text' name='name'><br>");
			pw.println("DOB::<input type='date' name='dob'><br>");
			pw.println("<input type=\"hidden\" value=\"changemobilenumber\" name=\"vflag\"/><br>");			
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else if (request.equalsIgnoreCase("changefname")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Father Name</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New Father Name::<input type='text' name='new'><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Customer Name::<input type='text' name='name'><br>");
			pw.println("DOB::<input type='date' name='dob'><br>");
			pw.println("<input type=\"hidden\" value=\"changefname\" name=\"vflag\"/><br>");
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else if (request.equalsIgnoreCase("changedob")) {
			pw.println("<h1 style='color:red;text-align: center'>Enter details to change Father Name</h1>");
			pw.println("<form action='editurl' method='post'>");
			pw.println("Enter New DOB::<input type='date' name='new'><br><br>");
			pw.println("Customer Number::<input type='text' name='cno'><br>");
			pw.println("Customer Name::<input type='text' name='name'><br>");
			pw.println("Adhar Number::<input type='text' name='adhar' maxlength='12'><br>");
			pw.println("<input type=\"hidden\" value=\"changedob\" name=\"vflag\"/><br>");
			pw.println("<input type='submit' value='process'>");
			pw.println("</form><br><br>");
			//pw.println("<a href='maincontroller?val=edit'>back</a>");
		}
		else {
			//get Dispatcher
			rd = req.getRequestDispatcher("/unchange");
			rd.include(req, res);
		}
		pw.println("</body>");
		//close stream
		pw.close();
	}//doGet(-, -)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//diPost(-, -)
}
//class