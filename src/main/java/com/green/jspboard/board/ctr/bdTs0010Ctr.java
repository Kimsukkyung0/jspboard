package com.green.jspboard.board.ctr;


import com.green.jspboard.board.svc.bdTs0010Svc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class bdTs0010Ctr {
        //TODO map의 사용

    @Resource(name="bdTs0010Svc")
    private bdTs0010Svc svc;

    @RequestMapping(value="bd", method={RequestMethod.GET, RequestMethod.POST})
    public int wrtPost(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{

        return 1;
    }

}
