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
<script>
	$(window).load(function() {
		setTimeout(function() {
	       	$(".gnb-dth1").hover(function() {
	       		$(".gnb-dth2").stop().slideDown(180);
				
	        }, function() {
	        	$(".gnb-dth2").stop().slideUp(180);
	        });
	
	       	$(".gnb-dth2").hover(function() {
	       		$(".gnb-dth2").stop().slideDown(180);
	        }, function() {
	        	$(".gnb-dth2").stop().slideUp(180);
	    });
	    
	   	}, 300);
	});
</script>
<body style="max-width: 100%">
    <div id="header">
	    <tiles:insertAttribute name="header" />
    </div>
    <div id="nav">
	    <tiles:insertAttribute name="nav" />
    </div>
    <div id="section-home">
    	<tiles:insertAttribute name="section" />
    </div>    
    <div id="footer">
	    <tiles:insertAttribute name="footer" />
   	</div>    
</body>
</html>