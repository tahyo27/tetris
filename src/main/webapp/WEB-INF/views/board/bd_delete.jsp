<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>delete</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .delete-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .delete-container h2 {
            color: #333;
        }

        .delete-form {
            margin-top: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="delete-container">
        <h2>게시글 삭제</h2>
        <form class="delete-form" action="bd_deleteOK.do" method="post" onsubmit="return confirmDelete()">
            <div class="form-group">
                <label for="username">Writer</label>
                <input type="text" id="bd_writer" name="bd_writer" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="bd_pwd" name="bd_pwd" required>
            </div>
            <div class="form-group">
                <button type="submit">Delete</button>
            </div>
            <div>
                <input type="hidden" name="bd_num" value="${param.num}">
            </div>
        </form>
    </div>

    <script>
        function confirmDelete() {
            let isConfirmed = window.confirm("삭제하시겠습니까?");
            return isConfirmed;
        }
    </script>
</body>
</html>