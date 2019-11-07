<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

		<div>
			<h3>Reports - Compound Trial Balance</h3>
		</div>
		<div align="center">
			<div>
				<input type="button" onClick="" value="<">
				2019
				<input type="button" onClick="" value=">">
			</div>
			<p></p>
			<table border="1" style="border-collapse:collapse; text-align:center">
				<tr>
					<th bgcolor="#2E64FE" colspan="2" style="width:500px;">Debtor</th>
					<th bgcolor="#A4A4A4" rowspan="2" style="width:500px;">Account Title</th>
					<th bgcolor="#FE642E" colspan="2" style="width:500px;">Creditor</th>
				</tr>
				<tr>
					<th bgcolor="#CED8F6">Balance</th>
					<th bgcolor="#CED8F6">Total</th>
					<th bgcolor="#F5D0A9">Total</th>
					<th bgcolor="#F5D0A9">Balance</th>
				</tr>
				
				<c:forEach var="actList" items="${accountList}" varStatus="i">
					<c:forEach var="data" items="${actList}" varStatus="j">
						<tr>	
							<td bgcolor="#CED8F6">	
								<c:out value="${CTB_dataList[i.index][0]}" />
							</td>
							<td bgcolor="#CED8F6">
								<c:out value="${CTB_dataList[i.index][1]}" />
							</td>
							<th bgcolor="#C6C4C4">
								(${data.account_cd})
							</th>
							<td bgcolor="#F79F81">
								<c:out value="${CTB_dataList[i.index][2]}" />
							</td>
							<td bgcolor="#F79F81">
								<c:out value="${CTB_dataList[i.index][3]}" />
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
				<tr>
					<td bgcolor="#A4A4A4">
						<c:out value="${CTB_dataList[fn:length(CTB_dataList)-1][0]}" />
					</td>
					<td bgcolor="#A4A4A4">
						<c:out value="${CTB_dataList[fn:length(CTB_dataList)-1][1]}" />
					</td>
					<th bgcolor="#A4A4A4">Total</th>
					<td bgcolor="#A4A4A4">
						<c:out value="${CTB_dataList[fn:length(CTB_dataList)-1][2]}" />
					</td>
					<td bgcolor="#A4A4A4">
						<c:out value="${CTB_dataList[fn:length(CTB_dataList)-1][3]}" />
					</td>
				</tr>
			</table>
			<p></p>
		</div>