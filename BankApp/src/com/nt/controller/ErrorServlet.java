package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		//get PrintWriter
		pw = res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		pw.println("<h1 style='color:red; text-align:center'>Registration Failled</h1>");
		pw.println("<br>");pw.println("<br>");pw.println("<br>");pw.println("<br>");
		pw.println("<h2 style='color:red; text-align:center'>Registration Failled</h2><br><br>");
		pw.println("<h2 style='color:red; text-align:center'>Internal Problem</h2>");
		pw.println("<br>");pw.println("<br>");pw.println("<br>");
		pw.println("<a href='account_register.html' target='_blank' title='Register Again'><img src='register-1.jpg' width='150'height='50'></a>");
		pw.println("<br>");pw.println("<br>");pw.println("<br>");pw.println("<br>");
		//close Stream
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
