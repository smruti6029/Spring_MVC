<%@page import="java.util.HashMap"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.Student.service.StudentGrade"%>
<%@page import="java.util.Map"%>
<%@page import="com.Student.Entity.StudentResult"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Results</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Subject</th>
            <th>Mark</th>
        </tr>
        <%
        List<StudentResult> allStudent = (List<StudentResult>) request.getAttribute("get");
        Map<String, Map<String, Integer>> student = new TreeMap<>();
        
        for (StudentResult s : allStudent) {
            String subjectName = s.getSubject().getSubject();
            int marks = s.getMarks();

            if (student.containsKey(s.getStudent().getName())) {
                Map<String, Integer> existingSubjectMarks = student.get(s.getStudent().getName());
                existingSubjectMarks.put(subjectName, marks);
            } else {
                Map<String, Integer> newSubjectMarks = new HashMap<>();
                newSubjectMarks.put(subjectName, marks);
                student.put(s.getStudent().getName(), newSubjectMarks);
            }
        }
        
        for (String studentName : student.keySet()) {
            double mark = 0;
            ArrayList<Integer> allMarks = new ArrayList<>();
            Map<String, Integer> map = student.get(studentName);
        %>
        <tr>
            <td rowspan="<%= map.size() %>"><%= studentName %></td>
            <td><%= map.keySet().iterator().next() %></td>
            <td><%= map.get(map.keySet().iterator().next()) %></td>
        </tr>
        <%
            map.remove(map.keySet().iterator().next());
            for (String sub : map.keySet()) {
        %>
        <tr>
            <td><%= sub %></td>
            <td><%= map.get(sub) %></td>
        </tr>
        <%
                mark += map.get(sub);
                allMarks.add(map.get(sub));
            }
            Double percentage = mark / 6;
            String calculateGradeResult = StudentGrade.calculateGrade(percentage, allMarks);
        %>
        <tr>
            <td colspan="3">Percentage: <%= percentage %>, Grade: <%= calculateGradeResult %></td>
        </tr>
        <%
        }
        %>
    </table>
    
</body>
</html>
