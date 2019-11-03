<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<div>
    		<div align="center" style="padding:5px; border: 2px solid #969696; margin:5px 5px 0px 5px;">
    			<img src="/kaikei/images/${userVO.company_cd}.png">
    		</div>
    		<div style="background-color: #3b3b3b; padding:5px; margin:0px 5px 5px 5px;">
	    		<div style="padding:10px">
		    		<span style="color:white; font-weight: bold;">${companyTitle}</span><br>
		    		<span style="color:gray; font-size: 14px;">${companyDomain}</span>
	    		</div>
    		</div>
    	</div>
		<div class="div-nav-component">
			<ul class="ul-list">
				<li style="font-weight: bold;">> <a href="/kaikei/home.do">Home</a></li>
			</ul>
			<ul class="ul-list">
				<li style="font-weight: bold;">> <a href="/kaikei/logout.do">Logout(temp)</a></li>
			</ul>
			<c:if test="${userVO.posit_cd eq 'POS002' || userVO.posit_cd eq 'POS003'}">
			<ul class="ul-list">
				<li style="font-weight: bold;">> <a href="/kaikei/account/ledger.do">Ledger</a></li>
			</ul>
			<ul class="ul-list">
				<li style="font-weight: bold;">> <a href="/kaikei/account/customer.do">Customer</a></li>
			</ul>
			<ul class="ul-list">
				<li style="font-weight: bold;">Report</li>
				<li class="div-nav-item">> <a href="/kaikei/report/pl.do">P/L</a></li>
				<li class="div-nav-item">> <a href="/kaikei/report/bs.do">B/S</a></li>
				<li class="div-nav-item">> <a href="/kaikei/report/gl.do">General Ledger</a></li>
				<li class="div-nav-item">> <a href="/kaikei/report/ctb.do">Compound Trial Balance</a></li>
			</ul>
			<ul class="ul-list">
				<li>Chart</li>
				<li class="div-nav-item">> <a href="/kaikei/chart/pl.do">P/L</a></li>
			</ul>
			</c:if>
			<c:if test="${userVO.posit_cd eq 'POS001' }">
			<ul class="ul-list">
				<li style="font-weight: bold;">Manage</li>
				<li class="div-nav-item">> <a href="/kaikei/manage/company.do">Company(admin)</a></li>
				<li class="div-nav-item">> <a href="/kaikei/manage/users.do">Users(admin)</a></li>
				<li class="div-nav-item">> <a href="/kaikei/manage/code.do">Code(temp)</a></li>
			</ul>
			</c:if>
			<ul class="ul-list">
				<li style="font-weight: bold;">Setting</li>
				<li class="div-nav-item">> <a href="/kaikei/setting/personal.do">Personal(user+admin)</a></li>
				<c:if test="${userVO.posit_cd eq 'POS002' }">
				<li class="div-nav-item">> <a href="/kaikei/setting/company.do">Company(ceo)</a></li>
				<li class="div-nav-item">> <a href="/kaikei/setting/employee.do">Employee(ceo)</a></li>
				</c:if>
			</ul>
		</div>