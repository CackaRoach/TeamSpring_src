
$(window).ready(function() {

	var existrows =  $("#existrows").val();
	var newrows = 0;
	
	var today = new Date($("#year").val(), $("#month").val() - 1);
	var yy = String(today.getFullYear()).substring(2);
	var mm = today.getMonth() + 1;

	if(window.location.href.indexOf("?") < 0 || window.location.href.indexOf("?pagenum=0") > 0) {
	// Init Row
		for(newrows = 0; newrows < (30 - existrows); newrows++) {
			
			
			var fixedrows = Number(existrows) + Number(newrows);
			
			var rowItem = "";
			rowItem += "<tr id='state" + fixedrows + "' class='new'>";
			rowItem += "<td><input type='text' name='year' value='" + yy +"' maxlength='2' placeholder='Y'/></td>";
			rowItem += "<td><input type='text' name='month' value='" + mm +"' maxlength='2' placeholder='M'/></td>";
			rowItem += "<td><input type='text' name='date' maxlength='2' placeholder='D'/></td>";
			rowItem += "<td><input type='text' name='acc_title' placeholder='Title'/><label class='account_cd'></label></td>";
			rowItem += "<td><input type='text' name='cus_title' placeholder='Customer'/><label class='customer_cd'></label></td>";
			rowItem += "<td><input type='text' name='classify' placeholder='Classify'/></td>";
			rowItem += "<td><input type='text' name='debtor' placeholder='Debtor'/></td>";
			rowItem += "<td><input type='text' name='creditor' placeholder='Creditor'/></td>";
			rowItem += "<td><input type='text' name='abs' placeholder='ABS'/></td>";
			rowItem += "<td></td>";
			rowItem += "<td><a href='javascript:removeRow(" + fixedrows + ");'>X</a></td>";
			rowItem += "</tr>";
			
			$("#statement").append(rowItem);
		}
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

		if($(event.target).val().toUpperCase() == "D"){
			$(row).find("input[name=classify]").val("deb");
			$(row).find("input[name=debtor]").css("display", "block");
			$(row).find("input[name=creditor]").val("0");
			$(row).find("input[name=creditor]").css("display", "none");
		} else if($(event.target).val().toUpperCase() == "C") {
			$(row).find("input[name=classify]").val("cred");
			$(row).find("input[name=debtor]").val("0");
			$(row).find("input[name=debtor]").css("display", "none");
			$(row).find("input[name=creditor]").css("display", "block");
		}
	});
	
	var elemNum = -1;
	var elemMax = -1;
	var preInput = null;
	var timer;
	
	// autocomplete - window
	// account
	$("#statement>tbody>tr>td>input[name=acc_title]").on("focus", function(event) {
		var row = $(event.target.parentElement);
		
		preInput = $(event.target).val();
		
		$("#autocompleteList").css("display", "none");
		$("#account-list li").remove();		
		
		// border 1px
		$("#autocompleteList").css("left", row.offset().left + 1);
		// row 28px + border 1px
		$("#autocompleteList").css("top", row.offset().top + 29);
	});
	
	// customer
	$("#statement tbody tr td input[name=cus_title]").on("focus", function(event) {
		var row = $(event.target.parentElement);
		
		preInput = $(event.target).val();
		
		$("#autocompleteList").css("display", "none");
		$("#account-list li").remove();		
		
		$("#autocompleteList").css("left", row.offset().left + 1);
		$("#autocompleteList").css("top", row.offset().top + 29);
	});
	
	// autocomplete - implement
	// account
	$("#statement tbody tr td input[name=acc_title]").on("change keyup paste", function(event) {
		var row = $(event.target.parentElement.parentElement);
		var input = $(event.target).val();
		
		if(event.keyCode == undefined) {
			return;
		}
		else if(event.keyCode == 27) {
			$("#autocompleteList").css("display", "none");
			$("#autocomplete-ul li").remove();
			return;
		}
		// Enter
		else if(event.keyCode == 13) {
			
			$("#autocompleteList").css("display", "none");
			$("#autocomplete-ul li").remove();
			row.find("input[name=cus_title]").focus();
			return;
		}
		// UP
		else if(event.keyCode == 38) {
			
			if(elemNum <= 0)
				return;
			
			elemNum--;

			$("#autocomplete-ul li:eq(" + ((elemNum + 1) * 3) + ")").css("background-color", "");
			$("#autocomplete-ul li:eq(" + (elemNum * 3) + ")").css("background-color", "#91c8ff");
			
			$(event.target).val($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 1) + ")").text());
			$(event.target.parentElement.parentElement).find("label[class=account_cd]").text($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 2) + ")").text());
			return;
		} 
		// Down
		else if(event.keyCode == 40) {
			
			if(elemNum >= elemMax - 1)
				return;
			
			elemNum++;
			
			if(elemNum != 0)
				$("#autocomplete-ul li:eq(" + ((elemNum - 1) * 3) + ")").css("background-color", "");
			$("#autocomplete-ul li:eq(" + (elemNum * 3) + ")").css("background-color", "#91c8ff");
			
			$(event.target).val($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 1) + ")").text());
			$(event.target.parentElement.parentElement).find("label[class=account_cd]").text($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 2) + ")").text());
			return;
		}
		
		if(preInput == input) {
			
		} else {
			preInput = input;
			
			if(input.length == 0) {
				$("#autocompleteList").css("display", "none");
				$("#autocomplete-ul li").remove();
				return false;
			}
		
			// debouncing
			if (timer) {
				clearTimeout(timer);
			}
			
			timer = setTimeout(function() {
				$("#autocomplete-ul li").remove();
				
				$.ajax({
					url : "/account/getAccountTitle.ajax?title=" + input,
					method : "get",
					success : function(data) {
						$("#autocompleteList").css("display", "block");
						elemMax = data.length;
						for(var i = 0; i < data.length; i++) {
							$("#autocomplete-ul").append("<li><a href='javascript:setAcc(\"" + row[0].id + "\", \"" + data[i].title + "\", \"" + data[i].acc_cd + "\");'>"
									+ data[i].title + " - " + data[i].acc_cd + "</a></li>");
							$("#autocomplete-ul").append("<li style='display:none'>" + data[i].title + "</li>");
							$("#autocomplete-ul").append("<li style='display:none'>" + data[i].acc_cd + "</li>");
							debounce = true;
						}
					}, error : function() {
						console.log("Connection Fail!");
						debounce = true;
					}
				});
			}, 250);
		}
	});
	
	// customer
	$("#statement tbody tr td input[name=cus_title]").on("change keyup paste", function(event) {
		var row = $(event.target.parentElement.parentElement);
		var input = $(event.target).val();

		if(event.keyCode == undefined) {
			return;
		}
		else if(event.keyCode == 27) {
			$("#autocompleteList").css("display", "none");
			$("#autocomplete-ul li").remove();
			return;
		}
		// Enter
		else if(event.keyCode == 13) {
			
			$("#autocompleteList").css("display", "none");
			$("#autocomplete-ul li").remove();
			row.find("input[name=classify]").focus();
			return;
		}
		// UP
		else if(event.keyCode == 38) {
			
			if(elemNum <= 0)
				return;
			
			elemNum--;

			$("#autocomplete-ul li:eq(" + ((elemNum + 1) * 3) + ")").css("background-color", "");
			$("#autocomplete-ul li:eq(" + (elemNum * 3) + ")").css("background-color", "#91c8ff");
			
			$(event.target).val($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 1) + ")").text());
			$(event.target.parentElement.parentElement).find("label[class=customer_cd]").text($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 2) + ")").text());
			return;
		} 
		// Down
		else if(event.keyCode == 40) {
			
			if(elemNum >= elemMax - 1)
				return;
			
			elemNum++;
			
			if(elemNum != 0)
				$("#autocomplete-ul li:eq(" + ((elemNum - 1) * 3) + ")").css("background-color", "");
			$("#autocomplete-ul li:eq(" + (elemNum * 3) + ")").css("background-color", "#91c8ff");
			
			$(event.target).val($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 1) + ")").text());
			$(event.target.parentElement.parentElement).find("label[class=customer_cd]").text($("#autocomplete-ul li:eq(" + ((elemNum * 3) + 2) + ")").text());
			return;
		} 
		
		if(preInput == input) {
			
		} else {
			preInput = input;

			if(input.length == 0) {
				$("#autocompleteList").css("display", "none");
				$("#autocomplete-ul li").remove();
				return false;
			}
			
			// debouncing
			if (timer) {
				clearTimeout(timer);
			}
			
			timer = setTimeout(function() {
				$("#autocomplete-ul li").remove();
				
				$.ajax({
					url : "/account/getCustomerTitle.ajax?title=" + input,
					method : "get",
					success : function(data) {
						$("#autocompleteList").css("display", "block");
						elemMax = data.length;
						for(var i = 0; i < data.length; i++) {
							$("#autocomplete-ul").append("<li><a href='javascript:setCus(\"" + row[0].id + "\", \"" + data[i].title + "\", \"" + data[i].cus_cd + "\");'>"
									+ data[i].title + " - " + data[i].cus_cd + "</a></li>");
							$("#autocomplete-ul").append("<li style='display:none'>" + data[i].title + "</li>");
							$("#autocomplete-ul").append("<li style='display:none'>" + data[i].cus_cd + "</li>");
						}
					}, error : function() {
						console.log("Connection Fail!");
					}
				});
			}, 250);
		}
	});
	
	// autocomplete
	// account
	$("#statement tbody tr td input[name=acc_title]").on("blur", function(event) {
		elemNum = -1;
		elemMax = -1;
		preInput = null;
		
		setTimeout(function() {
			$("#autocompleteList").css("display", "none");
			$("#account-list li").remove();			
		}, 210);

	});
	
	// customer
	$("#statement tbody tr td input[name=cus_title]").on("blur", function(event) {
		elemNum = -1;
		elemMax = -1;
		preInput = null;

		setTimeout(function() {
			$("#autocompleteList").css("display", "none");
			$("#account-list li").remove();			
		}, 210);
	});

	
	// changerow
	$("#statement tbody tr").one("change", function(event) {
		var row = $(event.target.parentElement.parentElement)[0];
		$("#changeRow").val($("#changeRow").val() + row.id.substring(5) + ",");
		
		row.classList.add("statementchanged");
		
		$("#saveBtn").css("display", "inline-block");
	});
});

// AutoComplete - mouse
// Account
function setAcc(rowid, title, cd) {
	$("#" + rowid).find("label[class=account_cd]").text(cd);
	$("#" + rowid).find("input[name=acc_title]").val(title);
}

// customer
function setCus(rowid, title, cd) {
	$("#" + rowid).find("label[class=customer_cd]").text(cd);
	$("#" + rowid).find("input[name=cus_title]").val(title);
}

// Remove Row
function removeRow(row) {
	if(confirm("Delete state?")) {
		
		$("#state" + row).removeClass("statementchanged");
		$("#state" + row).addClass("statementdelete");
		$("#state" + row).find("input").attr("readonly", true);
		$("#state" + row).find("a").css("display", "none");
		
		$("#saveBtn").css("display", "inline-block");
		
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
function submitStatement() {
	
	var changerows = $("#changeRow").val().split(",");
	var statement = new Array();

	for(var i = 0; i < changerows.length - 1; i++) {
		var row = new Object();
		var changerow = $("#state" + changerows[i]);
		
		//DELETE
		if(changerow.hasClass("exist statementdelete")) {
			row.state = "delete";
			row.seq = changerow.find("input[name=seq]").val();
			
			statement.push(row);
		
		// INSERT, UPDATE
		} else {
			
			if(changerow.find("input[name=year]").val() == ""
				||	changerow.find("input[name=month]").val() == ""
					|| changerow.find("input[name=date]").val() == ""
						|| changerow.find("label[class=account_cd]").text() == ""
							|| changerow.find("label[class=customer_cd]").text() == ""
								|| changerow.find("input[name=classify]").val() == "") {
				alert("Check your data field!");
				return false;
			}
			
			row.date = "20";
			row.date += changerow.find("input[name=year]").val() + "-";
			row.date += changerow.find("input[name=month]").val()  + "-";
			row.date += changerow.find("input[name=date]").val();
			
			row.account_cd = changerow.find("label[class=account_cd]").text();
			row.customer_cd = changerow.find("label[class=customer_cd]").text();
			row.classify = changerow.find("input[name=classify]").val();
			row.debtor = changerow.find("input[name=debtor]").val();
			row.creditor = changerow.find("input[name=creditor]").val();
			row.abs = changerow.find("input[name=abs]").val();
			
			// INSERT
			if(changerow.hasClass("new statementchanged")) {
				row.state = "insert";
				
			// UPDATE
			} else {
				row.state = "update";
				row.seq = changerow.find("input[name=seq]").val();
			}
			
			statement.push(row);
		}
	}

	if(statement.length == 0) {
		location.href="/account/ledger.do";
		return false;
	}

	var jsonState = JSON.stringify(statement);
	
	$.ajax({
		url : "/account/statementSave.ajax",
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

