package com.green.board_test.board_api.ctr;


import com.green.board_test.board_api.svc.bdTs0010ASvc;
import com.green.board_test.cm.Cm;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class bdTs0010ACtr {
    @Resource(name = "bdTs0010ASvc")
    private bdTs0010ASvc svc;



    @RequestMapping(value = "/api/cs/notice" , method = {RequestMethod.POST})
    @ResponseBody
    public String insertTest(HttpServletRequest req, Model model){
        //작업아이디 만드는 부분
        //결과 : USER+classname
        String OP_ID = Cm.startCtrMethod(req, getClass().getName());

        //파라미터로 가져온 request 파싱작업
        HashMap<String, Object> params = new HashMap<>();
//        JSONObject jo = new JSONObject(req.getParameter("title"));
//        System.out.println("JSONOBJECT title : "+jo);
        String title = req.getParameter("JSON");


        try{
            //테스트로 parameter 값을 받고 , 아무것도 들어있지 않을시 sql에 error 게시물 업로드 하기
            if(title ==null) {
                params.put("title","error");
                params.put("ctnt","error");
                params.put("writer","error");
                System.out.println(title +"= null");
//            System.out.println(title);
//             params = Cm.cmRequestToMap(req, model, OP_ID);
//            for (int i = 0; i < params.size(); i++) {
//                System.out.println(params.get(i));
//            }
        }
            if(params ==null){
                params = new HashMap<>();
                System.out.println(params+" = null");
                params.put("OP_ID",OP_ID);
            }
            return svc.ajaxDbTest(params);
        }catch (Exception e){
            e.printStackTrace();
            return "CTR:FAILED";
        }
    }
}
