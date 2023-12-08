package com.green.board_test.board.ctr;


import com.green.board_test.board_api.svc.bdTs0010ASvc;
import com.green.model.WritingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class bdTs0010Ctr {
    //1.원격호출 가능한 프로그램으로 등록 (빈등록)
    //2.url 과 메서드를 연결(requestmapping)

    @RequestMapping(value = "/cs/notice", method = {RequestMethod.POST, RequestMethod.GET})//우선적으로 crud중 c먼저 하기
    public String formTest(HttpServletRequest request, HttpServletResponse response,WritingForm form, Model model) throws Exception {
        return "result";
    }

    @RequestMapping(value = "/cs/notice2", method = {RequestMethod.POST, RequestMethod.GET})//우선적으로 crud중 c먼저 하기
    public String ajaxTest2(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "index2";
    }

    @RequestMapping(value = "/cs/notice3", method = {RequestMethod.POST, RequestMethod.GET})//우선적으로 crud중 c먼저 하기
    public String ajaxResult(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String title = request.getAttribute("title").toString();
        model.addAttribute("title",title);
        return "ajax_result";
    }

}