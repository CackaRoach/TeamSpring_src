<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
		    <div style="padding:20px">
		        <span style="font-size: 2em;">Customer</span>
		    </div>
		    <div style="border:1px solid black; padding:15px; margin: 5px;">
		  		<form action="" method="post">
		        <div>
		            <table style="text-align:center; padding:10px; margin:10px">
		                <tbody>
		                    <tr>
		                        <td>Customer</td>
		                        <td style="height:54px">${customerVO.title}</td>
		                    </tr>
		                    <tr>
		                        <td>Customer Code</td>
		                        <td style="height:54px">${customerVO.cus_cd}</td>
		                    </tr>
		                    <tr>
		                        <td>Business License Number</td>
		                        <td><input type="text" class="input-box" name="reg_cd" value='${empty customerVO.reg_cd ? "" : customerVO.reg_cd}'></td>
		                    </tr>
		                    <tr>
		                        <td>FAX</td>
		                        <td><input type="text" class="input-box" name="fax" value='${empty customerVO.fax ? "" : customerVO.fax}'></td>
		                    </tr>
		                    <tr>
		                        <td>Domain</td>
		                        <td><input type="text" class="input-box" name="domain" value='${empty customerVO.domain ? "" : customerVO.domain}'></td>
		                    </tr>
		                    <tr>
		                        <td>CEO</td>
		                        <td><input type="text" class="input-box" name="ceo_name" value='${empty customerVO.ceo_name ? "" : customerVO.ceo_name}'></td>
		                    </tr>
		                    <tr>
		                        <td>CEO E-mail</td>
		                        <td><input type="text" class="input-box" name="ceo_email" value='${empty customerVO.ceo_email ? "" : customerVO.ceo_email}'></td>
		                    </tr>
		                    <tr>
		                        <td>Worker</td>
		                        <td><input type="text" class="input-box" name="worker_name" value='${empty customerVO.worker_name ? "" : customerVO.worker_name}'></td>
		                    </tr>
		                    <tr>
		                        <td>Worker E-mail</td>
		                        <td><input type="text" class="input-box" name="worker_email" value='${empty customerVO.worker_email ? "" : customerVO.worker_email}'></td>
		                    </tr>
		                </tbody>
		            </table>
		            
		        </div>
		        <div style="margin:0% 0% 0% 80%">
		            <input type="submit" style="margin:5px" class="button" value="MODIFY" onclick="location.href='/kaikei/account/customerModify.do?cus_cd=${customerVO.cus_cd}'"><br>
		            <input type="button" style="margin:5px" class="button" value="DELETE" onclick="isDelete();">		            
		            <input type="button" style="margin:5px" class="button" value="LIST" onclick="location.href='/kaikei/account/customer.do'"><br>
		        </div>
		        </form>
		    </div>
		</div>
		<script>
			function isDelete() {
				if(confirm("Delete ${customerVO.title}?")) {
					location.href='/kaikei/account/customerDelete.do?cus_cd=${customerVO.cus_cd}';
					return true;
				}

				return false;
			}

		</script>