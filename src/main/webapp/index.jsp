<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/d" prefix="jsp"%>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>jspboard</title>
    <meta charset="utf-8" http-equiv="Content-Type" content="text/html;">
    <meta name="viewport" content="width=device-width", initial-scale="1">
    <link rel="stylesheet" type="text/css" href="${path}/css/styles.css" />

</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <div class="wrap">
        <header>
            <div class="header-wrap">

                <table class="title-nav">
                    <tr>
                        <td><h1 class="page-title">문의하기</h1></td>
                        <td>처음화면</td>
                        <td>글쓰기</td>
                        <td>로그인</td>
                    </tr>
                </table>
            </div>
        </header>
        <main>
            <div class="main-wrap">

<%--        <jsp:useBean class="com.green.model.WritingForm" id="postForm" scope="page"></jsp:useBean>--%>
                <form:form action="cs/notice" method="post" role="form" autocomplete="off" >
                    <table>
                        <thead>
                        게시판 글쓰기
                        </thead>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" id="title" placeholder="최대 30자"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><input type="text" name="contents" id="contents" placeholder="최대 약 200자"></td>
                        </tr>
                        <tr>
                            <td>작성자</td>
                            <td><input type="text" name="writer"id="writer"></td>
                        </tr>
                        <tr>
                            <td>작성자이메일</td>
                            <td><input type="text" name="email"id="mail"></td>
                        </tr>
                        <tr>
                            <td>숫자1</td>
                            <td><input type="number" name="num1"id="num1"></td>
                        </tr>
                        <tr>
                            <td>숫자2</td>
                            <td><input type="number" name="num2"id="num2"></td>
                        </tr>
                    </table>
                </form:form>

                <div class="buttons">
                        <button type="submit" id="btn-submit">submit</button>
                        <button type="reset" value="취소">취소</button>
                </div>
            </div>

        </main>
    </div>
<%--wrap--%>

        <footer>
            <p>2023.12.5 게시판</p>
        </footer>

    </div>

    <script type="text/javascript">
        $("#btn-submit").on("click",function(){
            var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            //메일형식을 확인하는 정규식
            var jsTitle = $("#title");
            var jsContents = $("#contents");
            var jswriter = $("#writer");
            var jswritersMail=$("#email");
            var jsnum1 = $("#num1");
            var jsnum2 = $("#num2");

            console.log(regEmail)
            console.log(jsTitle)
            console.log(jsContents)
            console.log(jswriter)

            if(jsTitle==="" || jsTitle ===null){
                alert("제목을 입력해 주시죠?");
                jsTitle.focus();
                return false;
            }
            if(jscontents===""|| jscontents===null){
                alert("내용을 입력해 주시죠?");
                jsContents.focus();
                return false;
            }
            if(jswriter===""|| jswriter===null){
                alert("작성자 이름은요?");
                jswriter.focus();
                return false;
            }
            if(jswritersMail===""|| jswritersMail===null){
                alert("메일주소를 입력하세요!");
                jswritersMail.focus();
                return false;
            }
            if(!regEmail.test(jswritersMail.val())){
                alert("이메일형식에 맞게 입력해주세요.");
                $("jswritersMail").focus();
                return false;
            }
            //모든게 null이 아니고 이메일 유효성 검사도 통과했을때
            //아직 숫자는 옵션

            if(confirm("json으로 전송하시겠습니가?")){
                var params = "";
                //JSON형식으로 변환하는 작업쓰
                params={
                    "title":jsTitle.val()
                    , "contents":jsContents.val()
                    , "writer":jswriter.val()
                    , "mail":jswritersMail.val()
                    , "num1":jsnum1.val()
                    , "num2":jsnum2.val()
                }
            }
            $.post({
                crossOrigin:true
                , url:"http://localhost:8090/cs/notice"
                , type:"post"
                , data : JSON.stringify(params)
                , success:function (data){
                    alert("게시판에 글을 올린것 같기도하고 ?")
                },
                error:function (data,status,err){
                    var element=$(document.body);

                    alert("에러다 휴먼");
            },
                complete : function (){
                    alert("complete를 지나간다")
                }
                });

        })
    </script>


</body>
</html>