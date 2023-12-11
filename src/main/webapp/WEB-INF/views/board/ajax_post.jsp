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
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="${path}/css/styles.css" />
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<div class="wrap">
    <header>
        <div class="header-wrap">

            <table class="title-nav">
                <tr>
                    <td><h1 class="page-title">ajax 테스트</h1></td>
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
          <form class="main_data" method="post">
                <table>
                    <thead>
                    게시판 글쓰기
                    </thead>
                    <tr>
                        <td>제목</td>
                        <td> <input type="text" name="title" id="title" placeholder="제목을 입력해주세요"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><input type="text" name="contents" id="contents" placeholder="글 적는 란"></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" name="writer" id="writer" placeholder="작성자"></td>
                    </tr>
<%--                    <tr>--%>
<%--                        <td>작성자이메일</td>--%>
<%--                        <td><input type="text" name="email"id="mail"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>숫자1</td>--%>
<%--                        <td><input type="number" name="num1"id="num1"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>숫자2</td>--%>
<%--                        <td><input type="number" name="num2"id="num2"></td>--%>
<%--                    </tr>--%>
                </table>
          </form>
                <div class="buttons">
                    <button type="submit" id="btn-submit">등록</button>
                    <button type="reset" id="btn btn-danger" value="취소">취소</button>
                </div>



        </div>

    </main>

<%--wrap--%>

<footer>
    <a href="/">form 테스트로 돌아가기</a>
    <p>2023.12.5 게시판</p>
</footer>

</div>

<script type="text/javascript">
    $("#btn-submit").on("click",function(){
        //메일형식을 확인하는 정규식
        var jsTitle = $("#title");
        var jsContents = $("#contents");
        var jswriter = $("#writer");

        console.log(jsTitle)
        console.log(jsContents)
        console.log(jswriter)

        if(jsTitle.val()==="" || jsTitle.val() ===null){
            alert("제목을 입력해 주시죠?");
            jsTitle.focus();
            return false;
        }
        if(jsContents.val()===""|| jsContents.val()===null){
            alert("내용을 입력해 주시죠?");
            jsContents.focus();
            return false;
        }
        if(jswriter.val()===""|| jswriter.val()===null){
            alert("작성자 이름은요?");
            jswriter.focus();
            return false;
        }


        if(confirm("json으로 전송하시겠습니가?")) {
            var params = "";
            //JSON형식으로 변환하는 작업쓰
            params = {
                "title": jsTitle.val()
                , "contents": jsContents.val()
                , "writer": jswriter.val()
            }
            console.log(params);

            <%--$.callAjax('${path}/api/cs/notice',  params, "post");--%>


            $.ajax({
                // crossOrigin: true
                url: "${path}/api/cs/notice"
                , type: "POST"
                , data: 'JSON='+JSON.stringify(params)//보내는 데이터
                , contentType: "application/json; charset=utf-8"//데이터를 보내는 타입
                , dataType: "json"//데이터를 받아오는 타입(사실상 지금은 필요없음)
                , success: function (data) {
                    alert(data + "게시글ctr 전달완료")
                    console.log( JSON.stringify(params)+"success");
                    //data 는 컨트롤러와 통신한 결과값을 담고 있음
                    //현재 출력값 :Ok:게시글업로드 완료
                    <%--location.replace("${path}/cs/notice3")--%>
                },
                error: function (request, err) {
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+err)
                    alert(element.val()+"에러ㅠㅠ");
                }
            });
        }
    })
</script>


</body>
</html>