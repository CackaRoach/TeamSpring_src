/**
 * 
 */
	$(window).load(function() {
		
		$("#id").blur(function() {
			
			var userId = $("#id").val();
			
			if(!useridCheck()) {
				return false;
			}
			
			$.ajax({
				url : "/kaikei/checkId.do?id=" + userId,
				type : "get",
				success : function(data) {					
					
					if (data == 1) {
						$("#id_error").text("Exist ID");
						$("#id_error").css("color", "red");
					} else {
						$("#id_error").text("Available ID");	
						$("#id_error").css("color", "green");
					}
				}, error : function() {
					console.log("Fail");
				}
			});
		});
	
		$("#company_cd").blur(function() {
			var company_cd = $('#company_cd').val();
			var state = $("input:radio[name=companyState]:checked").val();

			if(!companyCodeCheck()) {
				return false;
			}
			
			$.ajax({
				url : '/kaikei/checkCode.do?company_cd=' + company_cd,
				type : 'get',
				success : function(data) {					
					if(state == "new") {
						if (data == 1) {
							$("#code_error").text("Exist Code");
							$("#code_error").css("color", "red");
						} else {
							$("#code_error").text("Available Code");	
							$("#code_error").css("color", "green");
						}
					} else {
						if (data == 1) {
							$("#code_error").text("Exist Code");
							$("#code_error").css("color", "green");
						} else {
							$("#code_error").text("Unavailable Code");	
							$("#code_error").css("color", "red");
						}
					}
				}, error : function() {
					console.log("Fail");
				}
			});
		});
		
		
		
		$("#password").on("change keyup paste", function() {
			var password = $("#password").val();
			
			if(password.length < 5) {
				$("#pass_error").text("Password must be between 5 and 15 characters");
				$("#pass_error").css("color", "red");
			} else {
				$("#pass_error").text("");
			}
		});
		
		$("#passwordConfirm").on("change keyup paste", function() {
			var password = $("#password").val();
			
			if($("#passwordConfirm").val() == "")
				return false;
			
			if(password != $("#passwordConfirm").val()) {
				$("#passConf_error").text("Not Matched");
				$("#passConf_error").css("color", "red");
			} else {
				$("#passConf_error").text("");
			}
		});
	
	});
	
	
	function useridCheck() {
		var userId = $("#id").val();
		
		if(userId.length < 5) {
			$("#id_error").text("ID must be between 5 and 15 characters");
			$("#id_error").css("color", "red");
			return false;
		} else if(userId.match(/[^a-z0-9]/gi,'')) {
			$("#id_error").text("ID must be English - lowercase");
			$("#id_error").css("color", "red");
			return false;
		}

		return true;
	}

	function companyCodeCheck() {
		var company_cd = $("#company_cd").val();
		
		if(company_cd.length != 5 || company_cd.match(/[^0-9]/gi,'')) {
			$("#code_error").text("Code must be a 5 digit number");
			$("#code_error").css("color", "red");
			return false;
		}
		
		return true;
	}