package com.nt.dao;


import com.nt.bo.BankAccountRegisterBO;

public interface BankAccountRegisterDAO {
	int insertRecord(BankAccountRegisterBO bo)throws Exception;
	int getCustomerID(BankAccountRegisterBO bo)throws Exception;
	int changeName(BankAccountRegisterBO bo)throws Exception;
	int changeFatherName(BankAccountRegisterBO bo)throws Exception;
	int changeAdhar(BankAccountRegisterBO bo)throws Exception;
	int changeEmail(BankAccountRegisterBO bo)throws Exception;
	int changeDob(BankAccountRegisterBO bo)throws Exception;
	int changeMobileNumber(BankAccountRegisterBO bo)throws Exception;
}
