<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div align="center" class="header-title">
			<label class="header-title-font" style="font-size: 1.5em">KAIKEI</label>
		</div>
		<div style="float:right; height:50px; margin-right: 10%">
			<ul class="header-list">
				<li><a href="/home.do">Home</a></li>
				<c:if test="${posit_cd eq 'POS001' && company_cd ne '00000'}">
					<li><span class="header-bar"></span><a href="/manage/manage.do">Manage-Logout</a></li>
				</c:if>
				<li><span class="header-bar"></span><a href="/logout.do">Logout</a></li>
			</ul>
		</div>