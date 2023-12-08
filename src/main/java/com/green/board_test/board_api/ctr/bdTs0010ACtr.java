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
        String OP_ID = Cm.startCtrMethod(req, getClass().getName());
        //결과 : USER+classname
        System.out.println("user+className : "+OP_ID);

        HashMap<String, Object> params = Cm.cmRequestToMap(req,model,OP_ID);

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
