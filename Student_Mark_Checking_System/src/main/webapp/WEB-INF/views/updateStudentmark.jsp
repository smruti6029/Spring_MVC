<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student Marks</title>
    <style>
        .container {
            width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            text-align: center;
        }
        
        .message {
            display: none;
            margin-bottom: 10px;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
        }
        
        select, input[type="number"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 15px;
        }
        
        button[type="submit"], button[type="button"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        
        button[type="submit"]:hover, button[type="button"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<%
		String gmail = (String) request.getAttribute("gmail");
		out.println(gmail);
%>

<div class="container">
    <h2>Update Student Marks</h2>
    
    <div class="message">
        Gmail: <%= gmail %>
    </div>
    
    <form action="updateMark" method="post" onsubmit="return showMessage()">
        <label for="subject">Select Subject:</label>
        <select id="subject" name="subject" required>
            <option value="Java">Java </option>
            <option value="Python">Python</option>
            <option value="Recat">React</option>
            <option value="DBMS">DBMS</option>
            <option value="OS">OS</option>
            <option value="C">C</option>
        </select><br>
        
        <label for="marks">Marks:</label>
        <input type="number" id="mark" name="mark" required><br>
        <input type="hidden" id="gmail" name="gmail" value="<%= gmail %>">
        
        <button type="submit">Update Marks</button>
        <button type="button" onclick="goBack()">Back</button>
    </form>
    
    <div id="message" class="message">Marks updated!</div>
    
    <script>
        function showMessage() {
            var messageDiv = document.getElementById("message");
            messageDiv.style.display = "block";
            return true; // Allow the form to submit
        }
        
        function goBack() {
            window.history.back();
        }
    </script>
</div>

</body>
</html>





 
