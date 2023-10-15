<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
   
</head>
<body>
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="board_wrap">
        <div class="board_title">
            <strong>공지사항</strong>
        </div>
        <div class="board_one_wrap">
            <div class="board_one">
                <div class="title">
                    글 제목이다
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>1</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>운영자</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>regdate</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>133</dd>
                    </dl>
                </div>

                <div class="content">
                    글내용<br>
                    글내용<br>
                    글내용<br>
                    글내용<br>
                    글내용<br>
                    글내용<br>

                </div>
            </div>

            <div class="bt_wrap">
                <a href="#" class="on">목록</a>
                <a href="#">수정</a>
            </div>
    
</body>
</html>