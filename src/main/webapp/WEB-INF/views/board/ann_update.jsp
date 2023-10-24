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
            <strong>공지사항</strong>
        </div>
        <form action="ann_updatetOK.do" method="post" id="an_updateform">
            <div class="board_write_wrap">
                <div class="board_write">
                    <div class="title">
                        <dl>
                            <dt>제목</dt>
                            <dd><input type="text" name="an_title" value="${vo2.an_title}"></dd>
                        </dl>
                    </div>
                    <div class="info">
                        <dl>
                            <dt>글쓴이</dt>
                            <dd><input type="hidden" name="an_writer"><span>${vo2.an_writer}</span></dd>
                        </dl>
                        <dl>
                            <dt>비밀번호</dt>
                            <dd><input type="password" name="an_pwd" value="${vo2.an_pwd}"></dd>
                        </dl>
                    </div>
                    <input type="hidden" name="an_num" value="${vo2.an_num}">
                    <div class="cont">
                        <textarea placeholder="내용 입력" name="an_content" >${vo2.an_content}</textarea>
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
            document.querySelector('#an_updateform').submit();
        })
    </script>
</body>
</html>