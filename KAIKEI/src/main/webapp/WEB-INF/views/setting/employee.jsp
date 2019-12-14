<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			<table>
				<thead>
					<tr>
						<td style="width:201px">ID</td>
						<td style="width:200px">Name</td>
						<td style="width:200px">E-mail</td>
						<td style="width:180px">Phone</td>
						<td style="width:180px">Rank</td>
						<td style="width:200px">State</td>
					</tr>
				</thead>
				<tbody>

				<c:forEach var="item" items="${acceptedList}">
					<tr>
						<td><label>${item.id}</label></td>
	    				<td><label>${item.name}</label></td>
		    			<td><label>${item.email}</label></td>
		    			<td><label>${item.phone}</label></td>
		    			<td><label>${item.posit_cd}</label></td>
		    			<td><input type="Button" value="delete" onClick="location.href='/setting/employeeDelete.do?id=${item.id}'"/></td>
					</tr>
				</c:forEach>

				</tbody>
			</table>

			<table>
				<thead>
					<tr>
						<td style="width:200px">ID</td>
						<td style="width:200px">Name</td>
						<td style="width:200px">E-mail</td>
						<td style="width:180px">Phone</td>
						<td style="width:200px">State</td>
					</tr>
				</thead>
				<tbody>

				<c:forEach var="item" items="${waitingList}">
					<tr>
						<td><label>${item.id}</label></td>
	    				<td><label>${item.name}</label></td>
		    			<td><label>${item.email}</label></td>
		    			<td><label>${item.phone}</label></td>
		    			<td><input type="Button" value="accept" onClick="location.href='/setting/employeeAccept.do?id=${item.id}'"/></td>
					</tr>
				</c:forEach>

				</tbody>
			</table> 