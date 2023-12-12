package com.green.board_test.board_api.ctr;


import com.google.gson.Gson;
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
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
        HashMap params ;
//        JSONObject jo = new JSONObject(req.getParameter("title"));
//        System.out.println("JSONOBJECT title : "+jo);
        String json = req.getParameter("JSON");
        System.out.println("json:"+json);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("jsonObject:"+jsonObject);

        Gson gson = new Gson();
        params = gson.fromJson(json, HashMap.class);
//        params = (HashMap<String, Object>) Cm.toMap(jsonObject);

        System.out.println(params);

        try{
            //테스트로 parameter 값을 받고 , 아무것도 들어있지 않을시 sql에 error 게시물 업로드 하는상황쓰..
            if(params ==null) {
                params.put("title","error");
                params.put("ctnt","error");
                params.put("writer","error");
//            System.out.println(title);
//             params = Cm.cmRequestToMap(req, model, OP_ID);
//            for (int i = 0; i < params.size(); i++) {
//                System.out.println(params.get(i));
//            }
                return svc.ajaxDbTest(params);
        } else{
//            if(params !=null){
//                params = new HashMap<>();
//                System.out.println(params+" = null");
//                params.put("OP_ID",OP_ID);
//            }
            return svc.ajaxDbTest(params);}
        }catch (Exception e){
            e.printStackTrace();
            return "CTR:FAILED";
        }
    }

    @RequestMapping(value = "/api/cs/notice/view", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public HashMap<String,Object> showPostDetail(HttpServletResponse res, Model model) throws Exception {
        HashMap<String,Object> result = svc.showPostDetail();
        model.addAttribute("ctr resultList toString value : ", result.toString());
        System.out.println("added attribute on Model :" + result);
        System.out.println("svcResult length(in Ctr) : " + result);

        return result;
    }
}
