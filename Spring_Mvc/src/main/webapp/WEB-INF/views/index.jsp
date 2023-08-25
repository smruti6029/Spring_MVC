<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Laptop List</title>
    <style>
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
            padding: 20px;
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
        String name = (String) request.getAttribute("name");
        ArrayList<String> names = (ArrayList<String>) request.getAttribute("names");

        if (names != null && !names.isEmpty()) {
            for (String s : names) {
        %>
        <p style="color: #007bff;">Laptop : <%= s %></p>
        <%
            }
        } else {
        %>
        <p>No laptop names to display.</p>
        <%
        }
        %>
        <h1>I Need a Laptop: <%= name %></h1>
    </div>
</body>
</html>
