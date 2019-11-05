<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
		    <div style="padding:20px">
		        <span style="font-size: 2em;">Customer</span>
		    </div>
		    <form action="/kaikei/account/customerModifyExc.do" method="post">
		    	<div style="border:1px solid black; padding:15px; margin:5px; height:550px;">
		            <table style="padding:5px">
		                <tbody>
		                    <tr>
		                        <td>Customer<span style="color:red">*</span></td>
		                        <td><input type="text" class="input-box" name="title" value="${customerVO.title}"></td>
		                    </tr>
		                    <tr>
		                        <td>Customer Code<span style="color:red">*</span></td>
		                        <td>${customerVO.cus_cd}<input type="hidden" name="cus_cd" value="${customerVO.cus_cd}"></td>
		                    </tr>
		                    <tr>
		                        <td>Business License Number</td>
		                        <td><input type="text" class="input-box" name="reg_cd" value="${customerVO.reg_cd}"></td>
		                    </tr>
		                    <tr>
		                        <td>FAX</td>
		                        <td><input type="text" class="input-box" name="fax" value="${customerVO.fax}"></td>
		                    </tr>
		                    <tr>
		                        <td>Domain</td>
		                        <td><input type="text" class="input-box" name="domain" value="${customerVO.domain}"></td>
		                    </tr>
		                    <tr>
		                        <td>CEO</td>
		                        <td><input type="text" class="input-box" name="ceo_name" value="${customerVO.ceo_name}"></td>
		                    </tr>
		                    <tr>
		                        <td>CEO Email</td>
		                        <td><input type="text" class="input-box" name="ceo_email" value="${customerVO.ceo_email}"></td>
		                    </tr>
		                    <tr>
		                        <td>Worker</td>
		                        <td><input type="text" class="input-box" name="worker_name" value="${customerVO.worker_name}"></td>
		                    </tr>
		                    <tr>
		                        <td>Worker Email</td>
		                        <td><input type="text" class="input-box" name="worker_email" value="${customerVO.worker_email}"></td>
		                    </tr>
		          	      </tbody>
		         	    </table>
		         	<div style="float:right;">
			            <input type="submit" style="margin:3px" class="button" value="MODIFY">
			            <input type="button" style="margin:3px" class="button" value="CANCEL" onclick="location.href='/kaikei/account/customer.do'">
			        </div>
	         	</div>
		    </form>
		</div>