<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div align="center" class="div-nav-component">
			<div style="display: inline;">
				<button class="navbtn" onclick="location.href='/home.do'">Home</button>
				<button class="navbtn" onclick="location.href='/logout.do'">Logout(temp)</button>
			</div>
			<c:if test="${posit_cd eq 'POS002' || posit_cd eq 'POS003'}">
			<div style="display: inline;">
				<button class="navbtn" onclick="location.href='/account/ledger.do'">Ledger</button>
				<button class="navbtn" onclick="location.href='/account/customer.do'">Customer</button>
			</div>
			<div align="left" class="dropdown">
				<button class="navbtn">Report</button>
				<div class="dropdown-contents">
					<a href="/report/pl.do">P/L</a>
					<a href="/report/bs.do">B/S</a>
					<a href="/report/gl.do">General Ledger</a>
					<a href="/report/ctb.do">Compound Trial Balance</a>
				</div>
			</div>
			<div align="left" class="dropdown">
				<button class="navbtn">Chart</button>
				<div class="dropdown-contents">
					<a href="/chart/pl.do">P/L</a>
					<a href="/chart/bs.do">B/S</a>
				</div>
			</div>
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
		</div>