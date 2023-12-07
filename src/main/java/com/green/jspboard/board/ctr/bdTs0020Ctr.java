package com.green.jspboard.board.ctr;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class bdTs0020Ctr {


    @RequestMapping(value = "/test" , method = {RequestMethod.POST})
    public String ajaxTest(HttpServletRequest req, Model model){
        String title = req.getParameter("title");
        String requesturl =req.getRequestURI();
        String method=req.getMethod();
        System.out.println("requesturl : "+ requesturl);
        System.out.println("method : "+method);
        System.out.println("model을 toString출력 : "+model.toString());

        return "아쟉스가 정말 되는지 궁금하거든요? title:"+title;
    }
}
