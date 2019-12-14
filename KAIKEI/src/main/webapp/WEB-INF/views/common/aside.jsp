<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div style="margin:0% 0% 0% 44%;">
			<div align="center" style="background-color: #3F8AFF; width: 100%; height: 100px">
				<span id="aside-title" style="font-size: 1.2em; color: white; line-height: 100px"></span>
			</div>
			<div>
				<ul id="aside-account" class="aside-bar">
					<li id="aside-account-ledger"><a href="/account/ledger.do">Ledger</a></li>
					<li id="aside-account-customer"><a href="/account/customer.do">Customer</a></li>
				</ul>
				<ul id="aside-report" class="aside-bar">
					<li id="aside-report-pl"><a href="/report/pl.do">P/L</a></li>
					<li id="aside-report-bs"><a href="/report/bs.do">B/S</a></li>
					<li id="aside-report-gl"><a href="/report/gl.do">General Ledger</a></li>
					<li id="aside-report-tbt"><a href="/report/tbt.do">Trial Balance of Totals</a></li>
				</ul>
				<ul id="aside-chart" class="aside-bar">
					<li id="aside-chart-pl"><a href="/chart/pl.do">P/L</a></li>
					<li id="aside-chart-bs"><a href="/chart/bs.do">B/S</a></li>
				</ul>
				<ul id="aside-setting" class="aside-bar">
					<li id="aside-setting-personal"><a href="/setting/personal.do">Personal</a></li>
					<li id="aside-setting-company"><a href="/setting/company.do">Company</a></li>
					<li id="aside-setting-code"><a href="/setting/code.do">Employee</a></li>
				</ul>
				<ul id="aside-manage" class="aside-bar">
					<li id="aside-manage-company"><a href="/manage/company.do">Company</a></li>
					<li id="aside-manage-users"><a href="/manage/users.do">Users</a></li>
					<!-- <li id="aside-manage-code"><a href="/manage/code.do">Code</a></li> -->
				</ul>
			</div>
		</div>
		