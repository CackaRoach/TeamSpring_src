<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div>
			<h3>Balance Sheet</h3>
		</div>
		<hr>
		<div align="center">
		<div>
			<input type="button" onClick="" value="<">
			2019 - 3Q
			<input type="button" onClick="" value=">">
		</div>
		<p></p>
		<table border="1" style="border-collapse:collapse">
		  <tr>
		    <th colspan="3">Assets</th>
		    <th colspan="3">Liabilities</th>
		  </tr>
		  <tr>
		    <td rowspan="2">Current Assets</td>
		    <td colspan="2" rowspan="2">
		    	<c:out value="${BS_dataList[0]}" />
	    	</td>
		    <td>Current Liabilities</td>
		    <td colspan="2"><c:out value="${BS_dataList[2]}" /></td>
		  </tr>
		  <tr>
		    <td>Long-term Liabilities</td>
		    <td colspan="2"><c:out value="${BS_dataList[3]}" /></td>
		  </tr>
		  <tr>
		    <td rowspan="2">Fixed Assets</td>
		    <td colspan="2" rowspan="2">
				<c:out value="${BS_dataList[1]}" />
			</td>
		    <th colspan="3">Capital</th>
		  </tr>
		  <tr>
		    <td>capital Stock</td>
		    <td colspan="2"><c:out value="${BS_dataList[4]}" /></td>
		  </tr>
		  <tr>
		    <td colspan="3" rowspan="2"></td>
		    <td>Capital surplus</td>
		    <td colspan="2"><c:out value="${BS_dataList[5]}" /></td>
		  </tr>
		</table>
		<p></p>
		<p></p>
		</div>
		