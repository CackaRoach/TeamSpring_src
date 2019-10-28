<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
	
	<div>
		<h3>Manage - User</h3>
	</div>
    
    <div>
    	<p>Search</p>
		<input type = "text" placeholder = "Searching for User">
		<button> Find </button>
	</div>
	
	<table>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Name</th>
				<th>E-mail</th>
				<th>Company</th>
			</tr>
			<c:forEach items = "" var = "">
				<tr>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
				</tr>
		</c:forEach>
		</table>