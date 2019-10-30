<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<div id="div-component">
    	</div>
		<div id="div-component">
			<ul class="ul-list">
				<li>> <a href="/kaikei/home.do">Home</a></li>
			</ul>
			<ul class="ul-list">
				<li>> <a href="/kaikei/logout.do">Logout(temp)</a></li>
			</ul>
			<ul class="ul-list">
				<li>> <a href="/kaikei/account/ledger.do">Ledger</a></li>
			</ul>
			<ul class="ul-list">
				<li>> <a href="/kaikei/account/customer.do">Customer</a></li>
			</ul>
			<ul class="ul-list">
				<li><a href="javascript:menuExtend('report');">Å§ Report</a></li>
				<li class="report">> <a href="/kaikei/report/ps.do">P/S</a></li>
				<li class="report">> <a href="/kaikei/report/bs.do">B/S</a></li>
				<li class="report">> <a href="/kaikei/report/gl.do">General Ledger</a></li>
				<li class="report">> <a href="/kaikei/report/ctb.do">Compound Trial Balance</a></li>
			</ul>
			<ul class="ul-list">
				<li><a href="javascript:menuExtend('setting');">Å§ Setting</a></li>
				<li class="setting">> <a href="/kaikei/setting/personal.do">Personal(user+admin)</a></li>
				<li class="setting">> <a href="/kaikei/setting/company.do">Company(ceo)</a></li>
				<li class="setting">> <a href="/kaikei/setting/employee.do">Employee(ceo)</a></li>
			</ul>
			<ul class="ul-list">
				<li><a href="javascript:menuExtend('manage');">Å§  Manage</a></li>
				<li class="manage">> <a href="/kaikei/manage/company.do">Company(admin)</a></li>
				<li class="manage">> <a href="/kaikei/manage/users.do">Users(admin)</a></li>
				<li class="manage">> <a href="/kaikei/manage/code.do">Code(temp)</a></li>
			</ul>
		</div>