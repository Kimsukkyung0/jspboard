<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/d" prefix="jsp"%>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>jspboard-writing</title>

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

        <jsp:useBean class="com.green.model.WritingForm" id="postForm" scope="page"></jsp:useBean>
        <form method="post" role="form" autocomplete="off" action="write.jsp">
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
                   <td> <button type="submit">submit</button></td>
                    <td><button type="reset" value="취소">취소</button></td>
                </tr>
            </table>


        </form>

        <footer>
            <p>2023.12.5 게시판</p>
        </footer>

    </div>


<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>