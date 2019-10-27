<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<div id="div-gray" align="center">
			<div>
				<h1>Sign Up</h1>
			</div>
			<div>
				<h2>Create your Account</h2>
			</div>
			<div>
				<table>
					<tr>
						<td style="text-align:center">ID*</td>
						<td><input id="input-box" type="text" name="id"></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:center">Password*</td>
						<td><input id="input-box" type="password" name="password"></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:center">Confirm Password*</td>
						<td><input id="input-box" type="password" name="passwordconfirm"></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:center">E-mail*</td>
						<td><input id="input-box" type="text" name="email"></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:center">Name</td>
						<td><input id="input-box" type="text" name="name"></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:center">Phone</td>
						<td><input id="input-box" type="text" name="phone"></td>
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
						<td><input type="radio" name="companycode" value="exist" checked="checked" onclick="changeForm('exist');"></td>
						<td style="text-align:center">Existing Company Code*</td>
					</tr>
					<tr>
						<td><input type="radio" name="companycode" value="new" onclick="changeForm('new');"></td>
						<td style="text-align:center">Create New Company Code*</td>
					</tr>
				</table>
			</div>
			<div id="exist">
				<table>
					<tr>
						<td style="text-align:center">Company Code</td><td><input id="input-box" type="text" name="phone"></td>
					</tr>
				</table>
			</div>
			<div id="new" style="display:none">
				<table>
					<tr>
						<td style="text-align:right">Business license Code*</td><td><input id="input-box" type="text" name="reg_cd"></td>
					</tr>
					<tr>
						<td style="text-align:right">Company title</td><td><input id="input-box" type="text" name="title"></td>
					</tr>
					<tr>
						<td style="text-align:right">CEO Name</td><td><input id="input-box" type="text" name="ceo_name"></td>
					</tr>
					<tr>
						<td style="text-align:right">Fax</td><td><input id="input-box" type="text" name="fax"></td>
					</tr>
					<tr>
						<td style="text-align:right">Domain</td><td><input id="input-box" type="text" name="domain"></td>
					</tr>
				</table>
			</div>
			<div>
				<input id="button" type="button" onclick="submitSignForm();" value="Confirm">
				<input id="button" type="button" onclick="location.href='login.do'" value="Cancel">
			</div>
		</div>