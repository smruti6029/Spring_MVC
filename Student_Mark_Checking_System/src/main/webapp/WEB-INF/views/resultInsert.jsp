<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Subject Marks Input</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .container {
      max-width: 400px;
      padding: 2rem;
      background-color: white;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
    }

    input[type="number"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-bottom: 16px;
    }

    input[type="hidden"] {
      display: none;
    }

    button {
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      padding: 10px 20px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<%
		String gmail=(String) request.getAttribute("gmail");

%>
<form action="processingMark" method="post">
  <div class="container">
    <h2>Enter Subject Marks</h2>
    
      <label for="subject1">Java:</label>
      <input type="number" id="Java" name="Java" min="0" max="100" required>

      <label for="subject2">C:</label>
      <input type="number" id="C" name="C" min="0" max="100" required>

      <label for="subject3">Python:</label>
      <input type="number" id="Python" name="Python" min="0" max="100" required>

      <label for="subject4">React:</label>
      <input type="number" id="React" name="React" min="0" max="100" required>

      <label for="subject5">DBMS:</label>
      <input type="number" id="DBMS" name="DBMS" min="0" max="100" required>

      <label for="subject6">OS:</label>
      <input type="number" id="OS" name="OS" min="0" max="100" required>

      <!-- Hidden input field for Gmail ID -->
      <input type="hidden" id="gmail" name="gmail" value="<%=gmail %>">


      <button type="submit">Submit</button>
    
  </div>
  </form>
</body>
</html>
