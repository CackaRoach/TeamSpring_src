
<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    <!--  
	-- TODO: regex check
	-- TODO: Paging
    -->
		<script type="text/javascript" src="/js/ledger.js"></script>
		<div style="padding: 20px;">
			<span style="font-size: 1.7em;">Ledger</span>
		</div>
		<hr>
		<div align="center" style="padding: 30px;">
			<span style="font-size: 1.5em;">${year} - ${month - 1} ~ ${year} - ${month}</span>
			<input type="hidden" id="year" value="${year}">
			<input type="hidden" id="month" value="${month}">
		</div>
		<div align="right">
		<!-- 
			<form action="/kaikei/account/ledger.do" method="GET">
				<select class="select-menu" style="width: 230px" name="job">
	    			<option value="account_cd">Account Code</option>
	    			<option value="customer_cd">Customer Code</option>
	    			<option value="classify">Classify</option>
				</select>
				<input type="text" class="input-box" name="searchKeyword"/>
				<input type="submit" class="button" value="Search"/>
			</form>
		-->
		</div>
		<form action="/account/addStatement.do" method="POST">
		<div>
			<table id="statement" class="statement">
				<thead>
					<tr>
						<td style="width:20px">Y</td>
						<td style="width:20px">M</td>
						<td style="width:20px">D</td>
						<td style="width:180px">Account</td>
						<td style="width:180px">Customer</td>
						<td style="width:30px">Classify</td>
						<td style="width:60px">Debtor</td>
						<td style="width:60px">Creditor</td>
						<td>ABS</td>
						<td style="width:100px">Modified</td>
						<td style="width:10px"></td>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="item" items="${statements}" varStatus="status">
						<tr id="state${status.index}" class="exist">
							<td><label>${item.year}</label></td>
		    				<td><label>${item.month}</label></td>
			    			<td><input type="text" name="date" value="${item.date}" maxlength="2" placeholder="D" /></td>
			    			<td><input type="text" name="acc_title" value="${item.acc_title}" placeholder="Account"/><label class="account_cd">${item.account_cd}</label></td>
			    			<td><input type="text" name="cus_title" value="${item.cus_title}" placeholder="Customer"/><label class="customer_cd">${item.customer_cd}</label></td>
			    			<td><input type="text" name="classify" value="${item.classify}" placeholder="Classify"/></td>
			    			<td><input type="text" name="debtor" value="${item.debtor}" placeholder="Debtor"/></td>
			    			<td><input type="text" name="creditor" value="${item.creditor}" placeholder="Creditor"/></td>
			    			<td><input type="text" name="abs" value="${item.abs}" placeholder="ABS"/></td>
			    			<td><label>${item.mod_date}</label></td>
			    			<td><a href="javascript:removeRow(${status.index});">X</a><input type="hidden" name="seq" value="${item.seq}"></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<div align="center">
			<c:forEach var="i" begin="0" end="${statements[0].pagenum - 1}">
				<a href="/account/ledger.do?pagenum=${i}">${i + 1}</a>
			</c:forEach>
		</div>
		<div id="statebtn" align="right">
			<input type="button" id="saveBtn" class="button" style="display:none" style="margin:5px" onclick="submitStatement();" value="Save"/>
		</div>
		<div id="data-dynamic">
			<input type="hidden" id="changeRow" value=""/>
		</div>
		</form>
		<div id="data-static">
			<input type="hidden" id="existrows" value="${fn:length(statements)}"/>
			<input type="hidden" id="newrows" value="0"/>
		</div>
		<div id="autocompleteList">
			<ul id="autocomplete-ul">

			</ul>
		</div>
			

		
