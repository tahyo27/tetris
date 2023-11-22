<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>랭킹</title>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>

        table {
            border-collapse: collapse;
            width: 50%;
            margin: auto; 
            margin-top: 50px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center; 
        }

        th {
            background-color: #f2f2f2; 
        }
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>
    <br>
    <table>
        <thead>
            <tr>
                <th>Rank</th>
                <th>Name</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vo" items="${vos}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${vo.name}</td>
                    <td>${vo.score}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>