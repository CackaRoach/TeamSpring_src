<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>Title</title>
    <link rel= "stylesheet" type="text/css" href="/kaikei/css/layout.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	function changeForm(form) {
		if(form == 'exist') {
			document.getElementById('exist').style.display = 'block';
			document.getElementById('new').style.display = 'none';
		} else {
			document.getElementById('exist').style.display = 'none';
			document.getElementById('new').style.display = 'block';
		}
	}

	function formCheck() {
		console.log(register.id.value);
		console.log(register.companycode.value);
		return true;
	}
	
</script>
<body>
    <div id="header"><tiles:insertAttribute name="header" />
    </div>
    <div id="section-only"><tiles:insertAttribute name="section" />
    </div>    
    <div id="footer"><tiles:insertAttribute name="footer" />
   	</div>    
</body>
</html>