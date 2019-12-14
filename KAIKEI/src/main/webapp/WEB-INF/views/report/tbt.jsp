<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		
		<script>
			$(window).ready(function() {
				var acc_list = ["Asset", "Debt", "Capital", "Profit" ,"Cost"];
				var sum = new Object();

				sum.debbal = 0;
				sum.deb = 0;
				sum.cred = 0;
				sum.credbal = 0;
				
				acc_list.forEach(function(item) {
					sum.debbal = 0;
					sum.deb = 0;
					sum.cred = 0;
					sum.credbal = 0;
					
					for(var i = 0; i < $("." + item).length; i++) {
						sum.debbal += Number($("." + item + ":eq(" + i +")").children(".debbal").text());
						sum.deb += Number($("." + item + ":eq(" + i +")").children(".deb").text());
						sum.cred += Number($("." + item + ":eq(" + i +")").children(".cred").text());
						sum.credbal += Number($("." + item + ":eq(" + i +")").children(".credbal").text());
					}

					$("." + item + ":eq(0)").before(row(item, sum));
				});

				$(".Asset").children(".credbal").text("");
				$(".Debt").children(".debbal").text("");
				$(".Capital").children(".debbal").text("");
				$(".Profit").children(".debbal").text("");
				$(".Cost").children(".credbal").text("");

				acc_list.forEach(function(item) {
					sum.debbal += Number($("." + item + ":eq(0)").children(".debbal").text());
					sum.deb += Number($("." + item + ":eq(0)").children(".deb").text());
					sum.cred += Number($("." + item + ":eq(0)").children(".cred").text());
					sum.credbal += Number($("." + item + ":eq(0)").children(".credbal").text());
				});

				$(".tbt-table").append(row("Total", sum));
			})
			
			function row(clf, sum) {

				var item = "";

				item += "<tr class='" + clf + "'>";
				item += "<th class='debbal'>" + sum.debbal + "</th>";
				item += "<th class='deb'>" + sum.deb + "</th>";
				item += "<th>" + clf + "</td>";
				item += "<th class='cred'>" + sum.cred + "</th>";
				item += "<th class='credbal'>" + sum.credbal + "</th>";
				item += "</tr>";

				return item;
				
			}
		</script>
		
		