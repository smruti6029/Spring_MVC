<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Click Here</title>
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
        .link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }
        .link:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Click the Link</h1>
        <p>Click the link below to navigate to the destination.</p>
        <a class="link" href="http://localhost:8080/Spring_Mvc/show">Click here</a>
    </div>
</body>
</html>
