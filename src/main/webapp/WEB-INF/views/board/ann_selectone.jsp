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
                        <dd>${vo2.an_num}</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>${vo2.an_writer}</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>${vo2.an_date}</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>${vo2.an_vcount}</dd>
                    </dl>
                </div>

                <div class="content">
                    ${vo2.an_content}
                </div>
            </div>

            <div class="bt_wrap">
                <a href="announce_update.do?num=${param.num}">수정</a>
                <a href="announce_delete.do?num=${param.num}" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
            </div>
    
</body>
</html>