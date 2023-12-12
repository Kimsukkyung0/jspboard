<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-12
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<table>
    <thead>
    게시판목록
    </thead>
    <tr class="main_table_column">
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수</td>
    </tr>
    <%--                    <tr class="main_list">--%>
    <%--                    </tr>--%>


</table>
<div class="buttons">
    <button type="submit" id="btn-prev">뒤루</button>
    <%--                아마 게시글 번호--%>
    <button type="reset" id="btn-next">앞으루</button>
</div>
</html>


<script type="text/javascript">

    $.ajax({
        url: "http://localhost:8090/jspboard_war_exploded/api/cs/notice/list"
        , type: "GET"
        , dataType: "json"
        , contentType
        , success: function (data) {
            console.log(data)
            $.each(data.RESULT, function (index, item) {
                var postPreview =
                    '<tr><td>' + index + '</td>' +
                    '<td>' + item.title + '</td>' +
                    '<td>' + item.writer + '</td>' +
                    '<td>' + item.REG_DTM + '</td>' +
                    '<td>' + item.hits + '</td></tr>';
                $('.main-wrap table tbody').append(postPreview);
            });
        }


    });


</script>
