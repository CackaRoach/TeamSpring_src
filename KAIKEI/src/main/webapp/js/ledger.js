
$(window).ready(function() {

	var existrows =  $("#existrows").val();
	var newrows = 0;
	
	var today = new Date($("#year").val(), $("#month").val() - 1);
	var yy = String(today.getFullYear()).substring(2);
	var mm = today.getMonth() + 1;

	// Init Row
	for(newrows = 0; newrows < (30 - existrows); newrows++) {
		var fixedrows = existrows + newrows;
		
		var rowItem = "";
		rowItem += "<tr id='state" + fixedrows + "' class='new'>";
		rowItem += "<td><label>" + yy + "</label></td>";
		rowItem += "<td><label>" + mm + "</label></td>";
		rowItem += "<td><input type='text' name='date' maxlength='2' placeholder='D'/></td>";
		rowItem += "<td><input type='text' name='account_cd' maxlength='4' placeholder='0000'/></td>";
		rowItem += "<td><input type='text' name='customer_cd' maxlength='5' placeholder='00000'/></td>";
		rowItem += "<td><input type='text' name='classify' placeholder='Classify'/></td>";
		rowItem += "<td><input type='text' name='debtor' placeholder='Debtor'/></td>";
		rowItem += "<td><input type='text' name='creditor' placeholder='Creditor'/></td>";
		rowItem += "<td><input type='text' name='abs' placeholder='ABS'/></td>";
		rowItem += "<td></td>";
		rowItem += "<td><a href='javascript:removeRow(" + fixedrows + ");'>X</a></td>";
		rowItem += "</tr>";
		
		$("#statement").append(rowItem);
	}
	
	$("newrows").val(newrows);

	// Init exist classify display
	for(var i = 0; i < existrows; i++) {
		if($("#state" + i).find("input[name=classify]").val() == "cred") {
			$("#state" + i).find("input[name=debtor]").css("display", "none");
		} else {
			$("#state" + i).find("input[name=creditor]").css("display", "none");
		}
	}

	// new classify display
	$("#statement tbody tr td input[name=classify]").on("blur", function(event) {
		var row = $(event.target.parentElement.parentElement);
		
		if($(event.target).val() == "deb"){
			$(row).find("input[name=debtor]").css("display", "block");
			$(row).find("input[name=creditor]").children("input").val("0");
			$(row).find("input[name=creditor]").css("display", "none");
		} else if($(event.target).val() == "cred") {
			$(row).find("input[name=debtor]").children("input").val("0");
			$(row).find("input[name=debtor]").css("display", "none");
			$(row).find("input[name=creditor]").css("display", "block");
		}
	});

	// changerow
	$("#statement tbody tr").one("change", function(event) {
		var row = $(event.target.parentElement.parentElement)[0];
		$("#changeRow").val($("#changeRow").val() + row.id.substring(5) + ",");
		
		row.classList.add("statementchanged");
		
		$("#saveBtn").css("display", "inline-block");
		$("#resetBtn").css("display", "inline-block");
	});
	
});

// Reset Button
function resetStatement() {
	if( !confirm("Reset Statement?")) {
		return true;
	}
	
	$("#statement tbody tr").removeClass("statementchanged");
	$("#statement tbody tr").removeClass("statementdelete");
	
	$("#statement tbody tr").find("input").attr("readonly", false);
	$("#statement tbody tr").find("a").css("display", "block");
	
	$("#saveBtn").css("display", "none");
	$("#resetBtn").css("display", "none");
	
	return true;
}

// Remove Row
function removeRow(row) {
	if(confirm("Delete state?")) {
		
		$("#state" + row).removeClass("statementchanged");
		$("#state" + row).addClass("statementdelete");
		$("#state" + row).find("input").attr("readonly", true);
		$("#state" + row).find("a").css("display", "none");
		
		$("#saveBtn").css("display", "inline-block");
		$("#resetBtn").css("display", "inline-block");
		
		// 重複防止
		var changerow = $("#changeRow").val().split(",");
		
		for(var i = 0; i < changerow.length - 1; i++) {
			if(changerow[i] == row)
				return false;
		}
		
		$("#changeRow").val($("#changeRow").val() + row + ",");
	}
}

// Statement Save
// JSON - STATE / DATE/ ACCOUNT_CD / CUSTOMER_CD / CLASSIFY / DEBTOR / CREDITOR / ABS / SEQ(Delete, Update)
// TODO - Change Ajax to XMLRequest
function submitStatement() {
	
	var changerow = $("#changeRow").val().split(",");
	
	var statement = new Array();
	var today = new Date($("#year").val(), $("#month").val());
	var date = today.toISOString().substring(0, 7)
	
	for(var i = 0; i < changerow.length - 1; i++) {
		var row = new Object();
		
		if($("#state" + changerow[i]).hasClass("new statementchanged")) {
			row.state = "insert";
			
			if($("#state" + changerow[i]).find("input[name=date]").val() == ""
				|| $("#state" + changerow[i]).find("input[name=account_cd]").val() == ""
					|| $("#state" + changerow[i]).find("input[name=customer_cd]").val() == ""
						|| $("#state" + changerow[i]).find("input[name=classify]").val() == "") {
				alert("Check your data field!");
				return false;
			}
			
			row.date = date + "-" + $("#state" + changerow[i]).find("input[name=date]").val();
			row.account_cd = $("#state" + changerow[i]).find("input[name=account_cd]").val();
			row.customer_cd = $("#state" + changerow[i]).find("input[name=customer_cd]").val();
			row.classify = $("#state" + changerow[i]).find("input[name=classify]").val();
			row.debtor = $("#state" + changerow[i]).find("input[name=debtor]").val();
			row.creditor = $("#state" + changerow[i]).find("input[name=creditor]").val();
			row.abs = $("#state" + changerow[i]).find("input[name=abs]").val();

			if(row.debtor == "")
				row.debtor = "0";
			else
				row.creditor = "0";
			
			statement.push(row);
			
		} else if($("#state" + changerow[i]).hasClass("exist statementchanged")) {
			row.state = "update";
			
			if($("#state" + changerow[i]).find("input[name=date]").val() == ""
				|| $("#state" + changerow[i]).find("input[name=account_cd]").val() == ""
					|| $("#state" + changerow[i]).find("input[name=customer_cd]").val() == ""
						|| $("#state" + changerow[i]).find("input[name=classify]").val() == "") {
				alert("Check your data field!");
				return false;
			}
			
			row.seq = $("#state" + changerow[i]).find("input[name=seq]").val();
			
			row.date = date + "-" + $("#state" + changerow[i]).find("input[name=date]").val();
			row.account_cd = $("#state" + changerow[i]).find("input[name=account_cd]").val();
			row.customer_cd = $("#state" + changerow[i]).find("input[name=customer_cd]").val();
			row.classify = $("#state" + changerow[i]).find("input[name=classify]").val();
			row.debtor = $("#state" + changerow[i]).find("input[name=debtor]").val();
			row.creditor = $("#state" + changerow[i]).find("input[name=creditor]").val();
			row.abs = $("#state" + changerow[i]).find("input[name=abs]").val();

			if(row.debtor == "")
				row.debtor = "0";
			else
				row.creditor = "0";
			
			statement.push(row);
			
		} else if($("#state" + changerow[i]).hasClass("exist statementdelete")) {
			row.state = "delete";
			row.seq = $("#state" + changerow[i]).find("input[name=seq]").val();
			
			statement.push(row);
		} 
	}

	
	console.table(statement);
	
	if(statement.length == 0) {
		location.href="/account/ledger.do";
		return false;
	}
	
	var jsonState = JSON.stringify(statement);

	
	$.ajax({
		url : "/account/statementSave.do",
		contentType: "application/json; charset=SHIFT-JIS",
		method : "post",
		type : "json",
		data : jsonState,
		success : function() {
			alert("Save Success!");
			location.href="/account/ledger.do";
		}, error : function() {
			alert("Save Fail!");
		}
	});

}


function debug() {

}