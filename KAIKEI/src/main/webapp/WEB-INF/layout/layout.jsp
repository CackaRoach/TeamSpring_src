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
	$(window).ready(function() {
		setTimeout(function() {
			$(".gnb-dth1").hover(function() {
				$(".gnb-bg").css("display", "block");
				$(".gnb-dth2").stop().slideDown(180);
			}, function() {
				$(".gnb-bg").css("display", "none");
				$(".gnb-dth2").stop().slideUp(180);
			});
		
			$(".gnb-dth2").hover(function() {
				$(".gnb-bg").css("display", "block");
				$(".gnb-dth2").stop().slideDown(180);
			}, function() {
				$(".gnb-bg").css("display", "none");
				$(".gnb-dth2").stop().slideUp(180);
			});
		}, 300);
	});
	
 	$(window).load(function() {
   		var path = window.location.pathname.split('/');
   		var pattern = /[\.A-Z]/g;
   		
		var p_path = path[1];
		var c_path = path[2].slice(0, pattern.exec(path[2]).index);

		if(p_path == "account" || p_path == "manage") {
			$("#nav" + "-" + p_path + "-" + c_path).css("color", "black");
		} else {
			$("#nav" + "-" + p_path).css("color", "black");
		}
		
   		$("#aside-title").html(p_path.toUpperCase());
       	$("#aside" + "-" + p_path).css("display", "block");
		// aside bar highlight
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
    <hr id="ln">
    <div id="aside">
	    <tiles:insertAttribute name="aside" />
    </div>
    <div id="section">
    	<tiles:insertAttribute name="section" />
    </div>
    <hr id="ln">
    <div id="footer">
	    <tiles:insertAttribute name="footer" />
   	</div>    
</body>
</html>