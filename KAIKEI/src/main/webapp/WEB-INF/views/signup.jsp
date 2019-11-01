<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<div id="div-gray" align="center">
			<div>
				<h1>Sign Up</h1>
			</div>
			<form name="register" action="signupExe.do" method="post" onsubmit="return formCheck()">
				<div>
					<h2>Create your Account</h2>
				</div>
				<div>
					<table>
						<tr style="height:45px">
							<td style="text-align:center">ID<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" id="id" name="id"></td>
							<td style="width:100px"><span id="id_check" class="h6Font"></span></td>
						</tr>
						<tr>
							<td style="text-align:center">Password<span style="color:red">*</span></td>
							<td><input class="input-box" type="password" name="password"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:center">Confirm Password<span style="color:red">*</span></td>
							<td><input class="input-box" type="password" name="passwordconfirm"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:center">E-mail<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" name="email"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:center">Name</td>
							<td><input class="input-box" type="text" name="name"></td>
							<td></td>
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
							<td><input type="radio" name="companyState" value="exist" checked="checked" onclick="changeForm('exist');"></td>
							<td style="text-align:center">Existing Company Code<span style="color:red">*</span></td>
						</tr>
						<tr>
							<td><input type="radio" name="companyState" value="new" onclick="changeForm('new');"></td>
							<td style="text-align:center">Create New Company Code<span style="color:red">*</span></td>
						</tr>
					</table>
				</div>
				<div id="exist">
					<table>
						<tr>
							<td style="text-align:center">Company Code<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" id="company_cd" name="company_cd"></td>
							<td><h6 id="code_check"></h6></td>
						</tr>
					</table>
				</div>
				<div id="new" style="display:none">
					<table>
						<tr>
							<td style="text-align:right">Business license Code<span style="color:red">*</span></td>
							<td><input class="input-box" type="text" name="regist_cd"></td>
						</tr>
						<tr>
							<td style="text-align:right">Company title</td>
							<td><input class="input-box" type="text" name="title"></td>
						</tr>
						<tr>
							<td style="text-align:right">Phone</td>
							<td><input class="input-box" type="text" name="phone"></td>
						</tr>
						<tr>
							<td style="text-align:right">Fax</td>
							<td><input class="input-box" type="text" name="fax"></td>
						</tr>
						<tr>
							<td style="text-align:right">Domain</td>
							<td><input class="input-box" type="text" name="domain"></td>
						</tr>
					</table>
				</div>
				<div>
					<input class="button" type="submit" value="Confirm">
					<input class="button" type="button" onclick="location.href='login.do'" value="Cancel">
				</div>
			</form>
		</div>
    	<script>
			$(window).load(function(){
				$("#id").blur(function() {
					var userId = $('#id').val();
					$.ajax({
						url : '/kaikei/checkId.do?id=' + userId,
						type : 'get',
						success : function(data) {					
							
							if (data == 1) {
									$("#id_check").text("Exist ID");
									$("#id_check").css("color", "red");
								} else {
									$('#id_check').text("Available ID");	
									$("#id_check").css("color", "green");
								}
							}, error : function() {
									console.log("Fail");
							}
						});
					});

				$("#company_cd").blur(function() {
					var company_cd = $('#company_cd').val();
					$.ajax({
						url : '/kaikei/checkCode.do?company_cd=' + company_cd,
						type : 'get',
						success : function(data) {					
							
							if (data == 1) {
									$("#code_check").text("Exist Code");
									$("#code_check").css("color", "red");
								} else {
									$('#code_check').text("Available Code");	
									$("#code_check").css("color", "green");
								}
							}, error : function() {
									console.log("Fail");
							}
						});
					});
			});
		</script>