<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<title>这是一个jsp页面</title>
</head>
<body>
   <h2>这里是jsp的页面</h2>
   请求host:<%=request.getRemoteHost() %><br/>
  请求地址:  <%=request.getRemoteAddr() %><br/>
 请求端口:<%=request.getRemotePort() %><br/>
 请求用户:<%=request.getRemoteUser() %>
 
</body>
</html>