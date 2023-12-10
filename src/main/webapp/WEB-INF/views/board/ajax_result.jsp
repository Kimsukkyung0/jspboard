<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-06
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>ajax test 결과</title>
    <meta charset="utf-8" http-equiv="Content-Type" content="text/html;">
    <meta name="viewport" content="width=device-width", initial-scale="1">
    <link rel="stylesheet" type="text/css" href="${path}/css/styles.css" />
<%--    <link rel="stylesheet" type="text/css" href="${path}/css/styles.css" />--%>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8");%>
    <%String title = request.getParameter("title");
        String contents = request.getParameter("ctnt");
        String writer = request.getParameter("writer");%>

    <table>
        <thead>
        <h2>작성완료된 글 확인</h2>
        </thead>
        <tr>
            <td>제목</td>
<%--            <td>"title의 getproperty값" <jsp:getProperty name="title" property="title"/></td>--%>
             <td><%=title + " request.getParameter값 을 통한 값 받아오기"%></td>
        </tr>

        <tr>
            <td>내용</td>
            <%--            <td><jsp:getProperty name="contents" property="contents"/></td>--%>
            <td><%=contents%></td>
        </tr>

        <tr>
            <td>작성자</td>
            <%--            <td><jsp:getProperty name="contents" property="contents"/></td>--%>
            <td><%=writer%></td>
        </tr>
    </table>
</body>

<%--    <jsp:setProperty property="title" name="title" value='<%=request.getParameter("title") %>'/>--%>
<%--    <jsp:setProperty property="contents" name="contents" value='<%=request.getParameter("contents") %>'/>--%>
<%--    <jsp:setProperty property="writer" name="writer" value='<%=request.getParameter("writer") %>'/>--%>

</html>