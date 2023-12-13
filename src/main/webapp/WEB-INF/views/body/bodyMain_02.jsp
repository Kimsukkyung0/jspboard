<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-12-12
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%--<link rel="stylesheet" href="${path}/css/common.css">--%>
<html>

<table>
    <thead>
    게시판목록
    <ul class="postCnt">
        <li class="postCnt1">
            <a href="#">5개씩</a>
        </li>
        <li class="postCnt2">
            <a href="#">10개씩</a>
        </li>
    </ul>
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
<div class="board_footer_nav"></div>
<div class="buttons">
    <button type="submit" id="btn-prev">뒤루</button>
<%--    ?<p></p>--%>
    <%--                아마 게시글 번호--%>
    <button type="reset" id="btn-next">앞으루</button>
</div>
</html>


<script type="text/javascript">
 //일단 값 담아보기 null이면 어쩔수없긔..
 //    var currentPage =$(currPage);
    var postCnt = $(postCnt);

    //선택했는데 암것도 없어 for example 첫페이지에서
    // currentPage = currentPage===null||currentPage==='' ? currentPage='1' : currentPage;
    currentPage = 1;
    // postCnt = postCnt===null||postCnt==='' ? postCnt=10 : postCnt;
    postCnt =10;
    //data json 형식으로 만들기
    const targetData = "currentPage:"+currentPage+", postCnt:"+postCnt;
    console.log("targetData : "+targetData);

    $.ajax({
        url: "http://localhost:8090/jspboard_war_exploded/api/cs/notice/page"
        , type: "POST"
        // , dataType: "json"
        , data: 'JSON=' + JSON.stringify(targetData)
        , contentType : 'application/json'
        , success: function (data) {
            console.log(data)
            $.each(data.RESULT, function (index, item) {
                var postPreview =
                    '<tr><td>' + index+1 + '</td>' +
                    '<td>' + item.title + '</td>' +
                    '<td>' + item.writer + '</td>' +
                    '<td>' + item.REG_DTM + '</td>' +
                    '<td>' + item.hits + '</td></tr>';
                $('.main-wrap table tbody').append(postPreview);
            });
        }


    });


</script>
