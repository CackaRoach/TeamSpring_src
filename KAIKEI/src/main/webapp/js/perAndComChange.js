/**
 * 
 */
function pChangeCheck(){
				if(document.frm.password.value.length == 0){
					alert("Please write password.");
					frm.password.focus();
					return false;
				}
				if(document.frm.passwordCheck.value.length == 0){
					alert("Please write password check.");
					frm.passwordCheck.focus();
					return false;
				}
				if(document.frm.password.value != document.frm.passwordCheck.value){
					alert("Please write the same password and password confirmation.")
					frm.passwordCheck.focus();
					return false;
				}
				if(document.frm.name.value.length == 0){
					alert("Please write name.");
					frm.name.focus();
					return false;
				}
				if(document.frm.email.value.length == 0){
					alert("Please write email.");
					frm.email.focus();
					return false;
				}
				if(document.frm.phone.value.length == 0){
					alert("Please write phone.");
					frm.phone.focus();
					return false;
				}
			}

function cChangeCheck(){
	if(document.frm.title.length == 0){
		alert("Please Write title");
		frm.title.focus();
		return false;
	} else if (document.frm.company_cd.length == 0){
		alert("Please Write company_cd");
		frm.company_cd.focus();
		return false;
	} else if (document.frm.reg_cd.length == 0){
		alert("Please Write reg_cd");
		frm.reg_cd.focus();
		return false;
	} else if (document.frm.fax.length == 0){
		alert("Please Write fax");
		frm.fax.focus();
		return false;
	} else if (document.frm.phone.length == 0){
		alert("Please Write phone");
		frm.phone.focus();
		return false;
	} else if (document.frm.domain.length == 0){
		alert("Please Write domain");
		frm.domain.focus();
		return false;
	} else if (document.frm.bank_title.length == 0){
		alert("Please Write bank_title");
		frm.bank_title.focus();
		return false;
	}
}