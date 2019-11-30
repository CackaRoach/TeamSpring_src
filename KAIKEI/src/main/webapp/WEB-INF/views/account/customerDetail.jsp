<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    <!-- TODO: Save Message Print -->
		<div>
		    <div style="padding:20px">
		        <span style="font-size: 2em;">Customer</span>
		    </div>
		    <div style="border:1px solid black; padding:15px; margin: 5px;">
		  		<form action="/account/customerModify.do" method="post">
		        <div>
		            <table style="text-align:center; padding:10px; margin:10px">
		                <tbody>
		                    <tr>
		                        <td>Customer</td>
		                        <td><input type="text" class="input-box" value="${customerVO.title}" name="title"></td>
		                    </tr>
		                    <tr>
		                        <td>Customer Code</td>
		                        <td style="height:54px"><input type="hidden" value="${customerVO.cus_cd}" name="cus_cd">${customerVO.cus_cd}</td>
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
		                </tbody>
		            </table>
		        </div>
		        <div style="margin:0% 0% 0% 80%">
		            <input type="submit" style="margin:5px" class="button" value="MODIFY" onclick="location.href='/account/customerModify.do?cus_cd=${customerVO.cus_cd}'"><br>
		            <input type="button" style="margin:5px" class="button" value="DELETE" onclick="isDelete();">		            
		            <input type="button" style="margin:5px" class="button" value="LIST" onclick="location.href='/account/customer.do'"><br>
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
				
				$("#title").blur(function() {

					if($("#title").val() == "")
						$("#title_error").css("display", "block");
					else
						$("#title_error").css("display", "none");
				});
				
			})
				
				
			function formCheck() {
				if($("#title").val() == "") {
					$("#title").focus();
					return false;
				}

				return true;
			}

		</script>