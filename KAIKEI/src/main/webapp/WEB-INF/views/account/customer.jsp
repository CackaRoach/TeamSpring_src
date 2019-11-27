<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		
	    <div>
	        <div style="padding:20px">
	            <span style="font-size: 1.7em;">Customer</span>
	        </div>
	        <hr>
	        <div class="search-box">
	            <form style="margin:0px" action="/account/customer.do" method="get">
	                <span style="font-size:1.5em;">Search</span>
	                <div align="right">
	                    <input type="text" class="input-box" name="searchParam" placeholder="Search">
	                    <input type="submit" class="button" value="FIND">
	                </div>
	            </form>
	        </div>
	        <div style="margin:5px">
	            <table class="customer">
	            	<thead>
		                <tr>
		                    <td style="width:100px">Code</td>
		                    <td style="width:250px">Company</td>
		                    <td style="width:100px">CEO</td>
		                    <td style="width:100px">Worker</td>
		                    <td style="width:200px">Fax</td>
		                    <td>Memo</td>
		                </tr>
		            <thead>
		            <tbody>
		                <c:forEach var="customerVO" items="${customerList}">
		                <tr>
		                    <td><a href="/account/customerDetail.do?cus_cd=${customerVO.cus_cd}">${customerVO.cus_cd}</a></td>
		                    <td>${customerVO.title}</td>
		                    <td>${customerVO.ceo_name}</td>
		                    <td>${customerVO.worker_name}</td>
		                    <td>${customerVO.fax}</td>
		                    <td></td>
		                </tr>
		                </c:forEach>
		        	</tbody>
	            </table>
	        </div>
	        <div align="center">
 	        	<c:if test="${pageCnt ne 0}">
		        	<c:forEach var="i" begin="0" end="${pageCnt - 1}">
		        		<a class="pagenum" href="/account/customer.do?crtPage=${i}&searchParam=${searchParam}">${i + 1}</a> 
		        	</c:forEach>
	        	</c:if>
	        </div>
	        <div align="right">
	            <input type="button" style="margin:10px" class="button" value="ADD" onclick="location.href='/account/customerAdd.do'">
	        </div>
	    </div>