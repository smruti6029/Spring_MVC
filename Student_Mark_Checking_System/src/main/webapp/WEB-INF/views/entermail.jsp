<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email Input Page</title>
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
        }

        .input-field {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .submit-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Enter your Gmail</h2>
        <form action="markBygmail" method="post">
            <input class="input-field" type="email" name="gmail" placeholder="Enter your Gmail" required>
            <button class="submit-button" type="submit">Submit</button>
            
            
        </form>
    </div>
    <div class="container">
        <!-- Your existing code here -->

        <div class="back-button">
            <a href="javascript:history.go(-1)">Back</a>
        </div>
</body>
</html>
