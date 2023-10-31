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
        function boardOne(element) {
            let num = element.getAttribute("data_bd_num");
            // console.log(num);
            window.location.href = "/bd_selectone.do?num=" + num;
    }
    
    
    </script>
</head>
<body>
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>
    <div class="board_wrap">
        <div class="board_title">
            <strong>게시판</strong>
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
                    <div class="content" onclick="boardOne(this)" data_bd_num="${vo.bd_num}">
                        <div class="num">${vo.bd_num}</div>
                        <div class="title">${vo.bd_title}</div>
                        <div class="writer">${vo.bd_writer}</div>
                        <div class="date"><fmt:formatDate value="${vo.bd_date}" pattern="yyyy-MM-dd" /></div>
                        <div class="count">${vo.bd_vcount}</div>
                    </div>
                </c:forEach>
            </div>

            <div class="board_page">
                <c:if test="${paging.startPage != 1 }">
                    <a href="bd_selectAll.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}" class="bt prev">&lt;</a>
                    </c:if>
                    <c:forEach var="p" begin="${paging.startPage }"
                            end="${paging.endPage }">
                        <c:choose>
                            <c:when test="${p == paging.nowPage }">
                                    <a class="num on">${p }</a>
                            </c:when>
                            <c:when test="${p != paging.nowPage }">
                                    <a href="bd_selectAll.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}" class="num">${p }</a>
                            </c:when>
                            </c:choose>
                    </c:forEach>
                    <c:if test="${paging.endPage != paging.lastPage}">
                        <a href="bd_selectAll.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}" class="bt next">&gt;</a>
                    </c:if>
            </div>
            <div class="bt_wrap">
                <a href="bd_insert.do" class="on">글쓰기</a>
                <!-- <a href="#">수정</a> -->
            </div>
        </div>
    </div>
</body>
</html>