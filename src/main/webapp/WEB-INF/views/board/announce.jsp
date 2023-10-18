<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BOARD</title>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

    
<script type="text/javascript">
    function announceOne(element) {
        console.log("announceOne()...");
        let num = element.getAttribute("data_an_num");
        console.log(num);
        window.location.href = "/announceOne.do?num=" + num;
}


</script>
</head>
<body>
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>
    
    <div class="board_wrap">
        <div class="board_title">
            <strong>공지사항</strong>
        </div>
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                    <div class="count">조회</div>
                </div>
                <c:forEach var="vo" items="${vos}">
                    <div class="content" onclick="announceOne(this)" data_an_num="${vo.an_num}">
                        <div class="num">${vo.an_num}</div>
                        <div class="title">${vo.an_title}</div>
                        <div class="writer">${vo.an_writer}</div>
                        <div class="date"><fmt:formatDate value="${vo.an_date}" pattern="yyyy-MM-dd" /></div>
                        <div class="count">${vo.an_vcount}</div>
                    </div>
                </c:forEach>
            </div>

            <div class="board_page">
                <a href="#" class="bt first"><<</a>
                <a href="#" class="bt prev"><</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="num">4</a>
                <a href="#" class="num">5</a>
                <a href="#" class="bt next">></a>
                <a href="#" class="bt last">>></a>
            </div>
            <div class="bt_wrap">
                <a href="announce_insert.do" class="on" >등록</a>
                <a href="#" class="on">목록</a>
            </div>
        </div>
    </div>
</body>
</html>