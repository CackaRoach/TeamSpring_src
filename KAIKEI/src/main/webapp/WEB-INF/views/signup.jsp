<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/kaikei/css/layout.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/kaikei/js/signup.js" ></script>
<script>

	function changeForm(form) {
		if(form == "exist") {
			$("#code_error").text("");
			document.getElementById("new").style.display = "none";
		} else {
			$("#code_error").text("");
			document.getElementById("new").style.display = "block";
		}
	}

	function formCheck() {
		
		if($("#id_error").html() != "Available ID") {
			$("#id").focus();
			return false;
		}

		if($("#password").val() != $("#passwordConfirm").val()) {
			$("#password").focus();
			return false;
		}

		if($("#email").val() == "") {
			$("#email").focus();
			return false;
		}

		if($("#code_error").css("color") != "rgb(0, 128, 0)") {
			$("#company_cd").focus();
			return false;
		}
		
		$("#register").submit();
	}
	
	
</script>
<body>
    <div id="header">
    	<div align="center">
			<h1>KAIKEI</h1>
		</div>
    </div>
    	<div id="section-only">
        	<div id="div-gray" align="center">
			<div>
				<h1>Sign Up</h1>
			</div>
			<form id="register" name="register" action="signupExe.do" method="post">
				<div>
					<h2>Create your Account</h2>
				</div>
				<div>
					<table>
						<tr>
							<td style="text-align:center">ID<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" id="id" name="id" maxlength="15"></td>
						</tr>
						<tr>
							<td></td>
							<td style="width:100px; text-align:center"><span id="id_error" class="h6error"></span></td>
						</tr>
						<tr>
							<td style="text-align:center">Password<span style="color:red">*</span></td>
							<td><input class="input-box" type="password" id="password" name="password"></td>
						</tr>
						<tr>
							<td></td>
							<td style="width:100px; text-align:center"><span id="pass_error" class="h6error"></span></td>
						</tr>
						<tr>
							<td style="text-align:center">Confirm Password<span style="color:red">*</span></td>
							<td><input class="input-box" type="password" id="passwordConfirm" name="passwordConfirm"></td>
						</tr>
						<tr>
							<td></td>
							<td style="width:100px; text-align:center"><span id="passConf_error" class="h6error"></span></td>
						</tr>
						<tr>
							<td style="text-align:center">E-mail<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" id="email" name="email"></td>
						</tr>
						<tr>
							<td style="text-align:center">Name</td>
							<td><input class="input-box" type="text" name="name"></td>
						</tr>
						<tr>
							<td style="text-align:center">Phone</td>
							<td><input class="input-box" type="text" name="phone"></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div>
					<h2>Company</h2>
				</div>
				<div>
					<table>
						<tr>
							<td><input type="radio" class="companyState" name="companyState" value="exist" checked="checked" onclick="changeForm('exist');"></td>
							<td style="text-align:center">Existing Company Code<span style="color:red">*</span></td>
						</tr>
						<tr>
							<td><input type="radio" class="companyState" name="companyState" value="new" onclick="changeForm('new');"></td>
							<td style="text-align:center">Create New Company Code<span style="color:red">*</span></td>
						</tr>
					</table>
				</div>
				<div id="exist">
					<table>
						<tr>
							<td style="text-align:center">Company Code<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" id="company_cd" name="company_cd"></td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align:center"><span id="code_error" class="h6error"></span></td>
						</tr>
					</table>
				</div>
				<div id="new" style="display:none">
					<table>
						<tr>
							<td style="text-align:right">Company title</td>
							<td><input class="input-box" type="text" name="company_title"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Business license</td>
							<td><input class="input-box" type="text" name="company_regist_cd"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Phone</td>
							<td><input class="input-box" type="text" name="company_phone"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Fax</td>
							<td><input class="input-box" type="text" name="company_fax"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Domain</td>
							<td><input class="input-box" type="text" name="company_domain"></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div>
					<input class="button" type="button" value="Confirm" onclick="formCheck();">
					<input class="button" type="button" onclick="location.href='login.do'" value="Cancel">
				</div>
			</form>
		</div>
    </div>    
    <div id="footer">
    	<div>
			<h6>footer</h6>
		</div>
   	</div>    
</body>
</html>