<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
</head>

<body>
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="board_wrap">
        <div class="board_title">
            <strong>글 수정</strong>
        </div>
        <form action="bd_updateOK.do" method="post" id="bd_updateform" enctype="multipart/form-data">
            <div class="board_write_wrap">
                <div class="board_write">
                    <div class="title">
                        <dl>
                            <dt>제목</dt>
                            <dd><input type="text" placeholder="제목 입력" name="bd_title" value="${vo2.bd_title}"></dd>
                        </dl>
                    </div>
                    <div class="info">
                        <dl>
                            <dt>글쓴이</dt>
                            <dd><input type="hidden" placeholder="글쓴이 입력" name="bd_writer">${vo2.bd_writer}</dd>
                        </dl>
                        <dl>
                            <dt>비밀번호</dt>
                            <dd><input type="password" placeholder="비밀번호 입력" name="bd_pwd" value="${vo2.bd_pwd}"></dd>
                        </dl>
                    </div>
                    <div class="cont">
                        <textarea placeholder="내용 입력" name="bd_content">${vo2.bd_content}</textarea>
                    </div>
                    <div>
                        <input type="hidden" name="bd_num" value="${vo2.bd_num}">
                    </div>
                </div>
                <div class="bt_wrap">
                    <a id="submitbt" class="on">수정</a>
                </div>
            </div>
        </form>
    </div>
    

    <script type="text/javascript">
        document.querySelector('#submitbt').addEventListener('click', function(event){     
            document.querySelector('#bd_updateform').submit();
        })
    </script>
</body>
</html>