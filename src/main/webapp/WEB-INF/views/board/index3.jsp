<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="subpath" value="/WEB-INF/views/board/"/>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8" http-equiv="Content-Type" content="text/html;">
    <meta name="viewport" content="width=device-width">
    <title>jspboard</title>


</head>
<body>
    <div class="jsp_container">
        <jsp:include page="/index.jsp"></jsp:include>
<%--        <jsp:include page="/WEB-INF/views/board/result.jsp"></jsp:include>--%>
    </div>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
<%--            <p><jsp:forward page="WEB-INF/views/board/index.jsp"></jsp:forward></p>--%>
            <a class="navbar-brand" href="${path}${subpath}write.jsp">게시판</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"></div>
    </nav>
        <h1>환영합니다!</h1>
        <h1>게시판입니다!</h1>
        <h2 class="a">게시판입니다!</h2>
        <h3 class="b"> Either way anyway Welcome입니다</h3>



    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="../../../js/bootstrap.js"></script>
</body>
</html>
<script></script>