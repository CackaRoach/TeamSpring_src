<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/css/layout.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/js/signup.js" ></script>
<script>

	function changeForm(form) {
		if(form == "exist") {
			$("#code_error").text("");
			$("#new").css("display", "none");
		} else {
			$("#code_error").text("");
			$("#new").css("display", "block");
		}
	}

	function formCheck() {

		// TODO : Change to Uncheck String
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

		// TODO : Change to Unckeck Color
		if($("#code_error").css("color") != "rgb(0, 128, 0)") {
			$("#company_cd").focus();
			return false;
		}
		
	}
	
</script>
<body>
	<div align="center" style="padding:10px 0px; background-color:#1591ff;">
		<span style="font-size:2em">Sign Up</span>
	</div>
	<form id="register" name="register" action="/signupExc.do" method="post">
	<div>
		<div align="center" style="padding: 10px 30px;">
			<span style="font-size:1.5em">Account</span>
		</div>
		<div align="center" style="background-color: white;">
			<table>
				<tbody>
					<tr>
						<td style="text-align:center">ID<span style="color:red">*</span></td>
						<td><input class="input-box" type="text" id="id" name="id" maxlength="15"></td>
					</tr>
					<tr>
						<td style="padding:0px;"></td>
						<td style="padding:0px; text-align:center"><span id="id_error" class="h6error"></span></td>
					</tr>
					<tr>
						<td style="text-align:center">Password<span style="color:red">*</span></td>
						<td><input class="input-box" type="password" id="password" name="password" maxlength="15"></td>
					</tr>
					<tr>
						<td style="padding:0px;"></td>
						<td style="padding:0px; text-align:center"><span id="pass_error" class="h6error"></span></td>
					</tr>
					<tr>
						<td style="text-align:center">Confirm Password<span style="color:red">*</span></td>
						<td><input class="input-box" type="password" id="passwordConfirm" name="passwordConfirm" maxlength="15"></td>
					</tr>
					<tr>
						<td style="padding:0px;"></td>
						<td style="padding:0px; text-align:center"><span id="passConf_error" class="h6error"></span></td>
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
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div style="background-color: white;">
		<div align="center" style="padding: 10px 30px;">
			<span style="font-size:1.5em">Company</span>
		</div>
		<div align="center" style="padding: 5px 60px;">
			<input type="radio" class="companyState" name="companyState" value="exist" checked="checked" onclick="changeForm('exist');">
			Existing Company Code<span style="color:red">*</span>
			<br><br>
			<input type="radio" class="companyState" name="companyState" value="new" onclick="changeForm('new');">
			Create New Company Code<span style="color:red">*</span>
		</div>
		<div style="padding: 20px;" align="center">
			<table>
				<tr>
					<td style="text-align:center">Company Code<span style="color:red">*</span></td>
					<td><input class="input-box" type="text" id="company_cd" name="company_cd"></td>
				</tr>
				<tr>
					<td style="padding:0px;"></td>
					<td style="padding:0px; text-align:center"><span id="code_error" class="h6error"></span></td>
				</tr>
			</table>
			<div id="new" style="display:none">
				<table>
					<tr>
						<td style="text-align:right">Company title</td>
						<td><input class="input-box" type="text" name="company_title"></td>
					</tr>
					<tr>
						<td style="text-align:right">Business license</td>
						<td><input class="input-box" type="text" name="company_regist_cd"></td>
					</tr>
					<tr>
						<td style="text-align:right">Phone</td>
						<td><input class="input-box" type="text" name="company_phone"></td>
					</tr>
					<tr>
						<td style="text-align:right">Fax</td>
						<td><input class="input-box" type="text" name="company_fax"></td>
					</tr>
					<tr>
						<td style="text-align:right">Domain</td>
						<td><input class="input-box" type="text" name="company_domain"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div style="background-color: white; padding:10px 0px;" align="center">
		<input class="button" type="submit" value="Confirm" onclick="return formCheck();">
		<input class="button" type="button" onclick="location.href='/login.do'" value="Cancel">
	</div>
	</form>
    <div id="footer">
    	<div>
			<h6>footer</h6>
		</div>
   	</div>    
</body>
</html>