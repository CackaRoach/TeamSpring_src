<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div align="center" style="float:left; margin-left:8.5%; width:200px; padding:15px">
			<img src="/images/logo.png" onclick="location.href='/home.do'" style="cursor: pointer">
		</div>
		<div class="gnb">
			<div class="gnb-main">
				<c:if test="${posit_cd ne 'POS001'}">
					<ul>
						<li><a id="nav-account-ledger" href="/account/ledger.do">Ledger</a></li>
						<li><a id="nav-account-customer" href="/account/customer.do">Customer</a></li>
					</ul>
					<ul class="gnb-dth1">
						<li><a id="nav-report" href="/report/pl.do">Report</a></li>
						<li><a id="nav-chart" href="/chart/pl.do">Chart</a></li>
						<li><a id="nav-setting" href="/setting/personal.do">Setting</a></li>
					</ul>
				</c:if>
					
				<c:if test="${posit_cd eq 'POS001'}">
					<ul>
						<li><a id="nav-manage-company" href="/manage/company.do">Company</a></li>
						<li><a id="nav-manage-users" href="/manage/users.do">Users</a></li>
						<li><a id="nav-manage-code" href="/manage/code.do">Code</a></li>
					</ul>
				</c:if>
			</div>
			<div class="gnb-dth2">
				<ul class="">
					<li><a href="/report/pl.do">P/L</a></li>
					<li><a href="/report/bs.do">B/S</a></li>
					<li><a href="/report/gl.do">General Ledger</a></li>
					<li><a href="/report/ctb.do">Compound Trial Balance</a></li>
				</ul>
				<ul>
					<li><a href="/chart/pl.do">P/L</a></li>
					<li><a href="/chart/bs.do">B/S</a></li>
				</ul>
				<ul>
					<li><a href="/setting/personal.do">Personal</a></li>
					<c:if test="${posit_cd eq 'POS002'}">
						<li><a href="/setting/company.do">Company</a></li>
						<li><a href="/setting/employee.do">Employee</a></li>
					</c:if>
				</ul>
			</div>
		</div>
					
