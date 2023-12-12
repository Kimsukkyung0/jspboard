$.callAjax = function(pUrl, pParamData, pType) {
    if ($.isNull(pUrl)) {
        alert("URL을 지정하세요.");
        return;
    }

    var opId = $("meta[name='OP_ID']").attr("content");
    var baseUrl = $("meta[name='BASE_URL']").attr("content");

    pUrl = baseUrl + pUrl;

    $.ajax({
//		headers: {
//	        'Accept': 'application/json',
//	        'Content-Type': 'application/json'
//	    },
        url: pUrl,
        type: ($.isNull(pType)) ? "POST" : pType.toUpperCase(),
        async: ($.isNull(pAsync)) ? true : pAsync,
        data: 'CALL_ID=' + $.makeCallid() + '&S_DTM=' + js_yyyy_mm_dd_hh_mm_ss() + '&OP_ID=' + opId + '&JSON=' + JSON.stringify(pParamData),
        success: function (data) {

            if ("S" != data.CD) {
                if ($.isFunction(pCallbackErrFun)) {
                    pCallbackErrFun(data);
                }
                return data;
            }

            if ($.isFunction(pCallbackSucFun)) {
                if (data.CODE == '5000') {
                    location.reload();
                } else {
                    pCallbackSucFun(data);
                }
            }
        },
        error: function (data, status, err) {
            var element = $(document.body);
            //alert("에러가 발생하였습니다. 관리자에게 문의하십시오.");
        }

    });

/////////////////////////////////////////////////////////////////
//ajax 호출 : 폼저장 또는 파일업로드에 사용.
//- $("#formID").callAjaxSubmit("/saveFileForm.json", "formId", null, $.fnCallbackBeforeSubmit, $.fnCallbackSuccess);
//- $("#formID").callAjaxSubmit("/uploadFile.json", "formId", null, null, $.fnCallbackSuccess);<br>
//
//@param pUrl 호출 url(.json)
//@param pObjFormId 폼 전송 시 폼 오브젝트 id
//@param pType ajax form submit 호출 방식(post/get)
//@param pCallbackBeforeFun ajax form submit 호출 직전 처리할 콜백함수 : return true/false
//@param pCallbackSucFun ajax form submit 호출 성공 후 처리할 콜백함수
//@param pReset ajax form submit 호출 성공 후 form reset여부(default : false)
/////////////////////////////////////////////////////////////////


    $.makeCallid = function () {
        var text = "";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (var i = 0; i < 40; i++)
            text += possible.charAt(Math.floor(Math.random() * possible.length));
        return text;
    }
}

/////////////////////////////////////////////////////////////////
//
//*  페이지 세팅  *
//
//	list : 데이터
//	pagination : 페이징뷰 영역
//	pagePrevDetach : < 버튼
//	pageNextDetach : > 버튼
//	pageADetach : 페이지 버튼
//	allCount : 아이템 총개수
//	limitCount : 한페이지당 개수
//	page : 현재 페이지 - 0부터
//
//	- 해당 페이지의 페이징 영역을 아래와 같이 변경 필요!!
//	<div class="pagination">
//		<a href="#" class="p-prev" onclick="return false;">이전</a>
//		<a href="#" onclick="return false;"></a>
//		<a href="#" class="p-next" onclick="return false;">다음</a>
//	</div>
//
/////////////////////////////////////////////////////////////////
function pageSetting(list, pagination, pagePrevDetach, pageNextDetach, pageADetach, allCount, limitCount, page) {

    pagination.empty();

    // 페이지 카운트
    var pageCount = parseInt(allCount/limitCount) + ((allCount%limitCount != 0) ? 1 : 0);

    // 페이징 정보 세팅
    var blockSize = 5;
    var currentPage = parseInt(page) + 1;
    var firstPage = currentPage - ((currentPage-1)%blockSize);
    var lastPage = firstPage + (blockSize-1);//마지막 페이지
    if(lastPage > pageCount){
        lastPage = pageCount;
    }

    // 이전 버튼
    if(firstPage != 1){
        var prevClone = pagePrevDetach.clone();
        prevClone.data(list[firstPage-blockSize-1]);
        prevClone.data('page', firstPage-blockSize-1);
        pagination.append(prevClone);
    }

    // 페이지 생성
    for(var i=firstPage; i<=lastPage; i++){
        var aClone = pageADetach.clone();

        aClone.text(i);
        aClone.data('page', i-1);
        aClone.data(list[i-1]);

        if(page == i-1){
            pagination.append('<strong>' + (i) + '</strong>');
        }
        else{
            pagination.append(aClone);
        }
    }

    // 다음 버튼
    if(lastPage != pageCount){
        var nextClone = pageNextDetach.clone();
        nextClone.data(list[lastPage]);
        nextClone.data('page', lastPage);
        pagination.append(nextClone);
    }

}
