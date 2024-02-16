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
                    <td><h1 class="page-title">ajax-get</h1></td>
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
                    게시글보기
                    </thead>
                    <tr>
                        <td>제목</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td></td>
                    </tr>
                </table>
          </form>
                <div class="buttons">
                    <button type="button" id="btn-get">게시글 가져오기</button>
                </div>



        </div>

    </main>

<%--wrap--%>

<footer>
    <a href="<c:url value="/"/>">form 테스트로 돌아가기</a>
    <p>2023.12.5 게시판</p>
</footer>

</div>

<script type="text/javascript">
    $("#btn-get").on("click",function(){
        //메일형식을 확인하는 정규식

        if(confirm("랜덤게시글을 가져오시겠습니까 ?")) {

            $.ajax({
                // crossOrigin: true
                url: "${path}/api/cs/notice/view"
                , type: "GET"
                , contentType: "application/json; charset=utf-8"//데이터를 보내는 타입
                , dataType: "json"//데이터를 받아오는 타입(사실상 지금은 필요없음)
                , success: function (data) {
                    alert(data + "게시글ctr 전달완료")
                    console.log( JSON.stringify(params)+"success");
                    //data 는 컨트롤러와 통신한 결과값을 담고 있음
                    //현재 출력값 :Ok:게시글업로드 완료
                    //<%--location.replace("${path}/cs/notice3")--%>
                },
                error: function (data, status, err) {
                    var element = $(document.body);
                    console.log( JSON.stringify(params)+"error");
                    alert(element.val()+"에러ㅠㅠ");
                }
            });
        }
    })
</script>


</body>
</html>