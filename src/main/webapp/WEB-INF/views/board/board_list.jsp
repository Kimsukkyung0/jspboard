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
</div>
</body>
</html>
