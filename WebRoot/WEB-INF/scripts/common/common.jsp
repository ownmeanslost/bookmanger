<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
   String path = request.getContextPath();  
   String basePath = request.getScheme() + "://"  
           + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>common</title>

<script type="text/javascript">
/* window.history.forward(-1); */
window.onbeforeunload = function (){};
var contextPath = "<%=path%>";
</script>

<script type="text/javascript" src="scripts/common/common.js"></script>

</head>
<body>

</body>

</html>