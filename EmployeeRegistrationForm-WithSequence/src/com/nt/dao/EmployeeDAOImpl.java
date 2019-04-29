package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_EMPLOYEE_REGISTRATION = "INSERT INTO EMPLOYEE_REGISTRATION VALUES(EMP_REG_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_EMPLOYEE_REGISTRATION = "SELECT EID FROM EMPLOYEE_REGISTRATION WHERE ADHAR = ?";
	@Override
	public int insert(EmployeeBO bo) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//get Connection
		con = getConnection();
		//create PreparedStatement object
		if (con != null)
			ps = con.prepareStatement(INSERT_EMPLOYEE_REGISTRATION);
		//set values to Query parameter
		if (ps != null) {
			ps.setString(1, bo.getName());
			ps.setString(2, bo.getAddress());
			ps.setString(3, bo.getCity());
			ps.setInt(4, bo.getPincode());
			ps.setString(5, bo.getState());
			ps.setString(6, bo.getCountry());
			ps.setString(7, bo.getGender());
			ps.setString(8, bo.getMaritialStatus());
			ps.setString(9, bo.getEntryType());
			ps.setString(10, bo.getEmail());
			ps.setDate(11, bo.getDob());
			ps.setLong(12, bo.getMob());
			ps.setString(13, bo.getQualification());
			ps.setString(14, bo.getSpecialization());
			ps.setString(15, bo.getHobby());
			ps.setLong(16, bo.getAdhar());
			ps.setString(17, bo.getColor());
			//send and execute Query
			result = ps.executeUpdate();
		}
		return result;
	}
	@Override
	public int getEID(EmployeeBO bo) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int eid = 0;
		//get Connection object
		con = getConnection();
		//create PrepareStatemet object
		ps = con.prepareStatement(GET_EMPLOYEE_REGISTRATION);
		//set values to Query parameter
		ps.setLong(1, bo.getAdhar());
		rs = ps.executeQuery();
		if (rs != null) {
			if (rs.next())
				eid = rs.getInt(1);
		}
		return eid;
	}
	private Connection getConnection() throws Exception{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		//create ic object
		ic = new InitialContext();
		ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");
		con = ds.getConnection();
		return con;
	}//getConnection()
	
}//class
