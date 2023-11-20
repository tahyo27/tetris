<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>tetris</title>
    <link rel="stylesheet" href="css/style.css">
	<script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/hfcss.css">
   
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:wght@500&display=swap" rel="stylesheet">
    <script src="js/navbar.js" defer></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="wrapper">
		<div class="game-text">
			<span>게임종료</span>
			<button id="restartBtn" style="margin-top: 10px;">다시시작</button>
            <div class="myModal">
                <div class="modal-content">
                    <div>이름</div>
                    <form action="sc_insertOK.do" method="post" id="scoreForm">
                        <input type="text" id="name" name="name" required>
                        <input type="hidden" class="save_score" name="score">
                        <button type="submit">저장</button>
                    </form>
                </div>
            </div>
		</div>
        <div class="score1">Lv : 1</div>
		<div class="score">0</div>
		<div class="playground">
			<ul></ul>
		</div>
        <div class="game-start">
            <button class="startBtn">게임시작</button>
        </div>
	</div>

    <%@ include file="/WEB-INF/views/comm/footer.jsp"%>
    
	<script src="js/tetris.js" type="module"></script>
</body>
</html>