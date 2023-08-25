<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Successfully</title>
<style type="text/css">


body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            text-align: center;
            padding: 10px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        p {
            margin: 10px 0;
            color: #333;
        }
        h1 {
            margin: 20px 0;
            font-size: 24px;
            color: #ff6600;
        }

</style>


</head>
<body>
	<div class="container">
<%
			String username=(String)request.getAttribute("name");
			String password=(String)request.getAttribute("password");
			
			%>
	        <p style="color: #007bff;">Register Successfully   : <%= username %></p>
	        <%

%>
</div>
</body>
</html>