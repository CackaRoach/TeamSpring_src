<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
			<h3>Company</h3>
		</div>
		
		<div>
			<input type = "text" placeholder = "Searching for Company">
			<button> Find </button>
		</div>
		
		<select>
			<option> All </option>
			<option> ACCEPT </option>
			<option> REJECTE </option>
			<option> HOLD OFF </option>
		</select>
		
		
		<table>
			<tr>
				<th>Code</th>
				<th>Company</th>
				<th>CEO</th>
				<th>Domain</th>
				<th>Phone</th>
				<th>State</th>
			</tr>
			<c:forEach items = "" var = "">
				<tr>
					<td>
					</td>
				</tr>
		</c:forEach>
		</table>
		
		
		