<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <form action="/cs/notice" method="post" role="form" autocomplete="off">
            <p>
                <label for="title">title</label><input type="text" id="title" name="title">
            </p>
            <p>
                <label for="content">contents</label><textarea name="content" id="content" cols="30" rows="10"></textarea>
            </p>
            <p>
                <label for="writer">writer</label><input type="text" id="writer">
            </p>
            <p>
                <button type="submit">submit</button>
            </p>

        </form>

        <footer>
            <p>2023.12.5 게시판</p>
        </footer>

    </div>


<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>