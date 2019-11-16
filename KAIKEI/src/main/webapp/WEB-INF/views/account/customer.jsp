<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	    <div>
	        <div style="padding:20px">
	            <span style="font-size: 2em;">Customer</span>
	        </div>
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
	            <table class="table-striped-blue">
	            	<tbody>
		                <tr class="highlight">
		                    <td>Code</td>
		                    <td>Company</td>
		                    <td>CEO</td>
		                    <td>Worker</td>
		                    <td>Fax</td>
		                </tr>
		                <c:forEach var="customerVO" items="${customerList}">
		                <tr>
		                    <td><a href="/account/customerDetail.do?cus_cd=${customerVO.cus_cd}">${customerVO.cus_cd}</a></td>
		                    <td>${customerVO.title}</td>
		                    <td>${customerVO.ceo_name}</td>
		                    <td>${customerVO.worker_name}</td>
		                    <td>${customerVO.fax}</td>
		                </tr>
		                </c:forEach>
		        	</tbody>
	            </table>
	        </div>
	        <div align="center">
	        	<c:forEach var="i" begin="0" end="${pageNum - 1}">
	        		<a href="/account/customer.do?pageNum=${i}&searchParam=${searchParam}">${i + 1}</a> 
	        	</c:forEach>
	        </div>
	        <div align="right">
	            <input type="button" style="margin:10px" class="button" value="ADD" onclick="location.href='/account/customerAdd.do'">
	        </div>
	    </div>