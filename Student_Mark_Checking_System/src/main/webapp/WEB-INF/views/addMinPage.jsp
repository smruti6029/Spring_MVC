<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
    }

    header {
      background-color: #333;
      color: white;
      text-align: center;
      padding: 1rem;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 2rem;
      background-color: white;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h2 {
      margin-bottom: 1rem;
    }

    a {
      display: block;
      margin-bottom: 10px;
      padding: 10px;
      background-color: #007bff;
      color: white;
      text-align: center;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s;
    }

    a:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <header>
    <h1>Admin Dashboard</h1>
  </header>
  <div class="container">
    <h2>Actions</h2>
    <a href="subject">Add Subject</a>
    <a href="studentAdd">Add Student</a>
    <a href="result">Add Result</a>
    <a href="showAllData">Show Data</a>
    <a href="showApplyForResult">RECHECKING APPLY BY STUDENT</a>
  </div>
</body>
</html>
