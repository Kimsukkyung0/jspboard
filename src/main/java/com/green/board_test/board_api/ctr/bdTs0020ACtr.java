package com.green.board_test.board_api.ctr;

import com.green.board_test.board_api.svc.bdTs0020ASvc;
import com.green.board_test.cm.Cm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class bdTs0020ACtr {

    @Resource(name = "bdTs0020ASvc")
    private bdTs0020ASvc svc;

    @RequestMapping(value = "/api/cs/notice/list", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> showPostList(HttpServletRequest req, Model model) throws Exception{
        String OP_ID = Cm.startCtrMethod(req,getClass().getName());

        try {
            return Cm.rtnMap("S","",svc.showAllPostList(),OP_ID);
        }catch(Exception e){
            return Cm.rtnFalseMap("S",e,OP_ID);
            //String cd, String msg, Object resultList, String opId
        }
    }
}
