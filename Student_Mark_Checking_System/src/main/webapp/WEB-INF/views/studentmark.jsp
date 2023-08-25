<%@page import="com.Student.service.StudentGrade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Student.Entity.StudentResult"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 80%; /* Adjust width as needed */
        }

        pre {
            white-space: pre-wrap;
            font-family: "Courier New", monospace;
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            margin-right: 10px;
        }

        .button-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            String name = "";
            String gmail = "";
            Integer roll = 0;
            List<StudentResult> AllSubresult = (List<StudentResult>) request.getAttribute("marks");
            ArrayList<Integer> allMarks = new ArrayList<>();
            double mark = 0;

            if (AllSubresult != null) {
                for (StudentResult res : AllSubresult) {
                    mark += res.getMarks();
                    allMarks.add(res.getMarks());
                    name = res.getStudent().getName();
                    roll = res.getStudent().getId();
                    gmail = res.getStudent().getEmail();
                }

                Double percentage = (mark / 6);
                String Grade = StudentGrade.calculateGrade(percentage, allMarks);
        %>
        <pre>
        ______________________________________
        
        
        
        
        Student Results:

        Name Of The Student: <%= name %>
        Gmail Of the Student: <%= gmail %>
        Student Roll No: <%= roll %>
        ________________________________________

        <% for (StudentResult rs : AllSubresult) { %>
        <%= rs.getSubject().getSubject() %>
        <% try {
            if (rs.get_Is_active() == true) { %>
            Marks: <%= rs.getMarks() %>
            --------------------------
        <%   }
        } catch (Exception e) { }

        if (rs.get_Is_active() == null) { %>
            Marks: <%= rs.getMarks() %>
            --------------------------
        <% }

        try {
            if (rs.get_Is_active() == false) { %>
            updated Marks: <%= rs.getMarks() %>
            --------------------------
        <% }
        } catch (Exception e) { }

        } %>
        Total Marks: <%= mark %>
        Grade: <%= Grade %>
        Percentage: <%= String.format("%.2f", percentage) %>%
        ------------------------
        </pre>
        <%
            } else {
        %>
        <pre>
        Invalid Credentials or Data
        </pre>
        <%
            }
        %>
    </div>
    
    <div class="button-container">
        <form action="reachingApply" method="post">
            <!-- Hidden input field for Gmail ID -->
            <input type="hidden" id="gmail" name="gmail" value="<%=gmail %>">
            <button type="submit">Apply For Recheck</button>
        </form>
        <button onclick="history.go(-1)">Back</button>
    </div>
</body>
</html>
