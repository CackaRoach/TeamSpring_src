
<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!--  
	TODO: Auto Generator - Account
	TODO: Auto Generator - Customer
	TODO: Statement Update
	TODO: Statement Delete 
  -->
		<script type="text/javascript" src="/js/ledger.js"></script>
		<div>
			<h3>Ledger</h3>
		</div>
		<div align="right">
			<form action="/kaikei/account/ledger.do" method="GET">
				<select class="button" style="width: 230px" name="job">
	    			<option value="account_cd">Account Code</option>
	    			<option value="customer_cd">Customer Code</option>
	    			<option value="classify">Classify</option>
				</select>
				<input type="text" class="input-box" name="searchKeyword"/>
				<input type="submit" class="button" value="Search"/>
			</form>
		</div>
		<form action="/account/addStatement.do" method="POST">
		<div>
			<table id="statement" class="statement">
				<thead>
					<tr>
						<td style="width:20px">Y</td>
						<td style="width:20px">M</td>
						<td style="width:20px">D</td>
						<td style="width:200px">Account</td>
						<td style="width:200px">Customer</td>
						<td style="width:30px">Classify</td>
						<td style="width:100px">Debtor</td>
						<td style="width:100px">Creditor</td>
						<td>ABS</td>
						<td style="width:150px">Entry date</td>
						<td style="width:10px"></td>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="item" items="${statements}" varStatus="status">
						<tr id="state${status.index}" class="exist">
							<td><input type="text" name="year" value="${item.year}" placeholder="Y"/></td>
		    				<td><input type="text" name="month" value="${item.month}" placeholder="M"/></td>
			    			<td><input type="text" name="date" value="${item.date}" placeholder="D" /></td>
			    			<td><input type="text" name="account_cd" value="${item.account_cd}" maxlength="4" placeholder="Account"/><label>${item.title}</label></td>
			    			<td><input type="text" name="customer_cd" value="${item.customer_cd}" maxlength="5" placeholder="Customer"/><label>${item.cus_title}</label></td>
			    			<td><input type="text" name="classify" value="${item.classify}" placeholder="Classify"/></td>
			    			<td><input type="text" name="debtor" value="${item.debtor}" placeholder="Debtor"/></td>
			    			<td><input type="text" name="creditor" value="${item.creditor}" placeholder="Creditor"/></td>
			    			<td><input type="text" name="abs" value="${item.abs}" placeholder="ABS"/></td>
			    			<td></td>
			    			<td><a href="">X</a><input type="hidden" name="seq" value=""></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			</div>
			<div id="statebtn" align="right">
				<input id="saveBtn" class="button" style="margin:5px" type="button" onclick="statementSubmit();" value="Save"/>
				<input type="reset" id="stateReset" class="button" style="display:none" onclick="return deleteBtn();" value='Reset'/>
			</div>
			<div id="data-static">
				<input type="hidden" id="existrows" value="${fn:length(statements)}"/>
				<input type="hidden" id="changerows" value=""/>
				<input type="hidden" id="newrows" value="0"/>
			</div>
	    </form>
    	<div>
			<button class="button" onclick="debuging();">debug</button>
		</div>
		
