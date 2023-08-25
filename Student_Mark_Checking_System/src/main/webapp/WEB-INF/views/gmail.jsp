<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student Marks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        .container {
            width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            text-align: center;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        button[type="submit"] {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Update Student Marks</h2>
    
    <form action="updateStudentmark" method="post">
        <label for="gmail">Enter Gmail:</label>
        <input type="email" id="gmail" name="gmail" required>
        <br>
        <button type="submit">Update Marks</button>
    </form>
</div>

</body>
</html>
