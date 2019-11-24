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