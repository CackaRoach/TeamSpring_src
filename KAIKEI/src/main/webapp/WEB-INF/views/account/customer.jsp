<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	    <div>
	        <div style="padding:20px">
	            <span style="font-size: 2em;">Customer</span>
	        </div>
	        <div style="border:1px solid black; padding:20px; margin: 10px">
	            <form style="margin:0px" action="/kaikei/account/customer.do" method="get">
	                <span style="font-size:1.5em;">Search</span>
	                <div style="float:right">
	                    <input type="text" class="input-box" name="searchParam" placeholder="Search">
	                    <input type="submit" class="button" value="FIND">
	                </div>
	            </form>
	        </div>
	        <div style="margin:5px">
	            <table class="table-striped" style="border-collapse: collapse; border-bottom: 2px solid black; width:100%; text-align:center">
	            	<tbody>
		                <tr>
		                    <td style="background-color: black; color: white">Code</td>
		                    <td style="background-color: black; color: white">Company</td>
		                    <td style="background-color: black; color: white">CEO</td>
		                    <td style="background-color: black; color: white">Memo</td>
		                </tr>
		                <c:forEach var="customerVO" items="${customerList}">
		                <tr>
		                    <td><a href="/kaikei/account/customerDetail.do?cus_cd=${customerVO.cus_cd}">${customerVO.cus_cd}</a></td>
		                    <td>${customerVO.title}</td>
		                    <td>${customerVO.ceo_name}</td>
		                    <td>${customerVO.memo}</td>
		                </tr>
		                </c:forEach>
		        	</tbody>
	            </table>
	        </div>
	        <div style="height:50px;">
	            <input type="button" style="float:right;" class="button" value="ADD" onclick="location.href='customerAdd.do'">
	        </div>
	    </div>