<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/d" prefix="jsp"%>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>jspboard-writing</title>
    <meta charset="utf-8" http-equiv="Content-Type" content="text/html;">
    <meta name="viewport" content="width=device-width", initial-scale="1">

</head>
<body>
    <div class="wrap">
        <header>
            <h1>게시판글쓰기</h1>
        </header>
        <table>
            <tr>
            <td>처음화면</td>
            <td>글쓰기</td>
            <td>로그인</td>
            </tr>
        </table>

<%--        <jsp:useBean class="com.green.model.WritingForm" id="postForm" scope="page"></jsp:useBean>--%>
        <form action=".result.jsp" method="post" role="form" autocomplete="off">
            <table>
                <thead>
                <h2>게시판 글쓰기</h2>
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
                <tr>
                   <td> <button type="submit" class="btn-submit">submit</button></td>
                    <td><button type="reset" value="취소">취소</button></td>
                </tr>
            </table>


        </form>

        <footer>
            <p>2023.12.5 게시판</p>
        </footer>

    </div>

    <script type="text/javascript">
        $(".btn-submit").click(function(){
            var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            //메일형식을 확인하는 정규식
            var jsTitle = $(".title");
            var jsContents = $(".contents");
            var jswriter = $(".writer");
            var jswritersMail=$(".email");
            var jsnum1 = $(".num1");
            var jsnum2 = $(".num2");

            if(jsTitle===""|| jsTitle===null){
                alert("제목을 입력해 주시죠?");
                jsTitle.focus();
            }
            if(jscontents===""|| jscontents===null){
                alert("내용을 입력해 주시죠?");
                jsContents.focus();
            }
            if(jswriter===""|| jswriter===null){
                alert("작성자 이름은요?");
                jswriter.focus();
            }
            if(jswritersMail===""|| jswritersMail===null){
                alert("메일주소를 입력하세요!");
                jswritersMail.focus();
            }
            if(!regEmail.test(jswritersMail.val())){
                alert("이메일형식에 맞게 입력해주세요.");
                $("jswritersMail").focus();
                return false;
            }
            //모든게 null이 아니고 이메일 유효성 검사도 통과했을때
            //아직 숫자는 옵션

            if(confirm("전송하시겠습니가?")){
                var params = "";
                //JSON형식으로 변환하는 작업쓰
                params={
                    title:jsTitle.val()
                    , contents:jsContents.val()
                    , writer:jswriter.val()
                    , mail:jswritersMail.val()
                    , num1:jsnum1.val()
                    , num2:jsnum2.val()
                }
            }

        })
    </script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>