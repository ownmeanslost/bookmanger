<%@ page contentType="image/jpeg"%>  
<jsp:useBean id="image" scope="page"  
    class="com.bookmanger.common.utils.MakeCertPic" />  
  
<%  
    String str = image.getCerPic(0, 0, response.getOutputStream());  
    session.setAttribute("certCode", str);  
      
    out.clear();  
    out = pageContext.pushBody();  
%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图书管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
<input type="hidden" value="<%= str%>" id="sss">
</body>
<script type="text/javascript">

	alert($("#sss").val());
</script>
</html>
