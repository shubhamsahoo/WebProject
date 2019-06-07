package com.nt.service;

import java.io.File;
import java.text.SimpleDateFormat;

import com.nt.bo.BankAccountRegisterBO;
import com.nt.dao.BankAccountRegisterDAO;
import com.nt.dao.BankAccountRegisterDAOImpl;
import com.nt.vo.BankAccountRegisterVO;

public class BankAccountManagementServiceImpl implements BankAccountManagementService {
	
	private BankAccountRegisterDAO dao = null;
	
	public BankAccountManagementServiceImpl() {
		dao = new BankAccountRegisterDAOImpl();
	}
	
	@Override
	public String register(BankAccountRegisterVO vo) throws Exception {
		BankAccountRegisterBO bo = null;
		SimpleDateFormat sdf = null;
		java.util.Date udate = null, udob = null;
		int result = 0, id = 0;
		//create a date Format
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		//get the Dates
		udate = sdf.parse(vo.getDate());
		udob = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set values to bo
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setFatherName(vo.getFatherName());
		bo.setDate(new java.sql.Date(udate.getTime()));
		bo.setAdharNumber(Long.parseLong(vo.getAdharNumber()));
		bo.setDob(new java.sql.Date(udob.getTime()));
		bo.setEmail(vo.getEmail());
		bo.setMobileNumber(Long.parseLong(vo.getMobileNumber()));
		bo.setAccountType(vo.getAccountType());
		bo.setPhotoPath(new File("E:/store/"+vo.getPhotoFileName()));
		bo.setCertificatePath(new File("E:/store/"+vo.getCertificateFileName()));
		bo.setAdharPath(new File("E:/store/"+vo.getAdharFileName()));
		bo.setSignaturePath(new File("E:/store/"+vo.getSignatureFileName()));
		//insert the record
		result = dao.insertRecord(bo);
		//get Customer id
		id = dao.getCustomerID(bo);
		//process the result & return
		if (result >= 1)
			return "Registration Succeded"+"\n"+"Your Customet ID is:::"+id;
		else
			return "Registration Failled";
	}//register()

	@Override
	public String editName(BankAccountRegisterVO vo) throws Exception {
		java.util.Date udate = null;
		SimpleDateFormat sdf = null;
		BankAccountRegisterBO bo = null;
		int result = 0;
		//convert String.date to sql.date
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udate = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setFatherName(vo.getFatherName());
		bo.setDob(new java.sql.Date(udate.getTime()));
		//edit the old value with new 
		result = dao.changeName(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Name Changed Successfully";
	}

	@Override
	public String editFatherName(BankAccountRegisterVO vo) throws Exception {
		java.util.Date udate = null;
		SimpleDateFormat sdf = null;
		BankAccountRegisterBO bo = null;
		int result = 0;
		//convert String.date to sql.date
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udate = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setFatherName(vo.getFatherName());
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setDob(new java.sql.Date(udate.getTime()));
		//edit the old value with new 
		result = dao.changeFatherName(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Father number changed successfully";
	}

	@Override
	public String editEmail(BankAccountRegisterVO vo) throws Exception {
		java.util.Date udate = null;
		SimpleDateFormat sdf = null;
		BankAccountRegisterBO bo = null;
		int result = 0;
		//convert String.date to sql.date
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udate = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setEmail(vo.getEmail());
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setDob(new java.sql.Date(udate.getTime()));
		//edit the old value with new 
		result = dao.changeEmail(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Email changed successfully";
	}

	@Override
	public String editDob(BankAccountRegisterVO vo) throws Exception {
		BankAccountRegisterBO bo = null;
		int result = 0;
		java.util.Date udob = null;
		SimpleDateFormat sdf = null;
		//create SimpleDateFormat object
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udob = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setDob(new java.sql.Date(udob.getTime()));
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setAdharNumber(Long.parseLong(vo.getAdharNumber()));
		//edit the old value with new 
		result = dao.changeDob(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Date Of Birth changed successfully";
	}

	@Override
	public String editAdhar(BankAccountRegisterVO vo) throws Exception {
		java.util.Date udate = null;
		SimpleDateFormat sdf = null;
		BankAccountRegisterBO bo = null;
		int result = 0;
		//convert String.date to sql.date
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udate = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setAdharNumber(Long.parseLong(vo.getAdharNumber()));
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setDob(new java.sql.Date(udate.getTime()));
		//edit the old value with new 
		result = dao.changeAdhar(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Adhar number changed successfully";
	}

	@Override
	public String editMobileNumber(BankAccountRegisterVO vo) throws Exception {
		java.util.Date udate = null;
		SimpleDateFormat sdf = null;
		BankAccountRegisterBO bo = null;
		int result = 0;
		//convert String.date to sql.date
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		udate = sdf.parse(vo.getDob());
		//create bo object
		bo = new BankAccountRegisterBO();
		//set vo values to bo values
		bo.setMobileNumber(Long.parseLong(vo.getMobileNumber()));
		bo.setCustNumber(Integer.parseInt(vo.getCustNumber()));
		bo.setAccountHolderName(vo.getAccountHolderName());
		bo.setDob(new java.sql.Date(udate.getTime()));
		//edit the old value with new 
		result = dao.changeMobileNumber(bo);
		//process the result
		if (result == 0)
			return "You are giving some wronge data or you are not yet registered";
		else
			return "Mobile number changed successfully";
	}
}//class
