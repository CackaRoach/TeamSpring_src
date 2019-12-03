<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    <!-- TODO: Save Message Print -->
		<div>
		    <div style="padding:20px;">
		        <span style="font-size: 1.7em;">Customer</span>
		    </div>
		    <hr>
		    <div style="border:1px solid black; padding:15px; margin: 5px; width: 1100px;">
		  		<form id="customerForm" name="customerForm">
		        <div style="margin-bottom: 30px;">
		            <table class="cus-table">
		                <tbody>
		                    <tr>
		                        <td>Customer</td>
		                        <td>
			                        <input type="text" class="input-box" value="${customerVO.title}" name="title">
			                        <span id="title_error" class="h6error" style="color:red; display:none">Input Title!</span>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td>Customer Code</td>
		                        <td style="height:54px">${customerVO.cus_cd}<input type="hidden" value="${customerVO.cus_cd}" name="cus_cd"></td>
		                    </tr>
		                    <tr>
		                        <td>Business License Number</td>
		                        <td><input type="text" class="input-box" name="reg_cd" value='${customerVO.reg_cd}'></td>	                        
		                    </tr>
		                    <tr>
		                        <td>FAX</td>
		                        <td><input type="text" class="input-box" name="fax" value='${customerVO.fax}'></td>
		                    </tr>
		                    <tr>
		                        <td>Domain</td>
		                        <td><input type="text" class="input-box" name="domain" value='${customerVO.domain}'></td>
		                    </tr>
		                </tbody>
		            </table>
		            <table class="cus-table">
		            	<tbody>
		                    <tr>
		                       <td>CEO</td>
		                       <td><input type="text" class="input-box" name="ceo_name" value='${customerVO.ceo_name}'></td>
		                    </tr>
		                    <tr>
		                        <td>CEO E-mail</td>
		                        <td><input type="text" class="input-box" name="ceo_email" value='${customerVO.ceo_email}'></td>
		                    </tr>
		                    <tr>
		                        <td>Worker</td>
		                        <td><input type="text" class="input-box" name="worker_name" value='${customerVO.worker_name}'></td>		                        
		                    </tr>
		                    <tr>
		                        <td>Worker E-mail</td>
		                        <td><input type="text" class="input-box" name="worker_email" value='${customerVO.worker_email}'></td>
		                    </tr>
		                    <tr>
		                        <td>Memo</td>
			                    <td><textarea class="input-box" style="height:200px; resize:none;" name="memo">${customerVO.memo}</textarea></td>
		                    </tr>
		                </tbody>
		            </table>
		        </div>
		        <div align="right">
		            <input type="button" style="margin:5px; width:120px;" class="button" value="MODIFY" onclick="submitCustomer();">
		            <input type="button" style="margin:5px; width:120px;" class="button" value="LIST" onclick="location.href='/account/customer.do'">
		            <hr>
		            <input type="button" style="margin:5px; width:120px; background-color:red;" class="button" value="DELETE" onclick="isDelete();">
		        </div>
		        </form>
		    </div>
		</div>
		<script>
			function isDelete() {
				if(confirm("Delete ${customerVO.title}?")) {
					location.href='/account/customerDelete.do?cus_cd=${customerVO.cus_cd}';
					return true;
				}

				return false;
			}

			$(window).load(function() {
				
				$("input[name=title]").blur(function() {

					if($("input[name=title]").val() == "")
						$("#title_error").css("display", "block");
					else
						$("#title_error").css("display", "none");
				});
				
			})
			
			
			function submitCustomer() {
				if($("input[name=title]").val() == "") {
					$("input[name=title]").focus();
					return false;
				}
				
				var queryString = $("#customerForm").serialize();

				$.ajax({
					method: "post",
					url: "/account/customerModify.ajax",
					data: queryString,
					type: "json",
					error: function() {
						alert("Save Fail!");
					},
					success: function() {
						alert("Save Success!");
					}
				});
			}

		</script>