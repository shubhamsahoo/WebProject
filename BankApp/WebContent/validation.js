/**
 * for client side validation 
 */
function validate(frm) {
	//set valid value to yes
	frm.valid.value = "yes";
	//set colors to error message
	document.getElementById("nameErr").style="color:red";
	document.getElementById("fnameErr").style="color:red";
	document.getElementById("dateErr").style="color:red";
	document.getElementById("adharErr").style="color:red";
	document.getElementById("dobErr").style="color:red";
	document.getElementById("emailErr").style="color:red";
	document.getElementById("mobileErr").style="color:red";
	document.getElementById("photoErr").style="color:red";
	document.getElementById("certificateErr").style="color:red";
	document.getElementById("adharPicErr").style="color:red";
	document.getElementById("signatureErr").style="color:red";
	//today date
	var todayDate = new Date().getDate();
	var todayMonth = new Date().getMonth();
	var todayYear = new Date().getFullYear();
	//read form data
	var name = frm.name.value;
	var fname = frm.fname.value;
	var date = frm.date.value;
	var year = new Date(date).getFullYear();
	var month = new Date(date).getMonth();
	var day = new Date(date).getDate();
	var adhar = frm.adhar.value;
	var dob = frm.dob.value;
	var mob = frm.mob.value;
	//validate form data
	if (name == null || name=="") {
		alert("Name is mandetory should not be ignored");
		document.getElementById("nameErr").innerHTML="<b>Name is mandetory</b>";
		frm.name.focus();
		return false;
	}
	if (fname == null || fname=="") {
		alert("Father Name is mandetory should not be ignored");
		document.getElementById("fnameErr").innerHTML="<b>Father Name is mandetory</b>";
		frm.fname.focus();
		return false;
	}
	if (date == null || date=="") {
		alert("Enter Date");
		document.getElementById("dateErr").innerHTML="<b>Date is mandetory</b>";
		frm.date.focus();
		return false;
	}
	if ((todayDate != day) || (todayMonth != month) || (todayYear != year)) {
		alert("Entred date is not current Date");
		document.getElementById("dateErr").innerHTML="<b>Enter Today's Date Only</b>";
		frm.date.focus();
		return false;
	}
	if (adhar==null||adhar==0||adhar=="") {
		alert("Enter Adhar Number");
		document.getElementById("adharErr").innerHTML="<b>Adhar Number is mandetory</b>";
		frm.adhar.focus();
		return false;
	}
	if (isNaN(adhar)) {
		alert("Enter a valid adhar number");
		document.getElementById("adharErr").innerHTML="<b>Valid Adhar Number Only</b>";
		frm.adhar.focus();
		return false;
	}
	if (dob == null || dob=="") {
		alert("Enter Date Of Birth");
		document.getElementById("dobErr").innerHTML="<b>Date of Birth is mandetory</b>";
		frm.dob.focus();
		return false;
	}
	if (mob == null || mob=="" || mob==0) {
		alert("Enter Mobile Number");
		document.getElementById("mobileErr").innerHTML="<b>Mobile Number is mandetory</b>";
		frm.dob.focus();
		return false;
	}
	if (isNaN(mob)) {
		alert("Enter a valid mobile number");
		document.getElementById("mobileErr").innerHTML="<b>Valid Mobile Number Only</b>";
		frm.adhar.focus();
		return false;
	}
	return true;
}