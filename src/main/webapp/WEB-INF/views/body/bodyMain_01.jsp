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
        // ,contentType
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


            // $('.main-wrap table:last-child').html(contents);
            // $('.main_wrap table').html(contents);

        }
        // , fail : function () {
        //         var reload = '<a id="refresh" href="#"';
        //         reload += '<div><img src="https://us.123rf.com/450wm/foxroar/foxroar1606/foxroar160600250/58011676-%EC%83%88%EB%A1%9C-%EA%B3%A0%EC%B9%A8-%EC%95%84%EC%9D%B4%EC%BD%98.jpg">정보를 로드하지 못했습니다</div>'
        //         $('.main_list').html(reload);
        //     }

    });


    	/////////////////////////////////세션타이머 테스트/////////////////////
	var setTimeOffsetBetweenServerAndClient = function(){
		console.log('-----------------------------')
		var latestTouch = getCookie('latestTouch');
		//쿠키 얻어오는 값
		console.log('latestTouch : ',latestTouch)
		latestTouch = latestTouch==null ? null : Math.abs(latestTouch);

		console.log('clientTime : ',clientTime)
		var clientTime = (new Date()).getTime();
		var clientTimeOffset = clientTime - latestTouch;
		setCookie('clientTimeOffset', clientTimeOffset);
		console.log('-----------------------------')
	}

	var isSessionExpired= function(offset){
		//절대수 리턴하는 함수(math.abs)
		console.log('====================================================')
		var sessionExpiry = Math.abs(getCookie('sessionExpiry'));
		console.log('sessionExpiry : ',sessionExpiry)
		var timeOffset = Math.abs(getCookie('sessionExpiry'));
		console.log('timeOffset : ', timeOffset)
		var localTime = (new Date()).getTime();
		console.log('localTime : ',localTime)
		setCookie('remainTime', (sessionExpiry - (localTime - timeOffset)));
		console.log('remainTime : ',sessionExpiry - (localTime - timeOffset))
		console.log('====================================================')
		return localTime - timeOffset > (sessionExpiry-(offset||0));
	}




	function checkSessionExpired(){
		var isExpired = isSessionExpired(-5*1000);	//세션만료예정시간을 5초 앞당겨서 검사
		if(isExpired === true){
			alert('Session Expired. Please login.');
			goLogin();
		}else{
			setTimeout('checkSessionExpired()', 30*1000);	//30초에 한번씩 티이머 반복
		}
	}

	function goLogin(){
		location.href = '/cu/loginCustomer';
	}


	/////////////////////////////////세션타이머 테스트/////////////////////

        //////getcookie (common.js)
    function getCookie( name ) {  
	var nameOfCookie = name + "=";  
	var x = 0;  
	while ( x <= document.cookie.length )  
	{  
	    var y = (x+nameOfCookie.length);  
	    if ( document.cookie.substring( x, y ) == nameOfCookie ) {  
	        if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )  
	            endOfCookie = document.cookie.length;  
	        return unescape( document.cookie.substring( y, endOfCookie ) );  
	    }  
	    x = document.cookie.indexOf( " ", x ) + 1;  
	    if ( x == 0 )  
	        break;  
	}  
	return "";  
}  

</script>
