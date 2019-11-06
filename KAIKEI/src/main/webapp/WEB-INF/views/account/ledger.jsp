<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
#StatementList td input[type='text'] {
	border:1px solid white;
	padding:10px;
}
#StatementList td input[type='text']:hover {
	border:1px solid #bbbbbb;
}
#StatementList td input[type='text']:focus {
	background-color:#eeeeee;
}
#StatementList .title td {
	font-weight: 900;
	font-size: 16px;
	text-align:center;
}
</style>
		<div>
			<h3>Ledger</h3>
		</div>
		<form action="/kaikei/account/ledger.do" method="GET">
			<select name="job">
    			<option value="account_cd">Account Code</option>
    			<option value="customer_cd">Customer Code</option>
    			<option value="classify">Classify</option>
			</select>
			<input type="text" name="searchKeyword"/>
			<input type="submit" value="Search"/>
		</form>
		
	<form action="/kaikei/account/addStatement.do" method="POST">
		<table id="StatementList">
		<tr class="title">
			<td>Date</td>
			<td>Account</td>
			<td>Customer</td>
			<td>Class</td>
			<td>Debtor</td>
			<td>Creditor</td>
			<td>ABS</td>
		</tr>
		
		<c:forEach var="item" items="${statements}">
			<tr>
    			<td><input type="text" value="${item.date}" /></td>
    			<td><input type="text" value="${item.account_cd}" /></td>
    			<td><input type="text" value="${item.customer_cd}" /></td>
    			<td><input type="text" value="${item.classify}" /></td>
    			<td><input type="text" value="${item.debtor}" /></td>
    			<td><input type="text" value="${item.creditor}" /></td>
    			<td><input type="text" value="${item.abs}" /></td>
			</tr>
		</c:forEach>
			<tr>
    				<td><input type="text" name="date" placeholder="Date"/></td>
    				<td><input type="text" name="account_cd" placeholder="Account"/></td>
    				<td><input type="text" name="customer_cd" placeholder="Customer"/></td>
    				<td><input type="text" name="classify" placeholder="Class"/></td>
    				<td><input type="text" name="debtor" placeholder="Debtor"/></td>
    				<td><input type="text" name="creditor" placeholder="Creditor"/></td>
    				<td><input type="text" name="abs" placeholder="ABS"/></td>
			</tr>
		</table>
		<input id="saveBtn" type="submit" value="Save"/>
    </form>
		