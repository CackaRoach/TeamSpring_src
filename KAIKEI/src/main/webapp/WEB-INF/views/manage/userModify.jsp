<!-- CompanyDetail Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${userInfo}" var="userInfo"></c:set>

<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function(){
			location.href = "/manage/userDelete.do?id=${userInfo.id}";
		});
	
		$("#cancelBtn").click(function(){
			location.href = "/manage/userDetail.do?id=${userInfo.id}";
		});

		$("#state-select_pos").change(function(){
			if('${userInfo.posit_cd}' != $("#state-select_pos").val()){
				var ch = confirm("There must be one CEO in a company.\n Would you like to hand over your seat to another CEO?");
				
				if(ch){
					/* location.href = "/manage/userDetail.do?id=${userInfo.id}"; */
					alert("");
				}else{
					$("#state-select_pos").val('${userInfo.posit_cd}').prop("selected", true);
				}
			}
		});

		default_val();
	});

	function default_val() {
		var id = '${userInfo.state_cd}';
		$("#state-select").val(id).prop("selected", true);

		var idpos = '${userInfo.posit_cd}';
		$("#state-select_pos").val(idpos).prop("selected", true);
	}
</script>

<div>
	<div>
		<h3>Manage - UserModify</h3>
	</div>

	<div style="margin: 5px">
		<div align="right">
			<button class="button" id="cancelBtn">Cancel</button>
		</div>

		<form action = "/manage/userModify.do" method = "POST">
		<table class="detail">
			<tbody>

				<tr>
					<td>ID</td>
					<td><input class="input-box" type="text" name = "id" value="${userInfo.id}" readonly></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input class="input-box" type="text" name = "name" value="${userInfo.name}" required></td>
				</tr>
				<tr>
					<td>Position (POS)</td>
					<td>
						<select class="button" id="state-select_pos" name = "posit_cd">
								<option value="POS002">President</option>
								<option value="POS003">Excutive</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>State (STT)</td>
					<td><select class="button" id="state-select" name = "state_cd">
								<option value="STT001">WORK</option>
								<option value="STT002">RETIRE</option>
								<option value="STT003">Extended leave</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input class="input-box" type="text" name = "email" value="${userInfo.email}"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input class="input-box" type="tel" name = "phone" value="${userInfo.phone}"></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><input class="input-box" type="text" value="${userInfo.company_name}" readonly style="display:none">
						${userInfo.company_name}
					</td>
				</tr>
				<tr>
					<td>Company Code</td>
					<td><input class="input-box" type="text" name = "company_cd" value="${userInfo.company_cd}"	readonly style="display:none">
						${userInfo.company_cd}
					</td>
				</tr>

			</tbody>
		</table>

		<div align="right">
				<input type="submit" id="modBtn" class="button" value="SAVE">
				<input type="button" id="deleteBtn" class="button" value= "DELETE" style="background-color: #ff0000;">
		</div>
		</form>
	</div>


</div>


