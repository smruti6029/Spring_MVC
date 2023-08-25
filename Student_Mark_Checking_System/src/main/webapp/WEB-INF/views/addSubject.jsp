<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Grade Input</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
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
  <div class="container">
    <h2>Subject Input</h2>
    <form action="add-subject" method="POST">
      <label for="subject1">Subject 1:</label>
      <input type="text" id="subject1" name="subject1" min="0" max="100" required>

      <label for="subject2">Subject 2:</label>
      <input type="text" id="subject2" name="subject2" min="0" max="100" required>

      <label for="subject3">Subject 3:</label>
      <input type="text" id="subject3" name="subject3" min="0" max="100" required>

      <label for="subject4">Subject 4:</label>
      <input type="text" id="subject4" name="subject4" min="0" max="100" required>

      <label for="subject5">Subject 5:</label>
      <input type="text" id="subject5" name="subject5" min="0" max="100" required>

      <label for="subject6">Subject 6:</label>
      <input type="text" id="subject6" name="subject6" min="0" max="100" required>

      <button type="submit">Submit</button>
    </form>
  </div>
</body>
</html>
