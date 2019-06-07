package com.nt.service;


import com.nt.vo.BankAccountRegisterVO;

public interface BankAccountManagementService {
	String register(BankAccountRegisterVO vo)throws Exception;
	String editName(BankAccountRegisterVO vo)throws Exception;
	String editFatherName(BankAccountRegisterVO vo)throws Exception;
	String editEmail(BankAccountRegisterVO vo)throws Exception;
	String editDob(BankAccountRegisterVO vo)throws Exception;
	String editAdhar(BankAccountRegisterVO vo)throws Exception;
	String editMobileNumber(BankAccountRegisterVO vo)throws Exception;
}
