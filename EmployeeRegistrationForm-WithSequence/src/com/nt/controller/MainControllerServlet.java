package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgtService;
import com.nt.service.EmployeeMgtServiceImpl;
import com.nt.vo.EmployeeVO;

@WebServlet("/empregurl")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeMgtService service;
	@Override
	public void init() throws ServletException {
		service = new EmployeeMgtServiceImpl();
	}
	
 	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		PrintWriter pw = null;
 		EmployeeVO vo = null;
 		EmployeeDTO dto = null;
 		RequestDispatcher rd =  null;
 		String result = null;
 		//get Writer Object
 		pw = res.getWriter();
 		//set Conetent type 
 		res.setContentType("text/html");
 		//create vo object
 		vo = new EmployeeVO();
 		//set values to VO object
 		vo.setName(req.getParameter("name"));
 		vo.setAddress(req.getParameter("address"));
 		vo.setCity(req.getParameter("pincode"));
 		vo.setPincode(req.getParameter("pincode"));
 		vo.setState(req.getParameter("states"));
 		vo.setCountry(req.getParameter("country"));
 		vo.setGender(req.getParameter("gender"));
 		vo.setMaritialStatus(req.getParameter("maritialstatus"));
 		vo.setEntryType(req.getParameter("entertype"));
 		vo.setEmail(req.getParameter("email"));
 		vo.setDob(req.getParameter("dob"));
 		vo.setMob(req.getParameter("mobileno"));
 		vo.setQualification(req.getParameter("qualification"));
 		vo.setSpecialization(req.getParameter("specialization"));
 		vo.setHobby(req.getParameter("hobby"));
 		vo.setColor(req.getParameter("color"));
 		vo.setAdhar(req.getParameter("adhar"));
 		//set Values to DTO
 		dto = new EmployeeDTO();
 		try {
 			dto.setName(vo.getName());
 			dto.setAddress(vo.getAddress());
 			dto.setCity(vo.getCity());
 			dto.setPincode(Integer.parseInt(vo.getPincode()));
 			dto.setState(vo.getState());
 			dto.setCountry(vo.getCountry());
 			dto.setGender(vo.getGender());
 			dto.setMaritialStatus(vo.getMaritialStatus());
 			dto.setEntryType(vo.getEntryType());
 			dto.setEmail(vo.getEmail());
 			dto.setDob(vo.getDob());
 			dto.setMob(Long.parseLong(vo.getMob()));
 			dto.setQualification(vo.getQualification());
 			dto.setSpecialization(vo.getSpecialization());
 			dto.setHobby(vo.getHobby());
 			dto.setColor(vo.getColor());
 			dto.setAdhar(Long.parseLong(vo.getAdhar()));
 			result = service.registerEmployee(dto);
 			rd = req.getRequestDispatcher("/headerurl");
 			rd.include(req, res);
 			pw.println("<h3 style='color:0000ff;'>"+result+"</h3>");
 			pw.println("<a href='employee_registration.html' style='text-decoration:none'>Registration Page</a>");
 			rd = req.getRequestDispatcher("/footerurl");
 			rd.include(req, res);
 		}
 		catch (SQLException se) {
 			se.printStackTrace();
 			rd = req.getRequestDispatcher("/errorurl");
 			rd.include(req, res);
 			rd = req.getRequestDispatcher("/footerurl");
 			rd.include(req, res);
 		}
 		catch (Exception e) {
 			e.printStackTrace();
 			rd = req.getRequestDispatcher("/errorurl");
 			rd.include(req, res);
 			rd = req.getRequestDispatcher("/footerurl");
 			rd.include(req, res);
 		}
 	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
