package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error1")
public class ErrorServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		//get PrintWriter
		pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		pw.println("<h1 style='color:red; text-align:center;'>You are giving some wronge data or you are not yet registered</h1>");
		//hyper link
		pw.println("<a style='text-decoration:none;' href='editcontroller?request="+req.getParameter("vflag")+"' title='go Back'>back</a>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
