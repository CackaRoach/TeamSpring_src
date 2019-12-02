<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
			<h3>Reports - Profit and Loss</h3>
		</div>
		<div align="center">
			<div>
				<input type="button" onClick="" value="<">
				2019 - 3Q
				<input type="button" onClick="" value=">">
			</div>
			<p></p>
			<table border="1" style="border-collapse:collapse">
			  <tr>
			    <th colspan="2">Subject</th>
			    <th colspan="2">Amount</th>
			  </tr>
			  <tr>
			    <td colspan="2">Sales</td>
			    <td></td>
			    <td>${PL_dataList[0]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Wonga</td>
			    <td></td>
			    <td>${PL_dataList[1]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Gross profit</td>
			    <td></td>
			    <td>${PL_dataList[2]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Selling and administrative</td>
			    <td></td>
			    <td>${PL_dataList[3]}</td>
			  </tr>
			  <tr>
			   <td colspan="2">Operating profit</td>
			    <td></td>
			    <td>${PL_dataList[4]}</td>
			  </tr>
			  <tr>
			   	<td colspan="2">Non-operating Income</td>
			    <td></td>
			    <td>${PL_dataList[5]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Non-operating expenses</td>
			    <td></td>
			    <td>${PL_dataList[6]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Income before Tax</td>
			    <td></td>
			    <td>${PL_dataList[7]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Income Tax</td>
			    <td></td>
			    <td>${PL_dataList[8]}</td>
			  </tr>
			  <tr>
			    <td colspan="2">Net Income</td>
			    <td></td>
			    <td>${PL_dataList[0]}</td>
			  </tr>
			</table>
			<p></p>
		</div>