<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			
		<div align="center" style="float:left; margin:0% 30% 0% 8.5%; width:200px; padding:15px">
			<img src="/images/logo.png" onclick="location.href='/home.do'" style="cursor: pointer">
		</div>
		<c:if test="${posit_cd eq 'POS002' || posit_cd eq 'POS003'}">
		<ul class="nav-menu" style="float:left; list-style:none;">
			<li>
				<a id="nav-account-ledger" href="/account/ledger.do">Ledger</a>
			</li>
			<li>
				<a id="nav-account-customer" href="/account/customer.do">Customer</a>
			</li>
			<li>
				<a href="/report/pl.do">Report</a>
				<ul class="nav-menu-dropdown">
					<li>
						<a href="/report/pl.do">P/L</a>
					</li>
					<li>
						<a href="/report/bs.do">B/S</a>
					</li>
					<li>
						<a href="/report/gl.do">General Ledger</a>
					</li>
					<li>
						<a href="/report/ctb.do">Compound Trial Balance</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="/chart/pl.do">Chart</a>
				<ul class="nav-menu-dropdown">
					<li>
						<a href="/chart/pl.do">P/L</a>
					</li>
					<li>
						<a href="/chart/bs.do">B/S</a>
					</li>
				</ul>
			</li>
			<li><a href="/setting/personal.do">Setting</a></li>
		</ul>
		</c:if>
		<c:if test="${posit_cd eq 'POS001' }">
		<div align="left" class="dropdown">
			<button class="navbtn">Manage</button>
			<div class="dropdown-contents">
				<a href="/manage/company.do">Company(admin)</a>
				<a href="/manage/users.do">Users(admin)</a>
				<a href="/manage/code.do">Code(temp)</a>
			</div>
		</div>
		</c:if>
		<!--
		<div align="left" class="dropdown">
			<button class="navbtn">Setting</button>
			<div class="dropdown-contents">
				<a href="/setting/personal.do">Personal(user+admin)</a>
				<c:if test="${posit_cd eq 'POS002' }">
					<a href="/setting/company.do">Company(ceo)</a>
					<a href="/setting/employee.do">Employee(ceo)</a>
				</c:if>
			</div>
		</div>
		-->
		