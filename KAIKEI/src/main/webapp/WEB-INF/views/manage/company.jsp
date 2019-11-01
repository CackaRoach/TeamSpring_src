<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
			<h3>Manage - Company</h3>
		</div>
		
		<div>
			<input type = "text" placeholder="Search for Company">
			<button>FIND</button>
		</div>
		
		<select>
			<option value="">ALL</option>
			<option value="">ACCEPT</option>
			<option value="">RESULT</option>
			<option value="">HOLD OFF</option>
		</select>
		
		<div>
			<thead>
				<tr>
					<th></th>
					<th>Code</th>
					<th>Company</th>
					<th>CEO</th>
					<th>Domain</th>
					<th>Phone</th>
					<th>State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="" items="$" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>
						<td>
						<td>
						<td>
						<td>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</div>
		