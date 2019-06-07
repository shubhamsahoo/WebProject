package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.BankAccountManagementService;
import com.nt.service.BankAccountManagementServiceImpl;
import com.nt.vo.BankAccountRegisterVO;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/maincontroller")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BankAccountManagementService service;
	@Override
	public void init() throws ServletException {
		service = new BankAccountManagementServiceImpl();
	}
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		BankAccountRegisterVO vo = null;
		String val = "", result = null;
		RequestDispatcher rd = null;
		MultipartFormDataRequest mreq = null;
		UploadBean upb = null;
		Hashtable<String, UploadFile> ht = null;
		UploadFile uf1 = null, uf2 = null, uf3 = null, uf4 = null;
		//get PrintWriter object
		pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		try {
			//prepare special object
			mreq = new MultipartFormDataRequest(req);
			//read form value
			val = mreq.getParameter("value");
		if (val.equalsIgnoreCase("SUBMIT")) {
			//create vo object
			vo = new BankAccountRegisterVO();
			//set Request param values to vo object
			vo.setAccountHolderName(mreq.getParameter("name"));
			vo.setFatherName(mreq.getParameter("fname"));
			vo.setDate(mreq.getParameter("date"));
			vo.setAdharNumber(mreq.getParameter("adhar"));
			vo.setDob(mreq.getParameter("dob"));
			vo.setEmail(mreq.getParameter("email"));
			vo.setMobileNumber(mreq.getParameter("mob"));
			vo.setAccountType(mreq.getParameter("account"));
			//specify FileUpload settings
			upb = new UploadBean();
			//set file limit to be uploaded
			upb.setFilesizelimit(50*1024);
			upb.setFolderstore("E:/store");
			//set File not to override
			upb.setOverwrite(false);
			//Store the files and complete the FileUpload
			upb.store(mreq);
			//get FileNames and set to vo object
			ht = mreq.getFiles();
			uf1 = ht.get("photo");
			uf2 = ht.get("certificate");
			uf3 = ht.get("adharphoto");
			uf4 = ht.get("signature");
			vo.setPhotoFileName(uf1.getFileName());
			vo.setCertificateFileName(uf2.getFileName());
			vo.setAdharFileName(uf3.getFileName());
			vo.setSignatureFileName(uf4.getFileName());
			//Register the Customer
			result = service.register(vo);
			pw.println("<h1 style='color:red;text-align:center;'>"+result+"</h1>");
			pw.println("<h1 style='color:red;text-align:center;'>Please remember your id</h1>");
			pw.print("<br><br><br>");
			//hyper link
			pw.println("<a href='account_register.html' target='_blank' title='Another Registration'><img src='register-1.jpg' width='150'height='50'></a>");
		}//if
		else {
			rd = req.getRequestDispatcher("/htmlurl");
			rd.forward(req, res);
		}//else
		}//try
		catch (Exception e) {
			e.printStackTrace();
			rd = req.getRequestDispatcher("/error");
			rd.forward(req, res);
		}
	}//doGet(-, -)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-, -)
}//class
