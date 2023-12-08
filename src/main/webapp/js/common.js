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
