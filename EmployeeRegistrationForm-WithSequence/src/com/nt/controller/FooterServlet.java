package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footerurl")
public class FooterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		//get Writer object
		pw = res.getWriter();
		pw.println("<br><br><br><br><br>");
		pw.println("<h4 style='text-align:center;'>&copy;All are Reserved</h4>");
	}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-, -)
}//class