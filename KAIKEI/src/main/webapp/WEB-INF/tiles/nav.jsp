<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<div class="div-nav-component">
    		<div align="center">
    			<img src="/kaikei/images/hallym.png">
    		</div>
    		<div style="background-color: #eeeeee;">
    			<p>Company : </p>
    			<p>Domain :</p>
    		</div>
    	</div>
		<div class="div-nav-component">
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
				<li class="report">> <a href="/kaikei/report/pl.do">P/L</a></li>
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
			<ul class="ul-list">
				<li><a href="javascript:menuExtend('chart');">Å§ Chart</a></li>
				<li class="chart">> <a href="/kaikei/chart/pl.do">P/L</a></li>
			</ul>
		</div>