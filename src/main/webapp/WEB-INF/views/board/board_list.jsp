<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-12
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>list</title>
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
                    <td><h1 class="page-title">게시글리스트</h1></td>
                    <td><a href="">처음화면</a></td>
                    <td><a href="">글쓰기</a></td>
                    <td>로그인</td>
                </tr>
            </table>
        </div>
    </header>
    <main>
        <div class="main-wrap">

            <%--        <jsp:useBean class="com.green.model.WritingForm" id="postForm" scope="page"></jsp:useBean>--%>
                <table>
                    <thead>
                    게시판목록
                    </thead>
                    <tr>
                        <td>게시글 번호</td>
                        <td>제목</td>
                        <td>내용</td>
                        <td>작성자</td>
                        <td>작성일</td>
                        <td>조회수</td>
                    </tr>
                    <tr>
                    </tr>


                </table>
            <div class="buttons">
                <button type="submit" id="btn-prev">뒤루</button>
<%--                아마 게시글 번호--%>
                <button type="reset" id="btn-next" >앞으루</button>
            </div>



        </div>
    </main>
</div>


<%--<script type="text/javascript">--%>
<%--    $("#btn-get").on("click",function(){--%>
<%--        //메일형식을 확인하는 정규식--%>

<%--        if(confirm("랜덤게시글을 가져오시겠습니까 ?")) {--%>

<%--            $.ajax({--%>
<%--                // crossOrigin: true--%>
<%--                url: "${path}/api/cs/notice/list"--%>
<%--                , type: "GET"--%>
<%--                , contentType: "application/json; charset=utf-8"//데이터를 보내는 타입--%>
<%--                , dataType: "json"//데이터를 받아오는 타입(사실상 지금은 필요없음)--%>
<%--                , success: function (data) {--%>
<%--                    alert(data + "게시글ctr 전달완료")--%>
<%--                    console.log( JSON.stringify(params)+"success");--%>
<%--                    //data 는 컨트롤러와 통신한 결과값을 담고 있음--%>
<%--                    //현재 출력값 :Ok:게시글업로드 완료--%>
<%--                    &lt;%&ndash;location.replace("${path}/cs/notice3")&ndash;%&gt;--%>
<%--                },--%>
<%--                error: function (data, status, err) {--%>
<%--                    var element = $(document.body);--%>
<%--                    console.log( JSON.stringify(params)+"error");--%>
<%--                    alert(element.val()+"에러ㅠㅠ");--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    })--%>
<%--</script>--%>

</body>
</html>