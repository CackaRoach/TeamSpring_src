<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
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
				<c:forEach var="dataSet" items="${dataList}">
					<c:forEach var="data" items="${dataSet}" varStatus="status">
						<tr>
							<td bgcolor="#A4A4A4">${status.index}</td>
							<td bgcolor="#A4A4A4">${data[1]}</td>
							<th bgcolor="#A4A4A4">${jasan[status.count]}</th>
							<td bgcolor="#A4A4A4">${data[2]}</td>
							<td bgcolor="#A4A4A4">${data[3]}</td>
						</tr>
					</c:forEach>
				</c:forEach>
				<tr>
					<td bgcolor="#CED8F6"></td>
					<td bgcolor="#CED8F6"></td>
					<td bgcolor="#C6C4C4">Cash(0101)</td>
					<td bgcolor="#F79F81"></td>
					<td bgcolor="#F79F81"></td>
				</tr>
				<tr>
					<td bgcolor="#819FF7"></td>
					<td bgcolor="#819FF7"></td>
					<td bgcolor="#C6C4C4">Deposit(0103)</td>
					<td bgcolor="#FE9A2E"></td>
					<td bgcolor="#FE9A2E"></td>
				</tr>
				<tr>
					<td bgcolor="#A4A4A4"></td>
					<td bgcolor="#A4A4A4"></td>
					<th bgcolor="#A4A4A4">Total</th>
					<td bgcolor="#A4A4A4"></td>
					<td bgcolor="#A4A4A4"></td>
				</tr>
			</table>
			<p></p>
		</div>