
$(window).load(function() {

	var existrows =  $("#existrows").val();
	
	// Init Row
	for(var i = 0; i < (30 - existrows); i++)
		addRow();
	
	// Init exist classify display
	for(var i = 0; i < existrows; i++) {
		if($(".exist").eq(i).children("td").eq(5).children("input").attr("value") == "cred") {
			$(".exist").eq(i).children("td").eq(6).children("input").css("display", "none");
		} else {
			$(".exist").eq(i).children("td").eq(7).children("input").css("display", "none");
		}
	}
	
	// Reset button
	$("#statement tbody").change(function() {
		$("#stateReset").css("display", "inline-block");
	});

	// new classify display
	$("#statement tbody tr td input[name=classify]").on("blur", function(event) {
		var row = $(event.target.parentElement.parentElement);
		if($(event.target).val() == "deb"){
			row.children("td").eq(6).children("input").css("display", "block");
			row.children("td").eq(7).children("input").css("display", "none");
			row.children("td").eq(7).children("input").val("0");
		} else if($(event.target).val() == "cred"){
			row.children("td").eq(6).children("input").css("display", "none");
			row.children("td").eq(6).children("input").val("0");
			row.children("td").eq(7).children("input").css("display", "block");
		}
	});

	// changerow color
	$("#statement tbody tr").one("change", function(event) {
		var row = $(event.target.parentElement.parentElement);
		$("#changerows").val($("#changerows").val() + row[0].id.substring(5) + ",");
		row[0].classList.add("statementchanged");
	});
	
});



function addRow() {
	var existrows =  $("#existrows").val();
	var newrows = $("#newrows").val();
	var fixedrows = Number(existrows) + Number(newrows);
	
	var today = new Date();
	var mm = today.getMonth() + 1;
	var yy = today.getFullYear();
	
	var rowItem = "";
	rowItem += "<tr id='state" + fixedrows + "' class='new'>";
	rowItem += "<td><input type='text' name='year' value='" + String(yy).substring(2) + "' placeholder='Y'/></td>";
	rowItem += "<td><input type='text' name='month' value='" + mm + "' placeholder='M'/></td>";
	rowItem += "<td><input type='text' name='date' placeholder='D'/></td>";
	rowItem += "<td><input type='text' name='account_cd' maxlength='4' placeholder='0000'/></td>";
	rowItem += "<td><input type='text' name='customer_cd' maxlength='5' placeholder='00000'/></td>";
	rowItem += "<td><input type='text' name='classify' placeholder='Classify'/></td>";
	rowItem += "<td><input type='text' name='debtor' placeholder='Debtor'/></td>";
	rowItem += "<td><input type='text' name='creditor' placeholder='Creditor'/></td>";
	rowItem += "<td><input type='text' name='abs' placeholder='ABS'/></td>";
	rowItem += "<td></td>";
	rowItem += "<td><a href='javascript:removerow(" + fixedrows + ");'>X</a></td>";
	rowItem += "</tr>";
		
	newrows++;
	$("#newrows").val(newrows);
	
	$("#statement").append(rowItem);
}

// Reset Button
function deleteBtn() {
	if( !confirm("Reset Statement?")) {
		return true;
	}
	
	$("#statement tbody tr").removeClass("statementchanged");
	$("#stateReset").css("display", "none");
	
	return true;
}

// Remove Row
// TODO: Existing, New state delete
function removerow(row) {
	if(confirm("Delete state?")) {
		$("#state" + row).remove();

	}
}

// Statement Save
// JSON - DATA / ACCOUNT_CD / CUSTOMER_CD / CLASSIFY / DEBTOR / CREDITOR / ABS / ISEXIST
function statementSubmit() {
	
	var changerow = $("#changerows").val().split(",");
	var changerowlength = changerow.length - 1;
	
	var statement = new Array();
	
	console.log(changerowlength);
	
	for(var i = 0; i < changerowlength; i++) {
		var row = new Object();
		
		if($("#state" + changerow[i]).children("td").eq(2).children("input").val() == "")
			continue;
		row.DATE = "20" + $("#state" + changerow[i]).children("td").eq(0).children("input").val();
		row.DATE += "-"
		row.DATE += $("#state" + changerow[i]).children("td").eq(1).children("input").val();
		row.DATE += "-"
		row.DATE += $("#state" + changerow[i]).children("td").eq(2).children("input").val();
		
		if($("#state" + changerow[i]).children("td").eq(3).children("input").val() == "")
			continue;
		row.ACCOUNT_CD = $("#state" + changerow[i]).children("td").eq(3).children("input").val();
		
		if($("#state" + changerow[i]).children("td").eq(4).children("input").val() == "")
			continue;
		row.CUSTOMER_CD = $("#state" + changerow[i]).children("td").eq(4).children("input").val();
		row.CLASSIFY = $("#state" + changerow[i]).children("td").eq(5).children("input").val();
		row.DEBTOR = $("#state" + changerow[i]).children("td").eq(6).children("input").val();
		row.CREDITOR = $("#state" + changerow[i]).children("td").eq(7).children("input").val();
		row.ABS = $("#state" + changerow[i]).children("td").eq(8).children("input").val();
		// TODO: ISEXIST
		
		statement.push(row);
	}

	if(statement.length == 0) {
		alert("input fail!");
		return false;
	}
	
	console.table(statement);
	
	var jsonState = JSON.stringify(statement);
	
	$.ajax({
		url : "/account/addStatement.do",
		method : "post",
		contentType: "application/json; charset=SHIFT-JIS",
		type : "json",
		data : jsonState,
		success : function() {
			console.log("Success");
		}, error : function() {
			console.log("Fail");
		}
	});
	
	location.href="/account/ledger.do";
}
