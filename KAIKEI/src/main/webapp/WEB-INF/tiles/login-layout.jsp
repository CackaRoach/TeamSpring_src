<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>Title</title>
    <link rel= "stylesheet" type="text/css" href="css/layout.css">
</head>
<body>
    <div id="header"><tiles:insertAttribute name="header" />
    </div>
    <div id="section-only"><tiles:insertAttribute name="section" />
    </div>    
    <div id="footer"><tiles:insertAttribute name="footer" />
   	</div>    
</body>
</html>