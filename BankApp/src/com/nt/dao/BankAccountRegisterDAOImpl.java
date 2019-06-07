package com.nt.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BankAccountRegisterBO;

public class BankAccountRegisterDAOImpl implements BankAccountRegisterDAO {
	
	private static final String INSERT_QUERY = "INSERT INTO SBI_BANK_REGISTER VALUES (CUST_NO_BANK.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ID_QUERY = "SELECT CUSTNO FROM SBI_BANK_REGISTER WHERE ADHARNO = ? AND EMAIL = ?";
	private static final String EDIT_NAME = "UPDATE SBI_BANK_REGISTER SET HOLDERNAME = ? WHERE CUSTNO= ? AND FATHERNAME = ? AND DOB = ?";
	private static final String EDIT_ADHAR = "UPDATE SBI_BANK_REGISTER SET ADHARNO = ? WHERE CUSTNO= ? AND HOLDERNAME = ? AND DOB = ?";
	private static final String EDIT_EMAIL = "UPDATE SBI_BANK_REGISTER SET EMAIL = ? WHERE CUSTNO= ? AND HOLDERNAME = ? AND DOB = ?";
	private static final String EDIT_MOBILE = "UPDATE SBI_BANK_REGISTER SET MOBNO = ? WHERE CUSTNO= ? AND HOLDERNAME = ? AND DOB = ?";
	private static final String EDIT_FATHER_NAME = "UPDATE SBI_BANK_REGISTER SET FATHERNAME = ? WHERE CUSTNO= ? AND HOLDERNAME = ? AND DOB = ?";
	private static final String EDIT_DOB = "UPDATE SBI_BANK_REGISTER SET DOB = ? WHERE CUSTNO= ? AND HOLDERNAME = ? AND ADHARNO = ?";
	@Override
	public int insertRecord(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Polled Connection
		con = getConnection();
		//create PreparedStatement object
		ps = con.prepareStatement(INSERT_QUERY);
		if (ps != null) {
			//set values to query parameter
			ps.setString(1, bo.getAccountHolderName());
			ps.setString(2, bo.getFatherName());
			ps.setDate(3, bo.getDate());
			ps.setLong(4, bo.getAdharNumber());
			ps.setDate(5, bo.getDob());
			ps.setString(6, bo.getEmail());
			ps.setLong(7, bo.getMobileNumber());
			ps.setString(8, bo.getAccountType());
			ps.setBinaryStream(9, new FileInputStream(bo.getPhotoPath()), bo.getPhotoPath().length());
			ps.setBinaryStream(10, new FileInputStream(bo.getCertificatePath()), bo.getCertificatePath().length());
			ps.setBinaryStream(11, new FileInputStream(bo.getAdharPath()), bo.getAdharPath().length());
			ps.setBinaryStream(12, new FileInputStream(bo.getSignaturePath()), bo.getSignaturePath().length());
			//execute Query
			result = ps.executeUpdate();
		}//if
		//return the result
		return result;
	}
	@Override
	public int getCustomerID(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		//get Polled Connection
		con = getConnection();
		//create PreparedStatement object
		ps = con.prepareStatement(GET_ID_QUERY);
		if (ps != null) {
			//set the values to query param
			ps.setLong(1, bo.getAdharNumber());
			ps.setString(2, bo.getEmail());
			//execute the Query
			rs = ps.executeQuery();
		}//if
		if (rs != null)
			if (rs.next())
				id = rs.getInt(1);
		return id;
	}
	private Connection getConnection() throws Exception {
		Connection con = null;
		InitialContext ic = null;
		DataSource ds = null;
		//create InitialContext object
		ic = new InitialContext();
		//get DataSource object
		ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Connection
		con = ds.getConnection();
		return con;
	}//getConnection()
	@Override
	public int changeName(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_NAME);
		//set values to query param
		ps.setString(1, bo.getAccountHolderName());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getFatherName());
		ps.setDate(4, bo.getDob());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	@Override
	public int changeFatherName(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_FATHER_NAME);
		//set values to query param
		ps.setString(1, bo.getFatherName());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getAccountHolderName());
		ps.setDate(4, bo.getDob());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	
	@Override
	public int changeAdhar(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_ADHAR);
		//set values to query param
		ps.setLong(1, bo.getAdharNumber());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getAccountHolderName());
		ps.setDate(4, bo.getDob());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	@Override
	public int changeEmail(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_EMAIL);
		//set values to query param
		ps.setString(1, bo.getEmail());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getAccountHolderName());
		ps.setDate(4, bo.getDob());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	@Override
	public int changeDob(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_DOB);
		//set values to query param
		ps.setDate(1, bo.getDob());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getAccountHolderName());
		ps.setLong(4, bo.getAdharNumber());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	
	@Override
	public int changeMobileNumber(BankAccountRegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PrepareStatement object
		ps = con.prepareStatement(EDIT_MOBILE);
		//set values to query param
		ps.setLong(1, bo.getMobileNumber());
		ps.setInt(2, bo.getCustNumber());
		ps.setString(3, bo.getAccountHolderName());
		ps.setDate(4, bo.getDob());
		//execute the query
		result = ps.executeUpdate();
		return result;
	}
	
}//class
