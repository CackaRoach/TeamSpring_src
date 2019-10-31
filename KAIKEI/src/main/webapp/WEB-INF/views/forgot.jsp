<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/kaikei/css/layout.css">
</head>
<script>
	function goData(){
	    var form = document.test;

	    form.elements[0].name = 'company_cd';
	    form.elements[0].value = 'zxc';
	    form.submit();
	}
</script>
<body>
    <div id="header">
    	<div align="center">
			<h1>KAIKEI</h1>
		</div>
    </div>
    <div id="section-only">
		<div align="center">
			<div>
				<input class="button" type="button" onclick="test();" value="Confirm">
				<input class="button" type="button" onclick="location.href='login.do'" value="Cancel">
				<form name="test" action="test.do" method="post">
					<input type="text" name="asd" />
					<input type="button" name="test" onclick="goData();" />
				</form>
			</div>
		</div>
    </div>    
    <div id="footer">
    	<div>
			<h6>footer</h6>
		</div>
   	</div>    
</body>
</html>
		