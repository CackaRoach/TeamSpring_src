<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
			<h3>Reports - General Ledger</h3>
		</div>
		<div align="center">
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
							<td>${StatementVO.abs}</a></td>
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
							<td>${StatementVO.abs}</a></td>
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
							<td>${StatementVO.abs}</a></td>
							<td>${StatementVO.customer_cd}</td>
							<td>${StatementVO.debtor}</td>
							<td>${StatementVO.creditor}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tr>
				<tr bgcolor="#A4A4A4">
					<td colspan="3" style="text-align:left">Total</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<p></p>
			
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
							<td>${StatementVO.abs}</a></td>
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
							<td>${StatementVO.abs}</a></td>
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
							<td>${StatementVO.abs}</a></td>
							<td>${StatementVO.customer_cd}</td>
							<td>${StatementVO.debtor}</td>
							<td>${StatementVO.creditor}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tr>
				<tr bgcolor="#A4A4A4">
					<td colspan="3" style="text-align:left">Total</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<p></p>
			
			<div align="center">
				<input type="button" onClick="location.href = 'addBoard.do'" value="Post">
			</div>
			<p></p>
		</div>
		