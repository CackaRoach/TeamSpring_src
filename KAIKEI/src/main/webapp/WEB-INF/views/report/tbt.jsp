<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

		<script type="text/javascript" src="/js/tdt.js"></script>
		<div>
			<h3>Reports - Trial Balance of Total</h3>
		</div>
		<div align="center">
			<div>
				<h1>2019 4Q</h1>
			</div>
			<table class="tbt-table">
				<thead>
					<tr>
						<td bgcolor="#2E64FE" colspan="2" style="width:500px;">Debtor</td>
						<td bgcolor="#A4A4A4" rowspan="2" style="width:500px;">Account Title</td>
						<td bgcolor="#FE642E" colspan="2" style="width:500px;">Creditor</td>
					</tr>
					<tr>
						<td bgcolor="#CED8F6">Balance</td>
						<td bgcolor="#CED8F6">Total</td>
						<td bgcolor="#F5D0A9">Total</td>
						<td bgcolor="#F5D0A9">Balance</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${tbtList}">
						<tr class="${item.classify}">
							<td class="debbal">${item.debbal}</td>
							<td class="deb">${item.deb}</td>
							<td>[0${item.acc_cd}] ${item.title} <input type="hidden" value="${item.acc_cd}"></td>
							<td class="cred">${item.cred}</td>
							<td class="credbal">${item.credbal}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
