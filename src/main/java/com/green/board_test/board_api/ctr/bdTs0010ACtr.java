package com.green.board_test.board_api.ctr;


import com.green.board_test.board_api.svc.bdTs0010ASvc;
import com.green.board_test.cm.Cm;
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
        System.out.println("user+className : "+OP_ID);
        String title = req.getAttribute("title").toString();
        System.out.println("리퀘스트에선 어떤값이 title:"+title);




        HashMap<String, Object> params = Cm.cmRequestToMap(req,model,OP_ID);
        System.out.println(params.size());
        System.out.println(params.containsKey("title"));
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
        try{
            if(params ==null){
                params = new HashMap<>();
            }params.put("OP_ID",OP_ID);
            return svc.ajaxDbTest(params);
        }catch (Exception e){
            e.printStackTrace();
            return "CTR:FAILED";
        }
    }
}
