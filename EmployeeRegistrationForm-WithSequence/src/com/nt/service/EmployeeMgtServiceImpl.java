package com.nt.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgtServiceImpl implements EmployeeMgtService {
	EmployeeDAO dao;
	public EmployeeMgtServiceImpl() {
		dao = new EmployeeDAOImpl();
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		EmployeeBO bo = null;
		DateFormat df = null;
		java.util.Date udate = null;
		int result = 0, eid;
		//create BO object
		bo = new EmployeeBO();
		//make a dateformat
		df = new SimpleDateFormat("dd-MM-yyyy");
		udate = df.parse(dto.getDob());
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setCity(dto.getCity());
		bo.setPincode(dto.getPincode());
		bo.setState(dto.getState());
		bo.setCountry(dto.getCountry());
		bo.setGender(dto.getGender());
		bo.setMaritialStatus(dto.getMaritialStatus());
		bo.setEntryType(dto.getEntryType());
		bo.setEmail(dto.getEmail());
		bo.setDob(new java.sql.Date(udate.getTime()));
		bo.setMob(dto.getMob());
		bo.setQualification(dto.getQualification());
		bo.setSpecialization(dto.getSpecialization());
		bo.setHobby(dto.getHobby());
		bo.setColor(dto.getColor());
		bo.setAdhar(dto.getAdhar());
		result = dao.insert(bo);
		eid = dao.getEID(bo);
		if (result == 0)
			return "Registration Failed";
		else
			return "Registration Succeded And Your Employee ID::::"+eid;
	}//registerEmployee(-)
}//class
