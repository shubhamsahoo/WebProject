package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.BankAccountManagementService;
import com.nt.service.BankAccountManagementServiceImpl;
import com.nt.vo.BankAccountRegisterVO;

@WebServlet("/editurl")
public class RealEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountManagementService service;
    
	@Override
    public void init() throws ServletException {
    	service = new BankAccountManagementServiceImpl();
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		RequestDispatcher rd = null;
		//get PrintWriter
		pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		String mob = null, name = null, fname= null, dob = null, vflag = null, cno = null, email = null, adhar = null, result = null;
		BankAccountRegisterVO vo = null;
		//create vo object read values and set to vo
		vo = new BankAccountRegisterVO();
		vflag = req.getParameter("vflag");
		if (vflag.equalsIgnoreCase("changename")) {
			name = req.getParameter("new");
			cno = req.getParameter("cno");
			fname = req.getParameter("fname");
			dob = req.getParameter("dob");
			vo.setAccountHolderName(name);
			vo.setCustNumber(cno);
			vo.setFatherName(fname);
			vo.setDob(dob);
			try {
				result = service.editName(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			}
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		else if (vflag.equalsIgnoreCase("changeadhar")) {
			adhar = req.getParameter("new");
			cno = req.getParameter("cno");
			name = req.getParameter("name");
			dob = req.getParameter("dob");
			vo.setAdharNumber(adhar);
			vo.setCustNumber(cno);
			vo.setAccountHolderName(name);
			vo.setDob(dob);
			try {
				result = service.editAdhar(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			}
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		else if (vflag.equalsIgnoreCase("changeemail")) {
			email = req.getParameter("new");
			cno = req.getParameter("cno");
			name = req.getParameter("name");
			dob = req.getParameter("dob");
			vo.setEmail(email);
			vo.setCustNumber(cno);
			vo.setAccountHolderName(name);
			vo.setDob(dob);
			try {
				result = service.editEmail(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			}
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		else if (vflag.equalsIgnoreCase("changemobilenumber")) {
			mob = req.getParameter("new");
			cno = req.getParameter("cno");
			name = req.getParameter("name");
			dob = req.getParameter("dob");
			vo.setMobileNumber(mob);
			vo.setCustNumber(cno);
			vo.setAccountHolderName(name);
			vo.setDob(dob);
			try {
				result = service.editMobileNumber(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			} 
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		else if (vflag.equalsIgnoreCase("changefname")) {
			fname = req.getParameter("new");
			cno = req.getParameter("cno");
			name = req.getParameter("name");
			dob = req.getParameter("dob");
			vo.setFatherName(fname);
			vo.setCustNumber(cno);
			vo.setAccountHolderName(name);
			vo.setDob(dob);
			try {
				result = service.editFatherName(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			}
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		else {
			dob = req.getParameter("new");
			cno = req.getParameter("cno");
			name = req.getParameter("name");
			adhar = req.getParameter("adhar");
			vo.setDob(dob);
			vo.setCustNumber(cno);
			vo.setAccountHolderName(name);
			vo.setAdharNumber(adhar);
			try {
				result = service.editDob(vo);
				pw.println("<h1 style='color:red; text-align:center'>"+result+"</h1>");
				//hyper link
				pw.println("<a style='text-decoration:none;' href='account_register.html' title='go to home'>home</a>");
			}
			catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("/error1");
				rd.forward(req, res);
			}
		}
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
