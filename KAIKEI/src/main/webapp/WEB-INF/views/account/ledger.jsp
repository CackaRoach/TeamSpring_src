
<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
						<td style="width:30px">Y</td>
						<td style="width:30px">M</td>
						<td style="width:30px">D</td>
						<td style="width:200px">Account</td>
						<td style="width:200px">Customer</td>
						<td style="width:30px">Classify</td>
						<td style="width:100px">Debtor</td>
						<td style="width:100px">Creditor</td>
						<td>ABS</td>
						<td style="width:30px"></td>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="item" items="${statements}" varStatus="status">
						<tr id="exist${status.index}" class="exist">
							<td><input type="text" name="year" value="${item.year}" placeholder="Year"/></td>
		    				<td><input type="text" name="month" value="${item.month}" placeholder="Month"/></td>
			    			<td><input type="text" name="date" value="${item.date}" placeholder="Date" /></td>
			    			<td><input type="text" name="account_cd" value="${item.account_cd}" placeholder="Account"/><label>${item.title}</label></td>
			    			<td><input type="text" name="customer_cd" value="${item.customer_cd}" placeholder="Customer"/></td>
			    			<td><input type="text" name="classify" value="${item.classify}" placeholder="Classify"/></td>
			    			<td><input type="text" name="debtor" value="${item.debtor}" placeholder="Debtor"/></td>
			    			<td><input type="text" name="creditor" value="${item.creditor}" placeholder="Creditor"/></td>
			    			<td><input type="text" name="abs" value="${item.abs}" placeholder="ABS"/></td>
			    			<td><a href="#">X</a></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<div id="statebtn" align="right">
			<input type="hidden" id="existrows" value="-1"/>
			<input type="hidden" id="changerows" value="-1"/>
			<input type="hidden" id="newrows" value="-1"/>
			<input id="saveBtn" class="button" style="margin:5px" type="button" onclick="statementSubmit();" value="Save"/>
			<input type="reset" id="stateReset" class="button" style="display:none" onclick="return deleteBtn();" value='Reset'/>
		</div>
    </form>
    	<div>
			<button class="button" onclick="debuging();">debug</button>
		</div>
		
