<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/css/layout.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	// nav bar highlight
 	$(window).load(function() {
   		var path = window.location.pathname.split('/');
		
		var p_path = path[1];
		var c_path = path[2].slice(0, -3);
		
		if(p_path == "account" || p_path == "manage") {
			$("#nav" + "-" + p_path + "-" + c_path).css("color", "black");
		} else {
			$("#nav" + "-" + p_path).css("color", "black");
		}
		
   		$("#aside-title").html(p_path.toUpperCase());
       	$("#aside" + "-" + p_path).css("display", "block");
       	$("#aside" + "-" + p_path + "-" + c_path).children().addClass("aside-selected");
       				    
    });
</script>
<body style="max-width: 100%">
    <div id="header">
	    <tiles:insertAttribute name="header" />
    </div>
    <div id="nav">
	    <tiles:insertAttribute name="nav" />
    </div>
    <div id="aside">
	    <tiles:insertAttribute name="aside" />
    </div>
    <div id="section">
    	<tiles:insertAttribute name="section" />
    </div>    
    <div id="footer">
	    <tiles:insertAttribute name="footer" />
   	</div>    
</body>
</html>