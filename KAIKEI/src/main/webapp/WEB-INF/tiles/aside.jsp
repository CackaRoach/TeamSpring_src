<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<script>
    		$(window).load(function() {
    			var path = window.location.pathname.split('/');

				var p_path = path[1];
				var c_path = path[2].slice(0, -3);
 	   			
    			$("#aside-title").html(p_path.toUpperCase());
        		$("#aside" + "-" + p_path).css("display", "block");
        		$("#aside" + "-" + p_path + "-" + c_path).children().addClass("aside-selected");
        					    
        	});
	    </script>
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
					<li id="aside-report-gl"><a href="/report/gl.do">Customer</a></li>
					<li id="aside-report-ctb"><a href="/report/ctb.do">Customer</a></li>
				</ul>
				<ul id="aside-chart" class="aside-bar">
					<li id="aside-chart-pl"><a href="/chart/pl.do">P/L</a></li>
					<li id="aside-chart-bs"><a href="/chart/bs.do">B/S</a></li>
				</ul>
				<ul id="aside-setting" class="aside-bar">
					<li id="aside-setting-personal"><a href="/setting/personal.do">Personal</a></li>
					<li id="aside-chart-bs"><a href="/chart/bs.do">Company</a></li>
					<li id="aside-chart-c"><a href="/chart/bs.do">Code</a></li>
				</ul>
			</div>
		</div>
		