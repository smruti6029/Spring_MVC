<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.Student.Entity.StudentResult"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Results</title>
</head>
<body>

<%
    List<StudentResult> AllSubresult = (List<StudentResult>) request.getAttribute("AllSubresult");
    int check = 0;

    // Create a map to store the number of subjects for each student
    Map<Integer, Integer> numberOfSubjectsMap = new HashMap<>();
    for (StudentResult result : AllSubresult) {
        int studentId = result.getStudent().getId();
        numberOfSubjectsMap.put(studentId, numberOfSubjectsMap.getOrDefault(studentId, 0) + 1);
    }
%>

<table border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Gmail</th>
            <th>Subject</th>
            <th>Marks</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (StudentResult result : AllSubresult) {
                try {
                    if (result.get_Is_active() != null) {
                        if (result.get_Is_active() && result.getStudent().getId() != check) {
                            check = result.getStudent().getId();
                            int rowspanValue = numberOfSubjectsMap.get(check);
        %>
                            <tr>
                                <td rowspan="<%= rowspanValue %>"><%= result.getStudent().getName() %></td>
                                <td rowspan="<%= rowspanValue %>"><%= result.getStudent().getEmail() %></td>
        <%
                        }
        %>
                        <td><%= result.getSubject().getSubject() %></td>
                        <td><%= result.getMarks() %></td>
                    </tr>
        <%
                    }
                } catch (Exception e) {
                }
            }
        %>
    </tbody>
</table>

    </tbody>
</table>
				<p><a href=gmail>Update</a></p>
</body>
</html>
