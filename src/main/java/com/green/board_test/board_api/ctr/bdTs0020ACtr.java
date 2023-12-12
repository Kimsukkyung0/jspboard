package com.green.board_test.board_api.ctr;

import com.green.board_test.board_api.svc.bdTs0020ASvc;
import com.green.board_test.cm.Cm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @RequestMapping(value="/api/cs/notice/{page}")
    @ResponseBody
    public HashMap<String, Object> showAllPostList4Pagination(HttpServletRequest req,Model model){
        HashMap<String,Object> params = new HashMap<>();
        req.getParameter("JSON");
        //분해해서 표출페이지 개수 현재페이지 값 받기
        return svc.showAllPostList4Pagination(params);
    }
}
