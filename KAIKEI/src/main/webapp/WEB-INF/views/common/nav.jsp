<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			
		<div align="center" style="float:left; margin-left:8.5%; width:200px; padding:15px">
			<img src="/images/logo.png" onclick="location.href='/home.do'" style="cursor: pointer">
		</div>
		<div style="float:right; margin-right: 10%">
			<ul class="nav-menu" style="float:left; list-style:none;">
	
			<c:if test="${posit_cd ne 'POS001'}">
				<li>
					<a id="nav-account-ledger" href="/account/ledger.do">Ledger</a>
				</li>
				<li>
					<a id="nav-account-customer" href="/account/customer.do">Customer</a>
				</li>
				<li>
					<a id="nav-report" href="/report/pl.do">Report</a>
					<ul class="nav-menu-dropdown">
						<li><a href="/report/pl.do">P/L</a></li>
						<li><a href="/report/bs.do">B/S</a></li>
						<li><a href="/report/gl.do">General Ledger</a></li>
						<li><a href="/report/ctb.do">Compound Trial Balance</a></li>
					</ul>
				</li>
				<li>
					<a id="nav-chart" href="/chart/pl.do">Chart</a>
					<ul class="nav-menu-dropdown">
						<li><a href="/chart/pl.do">P/L</a></li>
						<li><a href="/chart/bs.do">B/S</a></li>
					</ul>
				</li>
			</c:if>
			<c:if test="${posit_cd eq 'POS003'}">
				<li>
					<a id="nav-setting" href="/setting/personal.do">Setting</a>
					<ul class="nav-menu-dropdown">
						<li><a href="/setting/personal.do">Personal</a></li>
					</ul>
				</li>
			</c:if>
			<c:if test="${posit_cd eq 'POS002'}">
				<li>
					<a id="nav-setting" href="/setting/personal.do">Setting</a>
					<ul class="nav-menu-dropdown">
						<li><a href="/setting/personal.do">Personal</a></li>
						<li><a href="/setting/company.do">Company</a></li>
						<li><a href="/setting/employee.do">Employee</a></li>
					</ul>
				</li>
			</c:if>
	
	
			<c:if test="${posit_cd eq 'POS001'}">
				<li>
					<a id="nav-manage-company" href="/manage/company.do">Manage</a>
				</li>
				<li>
					<a id="nav-manage-users" href="/manage/users.do">Users</a>
				</li>
				<li>
					<a id="nav-manage-code" href="/manage/code.do">Code</a>
				</li>
			</c:if>
			</ul>
		</div>