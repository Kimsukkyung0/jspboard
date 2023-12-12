<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-12
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <title>list</title>
    <meta charset="utf-8" http-equiv="Content-Type" content="text/html;">
    <meta name="viewport" content="width=device-width">
<%--    <link rel="stylesheet" type="text/css" href=${path}"/css/styles.css" />--%>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<div class="wrap">
    <jsp:include page="/WEB-INF/views/header/headerMenu_01.jsp"></jsp:include>


    <main>
        <div class="main-wrap">
            <jsp:include page="/WEB-INF/views/body/bodyMain_01.jsp"></jsp:include>
        </div>
    </main>
</div>

</body>
</html>
