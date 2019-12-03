<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
		    <div style="padding:20px">
		        <span style="font-size: 1.7em;">Customer</span>
		    </div>
		    <hr>
		    <form action="/account/customerAddExc.do" method="post">
		    	<div style="border:1px solid black; padding:30px; margin:5px; width: 1100px;">
		    		<div>
			            <table class="cus-table">
			                <tbody>
			                    <tr>
			                        <td>Customer<span style="color:red">*</span></td>
			                        <td><input type="text" class="input-box" id="title" name="title"></td>
			                    </tr>
			                    <tr>
			                        <td></td>
			                        <td style="text-align:center"><span id="title_error" class="h6error" style="color:red; display:none"></span></td>
			                    </tr>
			                    <tr>
			                        <td>Customer Code<span style="color:red">*</span></td>
			                        <td><input type="text" class="input-box" id="cus_cd" name="cus_cd"></td>
			                    </tr>
			                    <tr>
			                        <td></td>
			                        <td style="text-align:center"><span id="cus_cd_error" class="h6error" style="color:red; display:none">Input Code</span></td>
			                    </tr>
			                    <tr>
			                        <td>Business License Number</td>
			                        <td><input type="text" class="input-box" name="reg_cd"></td>
			                    </tr>
			                    <tr>
			                        <td>FAX</td>
			                        <td><input type="text" class="input-box" name="fax"></td>
			                    </tr>
			                    <tr>
			                        <td>Domain</td>
			                        <td><input type="text" class="input-box" name="domain"></td>
			                    </tr>
			                </tbody>
			            </table>
			            <table class="cus-table">
			            	<tbody>
			                    <tr>
			                        <td>CEO</td>
			                        <td><input type="text" class="input-box" name="ceo_name"></td>
			                    </tr>
			                    <tr>
			                        <td>CEO Email</td>
			                        <td><input type="text" class="input-box" name="ceo_email"></td>
			                    </tr>
			                    <tr>
			                        <td>Worker</td>
			                        <td><input type="text" class="input-box" name="worker_name"></td>
			                    </tr>
			                    <tr>
			                        <td>Worker Email</td>
			                        <td><input type="text" class="input-box" name="worker_email"></td>
			                    </tr>
			                    <tr>
			                        <td>Memo</td>
			                        <td><textarea class="input-box" style="height:200px; resize:none;" name="memo"/></textarea></td>
			                    </tr>
			          		</tbody>
			        	</table>
		         	</div>
		         	<div align="right" style="margin-top: 60px;">
			            <input type="submit" style="margin:3px" class="button" value="ADD" onclick="return formCheck();">
			            <input type="button" style="margin:3px" class="button" value="CANCEL" onclick="location.href='/account/customer.do'">
			        </div>
	         	</div>
		    </form>
		</div>
		<script>
		
		$(window).load(function() {
			
			$("#title").blur(function() {

				if($("#title").val() == "") {
					$("#title_error").text("Input Title");
					$("#title_error").css("display", "block");
				} else {
					$("#title_error").css("display", "none");
				}
			});

			$("#cus_cd").blur(function() {
				var cus_cd = $("#cus_cd").val();
				
				if(cus_cd.match(/\D/) || cus_cd.length != 5) {
					$("#cus_cd_error").text("Code must 5 Number");
					$("#cus_cd_error").css("display", "block");
					return false;
				} else {
					$("#cus_cd_error").css("display", "none");
				}

				$.ajax({
					url : "/account/customerCodeCheck.ajax?cus_cd=" + $("#cus_cd").val(),
					type : "get",
					success : function(data) {					
						console.log(data);
						if (data == 1) {
							$("#cus_cd_error").text("Exist CODE");
							$("#cus_cd_error").css("color", "red");
							$("#cus_cd_error").css("display", "block");
						} else {
							$("#cus_cd_error").text("Available CODE");	
							$("#cus_cd_error").css("color", "green");
							$("#cus_cd_error").css("display", "block");
						}
					}, error : function() {
						console.log("Fail");
					}
				});
			});
			
		})
			
		
			
		function formCheck() {
			if($("#title").val() == "") {
				$("#title").focus();
				return false;
			}

			if($("#cus_cd_error").css("color") != "rgb(0, 128, 0)") {
				$("#cus_cd").focus();
				return false;
			}

			return true;
		}

		</script>