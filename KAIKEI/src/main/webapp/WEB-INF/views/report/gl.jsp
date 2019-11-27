<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div>
			<h3>Reports - General Ledger</h3>
		</div>
		<div align="center">
			<div>
				<input type="button" onClick="" value="<">
				2019 - 3Q
				<input type="button" onClick="" value=">">
			</div>
			<p></p>
			<c:forEach var="dataList" items="${GL_dataList[3]}" varStatus="i">
				<table border="1" style="border-collapse:collapse; text-align:center">
					<tr>
						<th bgcolor="#FE642E" colspan="6"  style="text-align:left">${dataList[0]}</th>
					</tr>
				
					<tr>
						<th bgcolor="#FE9A2E" style="width:100px">Date</th>
						<th bgcolor="#FE9A2E" style="width:100px">Abstract</th>
						<th bgcolor="#FE9A2E" style="width:100px">Customer</th>
						<th bgcolor="#FE9A2E" style="width:100px">Deb</th>
						<th bgcolor="#FE9A2E" style="width:100px">Cred</th>
						<th bgcolor="#FE9A2E" style="width:100px">Balance</th>
					</tr>
			
					<tr bgcolor="#A4A4A4">
						<td colspan="5" style="text-align:left">Carried Forward</td>
						<td>
			    			0
						</td>
					</tr>
					<c:set var="lastMonth" value='0' />
					<c:forEach var="dataList" items="${GL_dataList[0]}" varStatus="j">
						<tr>
							<c:forEach var="data" items="${dataList}" begin="1" end = "6">	
								<td>
									<c:out value="${data}" />
								</td>
							</c:forEach> 
						</tr>
						<!-- TODOList  : ‚±‚¿‚ç‚©‚ç–¾“ú -->
						<c:if test="${lastMonth ne GL_dataList[1][j.index][0] and GL_dataList[1][j.index][0] eq GL_dataList[1][j.index+1][0] }">
							<c:set var="lastMonth" value= "${GL_dataList[1][j.index][0]}"/>
							<tr bgcolor="#C6C4C4">
								<td colspan="3" style="text-align:left">Monthly Total</td>
								<td>${GL_dataList[1][j.index][1]}</td>
								<td>${GL_dataList[1][j.index][2]}</td>
								<td>${GL_dataList[1][j.index][3]}</td>
							</tr>
						</c:if>					
					</c:forEach> 
					
					<tr bgcolor="#A4A4A4">
						<td colspan="3" style="text-align:left">Total</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
				<p></p>
			</c:forEach>
			
			<table border="1" style="border-collapse:collapse; text-align:center">
				<tr>
					<th bgcolor="#FE642E" colspan="6"  style="text-align:left">0101 - Cash</th>
				</tr>
				<tr>
					<th bgcolor="#FE9A2E" style="width:100px">Date</th>
					<th bgcolor="#FE9A2E" style="width:100px">Abstract</th>
					<th bgcolor="#FE9A2E" style="width:100px">Customer</th>
					<th bgcolor="#FE9A2E" style="width:100px">Deb</th>
					<th bgcolor="#FE9A2E" style="width:100px">Cred</th>
					<th bgcolor="#FE9A2E" style="width:100px">Balance</th>
				</tr>
				
				<tr bgcolor="#A4A4A4">
					<td colspan="5" style="text-align:left">Carried Forward</td>
					<td></td>
				</tr>
				<tr>
					<c:forEach var="StatementVO" items="${StatementList}">
						<tr bgcolor="#F8E6E0">
							<td>${StatementVO.date}</td>
							<td>${StatementVO.abs}</td>
							<td>${StatementVO.customer_cd}</td>
							<td>${StatementVO.debtor}</td>
							<td>${StatementVO.creditor}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tr>
				<tr bgcolor="#C6C4C4">
					<td colspan="5" style="text-align:left">Monthly Total</td>
					<td></td>
				</tr>
				<tr>
					<c:forEach var="StatementVO" items="${StatementList}">
						<tr bgcolor="#F8E6E0">
							<td>${StatementVO.date}</td>
							<td>${StatementVO.abs}</td>
							<td>${StatementVO.customer_cd}</td>
							<td>${StatementVO.debtor}</td>
							<td>${StatementVO.creditor}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tr>
				<tr bgcolor="#C6C4C4">
					<td colspan="5" style="text-align:left">Monthly Total</td>
					<td></td>
				</tr>
				<tr bgcolor="#A4A4A4">
					<td colspan="3" style="text-align:left">Total</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<p></p>
		</div>
		