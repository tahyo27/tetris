<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
</head>
<script type="text/javascript">
    function cm_selectAll() {
        console.log('cm_selectAll()....');
        $.ajax({
        url: "cm_selectAll.do",
        data: {
            pram_num: "${param.num}"
        },
        method: 'GET',
        dataType: 'json',
        success: function (obj) {
            console.log('ajax...success:', obj);
            let tag_li = '';
            $.each(obj, function (index, vo){
                tag_li += `<li><div>\${vo.cm_writer}</div>
                    <div>\${vo.cm_content}</div>
                    </li>`;
            })
            $('#comm_list').html(tag_li);
        },
        error: function (xhr, status, error) {
            console.log('xhr.status:', xhr.status);
        }
    });
    } //end cm_selectAll()

    function cm_pInsertOK(){
    console.log('cm_pInsertOK()....');
    let bdnum = "${param.num}";
    let writer = $('#comm_writer').text();
    console.log("파라미터 넘버:" + bdnum + " 글쓴이: " + writer)

    $.ajax({
        url: "cm_pInsertOK.do",
        data: {
            cm_bdnum: bdnum,
            cm_content: $('#comm_content').val(),
            cm_writer: writer
        },
        method: 'GET',
        dataType: 'json',
        success: function (obj) {
            console.log('ajax...success:', obj);
            // if (obj.result == 1) selectAll();
        },
        error: function (xhr, status, error) {
            console.log('xhr.status:', xhr.status);
        }
    });
	
    }//end cm_pInsertOK
</script>
<body onload="cm_selectAll()">
    <%@ include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="board_wrap">
        <div class="board_title">
            <strong>게시판</strong>
        </div>
        <div class="board_one_wrap">
            <div class="board_one">
                <div class="title">
                    ${vo2.bd_title}
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>${vo2.bd_num}</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>${vo2.bd_writer}</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>${vo2.bd_date}</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>${vo2.bd_vcount}</dd>
                    </dl>
                </div>

                <div class="content">
                    ${vo2.bd_content}
                </div>
            </div>
            <div>
                <dl>
                    <dt>첨부파일:</dt>
                    <dd><a href="/attachdown/${vo2.at_num}" style="color:black">${at.at_oname}</a></dd>
                </dl>
                <dl>
                    <c:if test="${img.img_first != 'default.png'}">
                    <dt>이미지:</dt>
                    <dd>
                        <a href="/imgdown/${vo2.img_num}/1" style="color:black">${img.img_ofirst}</a>
                        <img src="/images/${img.img_first}" width="100px" height="100px" style="border-style: solid; border-color: black;">
                    </dd>
                    </c:if>
                    <c:if test="${img.img_second != 'default.png'}">
                        <dd>
                            <a href="/imgdown/${vo2.img_num}/2" style="color:black">${img.img_osecond}</a>
                            <img src="/images/${img.img_second}" width="100px" height="100px" style="border-style: solid; border-color: black;">
                        </dd>
                    </c:if>
                    <c:if test="${img.img_third != 'default.png'}">
                        <dd>
                            <a href="/imgdown/${vo2.img_num}/3" style="color:black">${img.img_othird}</a>
                            <img src="/images/${img.img_third}" width="100px" height="100px" style="border-style: solid; border-color: black;">
                        </dd>
                    </c:if>
                </dl>
            </div>
            <br>
            
            <table border="1">
                <tr>
                    <td>댓글</td>
                    <td id="comm_writer">asdf123</td>
                    <td><input type="text" id="comm_content" value="댓글입니다."></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button onclick="cm_pInsertOK()">댓글작성</button></td>
                </tr>
            </table>

            <div>
                <h3>댓글 리스트</h3>
                <div>
                    <ul id="comm_list">
                    </ul>

                </div>
            </div>



            <div class="bt_wrap">
                <a href="bd_update.do?num=${param.num}">수정</a>
                <a href="bd_delete.do?num=${param.num}">삭제</a>
            </div>
    
</body>
</html>