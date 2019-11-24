
$(window).load(function() {
	
	$(function() {
		
		for(var i = 0; i < 20; i++)
			addRow();
		
		for(var i = 0; i < 50; i++) {
			if($("#exist" + i).length == 1) {
				if($("#exist" + i).children("td").eq(5).children("input").attr("value") == "cred") {
					$("#exist" + i).children("td").eq(6).children("input").css("display", "none");
				} else {
					$("#exist" + i).children("td").eq(7).children("input").css("display", "none");
				}
			} else {
				break;
			}
		}
	});
	
	$("#statement tbody").change(function() {
		$("#stateReset").css("display", "inline-block");
	});
	
	
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
	
});


function addRow() {
	
	var rowItem = "";
	
	var maxrow = $("input#newrows").val();
	maxrow++;
	
	$("input#newrows").val(maxrow);
	
	var today = new Date();
	var mm = today.getMonth() + 1;
	var yy = today.getFullYear();
	
	rowItem += "<tr id='new" + maxrow + "' class='new'>";
	rowItem += "<td><input type='text' name='year' value='" + String(yy).substring(2) + "' placeholder='Year'/></td>";
	rowItem += "<td><input type='text' name='month' value='" + mm + "' placeholder='Month'/></td>";
	rowItem += "<td><input type='text' name='date' placeholder='Date'/></td>";
	rowItem += "<td><input type='text' name='account_cd' placeholder='Account'/></td>";
	rowItem += "<td><input type='text' name='customer_cd' placeholder='Customer'/></td>";
	rowItem += "<td><input type='text' name='classify' placeholder='Classify'/></td>";
	rowItem += "<td><input type='text' name='debtor' placeholder='Debtor'/></td>";
	rowItem += "<td><input type='text' name='creditor' placeholder='Creditor'/></td>";
	rowItem += "<td><input type='text' name='abs' placeholder='ABS'/></td>";
	rowItem += "<td><a href='javascript:removerow(" + maxrow + ");'>X</a></td>";
	rowItem += "</tr>";
		
	$("#statement").append(rowItem);
}

function deleteBtn() {
	if(confirm("are you sure?")) {
		$("#stateReset").css("display", "none");
		return true;
	}
	return false;
}

function removerow(rows) {
	if(confirm("delete line?")) {
		$("#new" + rows).remove();
		var sort = 0;
		var maxrow = $("input#newrows").val();
		
		for(var i = 0; i <= maxrow; i++) {
			if($("#new" + i).length == 1) {
				$("#new" + i).children("td").eq(9).children("a").attr("href", "javascript:removerow(" + sort + ");");
				$("#new" + i).attr("id", "new" + sort);
				sort++;
			}
		}
		
		var row = $("input#newrows").val();
		row--;
		
		$("input#newrows").val(row);
	}
}

function statementSubmit() {
	var newrows = $("input#newrows").val();
	
	var statement = new Array();
	
	for(var i = 0; i < newrows; i++) {
		var row = new Object();
		
		if($("#new" + i).children("td").eq(2).children("input").val() == "")
			continue;
		row.DATE = "20" + $("#new" + i).children("td").eq(0).children("input").val();
		row.DATE += "-"
		row.DATE += $("#new" + i).children("td").eq(1).children("input").val();
		row.DATE += "-"
		row.DATE += $("#new" + i).children("td").eq(2).children("input").val();
		
		if($("#new" + i).children("td").eq(3).children("input").val() == "")
			continue;
		row.ACCOUNT_CD = $("#new" + i).children("td").eq(3).children("input").val();
		
		if($("#new" + i).children("td").eq(4).children("input").val() == "")
			continue;
		row.CUSTOMER_CD = $("#new" + i).children("td").eq(4).children("input").val();
		row.CLASSIFY = $("#new" + i).children("td").eq(5).children("input").val();
		row.DEBTOR = $("#new" + i).children("td").eq(6).children("input").val();
		row.CREDITOR = $("#new" + i).children("td").eq(7).children("input").val();
		row.ABS = $("#new" + i).children("td").eq(8).children("input").val();
		
		statement.push(row);
	}
	
	console.log(statement);
	
	if(statement.length == 0) {
		alert("input fail!");
		return false;
	}
	
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

function debuging() {
	console.log();
}