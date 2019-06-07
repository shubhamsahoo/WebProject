package com.nt.bo;

import java.io.File;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankAccountRegisterBO {
	private int custNumber;
	private String accountHolderName;
	private String fatherName;
	private Date date;
	private long adharNumber;
	private Date dob;
	private String email;
	private long mobileNumber;
	private String accountType;
	private File photoPath;
	private File certificatePath;
	private File adharPath;
	private File signaturePath;
}
