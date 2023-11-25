<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글</title>
    <script src="https://kit.fontawesome.com/ab151a372f.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../css/boardcss.css">
    <link rel="stylesheet" href="css/hfcss.css">
    <style>
        .modal {
          display: none;
          position: fixed;
          z-index: 1;
          left: 0;
          top: 0;
          width: 100%;
          height: 100%;
          overflow: auto;
          background-color: rgba(0,0,0,0.4);
        }
        
        .modal-content {
          background-color: #fefefe;
          margin: 15% auto;
          padding: 20px;
          border: 1px solid #888;
          width: 30%;
        }
        
        .close {
          color: #aaa;
          float: right;
          font-size: 28px;
          font-weight: bold;
        }
        
        .close:hover,
        .close:focus {
          color: black;
          text-decoration: none;
          cursor: pointer;
        }
        </style>
</head>
<script>
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
            let step = 0;
            $.each(obj, function (index, vo){
                step = vo.cm_step*10;
                tag_li += `
                    <div>
                        <li style="border-bottom: 1px solid gray; margin-left:\${step}px;" >
                            <div style="align-items:center;">
                                <div>글쓴이 : \${vo.cm_writer}</div>
                            </div>
                            <div style="display:flex; justify-content: flex-end;">
                                <div style="text-align:right; cursor:pointer; margin-right:10px;">수정</div>
                                <div onclick="showReply(\${vo.cm_num})" style="color:black; cursor:pointer; text-align:right;">댓글달기</div>
                            </div>
                            <div>
                                <div>\${vo.cm_content}</div>
                            </div>
                        </li>
                        <div style="display:none;" id="replyDiv\${vo.cm_num}">
                            <div style="margin-top:10px;">
                                아이디:<input type="text" id="reply_writer\${vo.cm_num}"></input>
                                비밀번호:<input type="password" id="reply_pwd\${vo.cm_num}"></input>
                            </div>
                            <textarea cols="123" rows="5" style="resize:none; border:1px solid black; margin-top:5px;" id="comm_txtarea\${vo.cm_num}">답글 열리는거 테스트
                            </textarea>
                            <div onclick="cm_sInsertOK(\${vo.cm_num})" style="color:black; cursor:pointer; text-align:center; border:1px solid black; background-color: gainsboro; color: black; font-weight: 400;" >작성하기</div>
                        </div>
                    </div>
                    `;
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
    let writer = $('#comm_writer').val();
    let pwd = $('#comm_pwd').val();
    console.log("파라미터 넘버:" + bdnum + " 글쓴이: " + writer)

    $.ajax({
        url: "cm_pInsertOK.do",
        data: {
            cm_bdnum: bdnum,
            cm_pwd: pwd,
            cm_content: $('#comm_content').val(),
            cm_writer: writer
        },
        method: 'GET',
        dataType: 'json',
        success: function (obj) {
            console.log('ajax...success:', obj);
            if (obj.result == 1) cm_selectAll();
        },
        error: function (xhr, status, error) {
            console.log('xhr.status:', xhr.status);
        }
    });
	
    }//end cm_pInsertOK

    function cm_sInsertOK(num) {
        console.log('cm_sInsertOK()....num:' + num);
        let writer = $('#reply_writer' + num).val();;
        let pwd = $('#reply_pwd' + num).val();
        let bdnum = "${param.num}";
        let pnum = num;
        $.ajax({
        url: "cm_sInsertOK.do",
        data: {
            cm_bdnum: bdnum,
            cm_content: $('#comm_txtarea' + num).val(),
            cm_writer: writer,
            cm_pwd: pwd,
            cm_pnum : pnum
        },
        method: 'GET',
        dataType: 'json',
        success: function (obj) {
            console.log('ajax...success:', obj);
            if (obj.result == 1) cm_selectAll();
        },
        error: function (xhr, status, error) {
            console.log('xhr.status:', xhr.status);
        }
    });
    }//end cm_cm_sInsertOK

    function showReply(num) {
        console.log('showReply()....');

        let replyDiv = document.getElementById("replyDiv" + num);

        if (replyDiv.style.display === "none") {
            replyDiv.style.display = "block";
        } else {
            replyDiv.style.display = "none"; //한번 더 누르면 다시 안보이게
        }
    }

    function openPasswordModal() {
        document.getElementById('passwordModal').style.display = 'block';
    }

    function closePasswordModal() {
        document.getElementById('passwordModal').style.display = 'none';
    }

    function checkPassword() {
        let password = document.getElementById('modalPassword').value;
        let num = '${param.num}';
        console.log(num);

        if('${vo2.bd_pwd}' === password) {
            window.location.href = "bd_update.do?num=" + num;
        } else {
            alert("비밀번호가 틀립니다");
        }
        
    }

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
            
            <div>
                <div>댓글 쓰기
                    <div style="margin-top:10px;">
                        아이디:<input type="text" id="comm_writer"></input>
                        비밀번호:<input type="password" id="comm_pwd"></input>
                    </div>
                    <div style="margin-top:5px;">
                        <textarea id="comm_content" cols="123" rows="5" style="resize:none; border:1px solid black;"></textarea>
                    </div>
                </div>
                <div style="text-align: center;">
                   <div onclick="cm_pInsertOK()" style="cursor: pointer; border:1px solid black; background-color: gainsboro; color: black; font-weight: 400;">등록</div>
                </div>
            </div>

            <div style="margin-top: 20px;">
                <h3>댓글 리스트</h3>
                <div>
                    <ul id="comm_list">
                    </ul>

                </div>
            </div>



            <div class="bt_wrap">
                <a href="javascript:void(0);" onclick="openPasswordModal()">수정</a>
                <a href="bd_delete.do?num=${param.num}">삭제</a>
            </div>

            <div id="passwordModal" class="modal">
                <div class="modal-content">
                  <span class="close" onclick="closePasswordModal()">&times;</span>
                  <label for="modalPassword">비밀번호를 입력하세요:</label>
                  <input type="password" id="modalPassword">
                  <button onclick="checkPassword()">확인</button>
                </div>
            </div>
    
</body>
</html>