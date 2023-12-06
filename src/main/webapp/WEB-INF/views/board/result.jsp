<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-06
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기 결과</title>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8");%>
    <jsp:useBean class="com.green.model.WritingForm" id="postForm" scope="page"/>
    <jsp:setProperty property="title" name="title" value='<%=request.getParameter("title") %>'/>
    <jsp:setProperty property="contents" name="contents" value='<%=request.getParameter("contents") %>'/>
    <jsp:setProperty property="writer" name="writer" value='<%=request.getParameter("writer") %>'/>
    <table>
        <thead>
        <h2>작성완료된 글 확인</h2>
        </thead>
        <tr>
            <td>제목</td>
            <td><jsp:getProperty name="title" property="title"/></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><jsp:getProperty name="contents" property="contents"/></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><jsp:getProperty name="writer" property="writer"/></td>
        </tr>
        <tr>
            <td> <button type="submit">submit</button></td>
            <td><button type="reset" value="취소">취소</button></td>
        </tr>
    </table>
</body>
</html>
