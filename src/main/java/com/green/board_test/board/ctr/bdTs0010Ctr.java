package com.green.board_test.board.ctr;


import com.green.board_test.board.svc.bdTs0010Svc;
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
    //TODO map의 사용
    //1.원격호출 가능한 프로그램으로 등록 (빈등록)
    //2.url 과 메서드를 연결(requestmapping)
    @Resource(name = "bdTs0010Svc")
    private bdTs0010Svc svc;

    @RequestMapping(value = "/cs/notice", method = {RequestMethod.POST, RequestMethod.GET})//우선적으로 crud중 c먼저 하기
    public ModelAndView writingNotice(HttpServletRequest request, HttpServletResponse response,WritingForm form, Model model) throws Exception {
        svc.writingNotice(form);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("title",form.getTitle());
        mv.addObject("contents",form.getContents());
        mv.addObject("writer",form.getWriter());
        mv.addObject("mail",form.getWritersMail());
//        WritingForm form = (WritingForm) request.getAttribute("postForm")
        System.out.println("modelAndBiew : viewname : " + mv.getViewName());
//        String result = svc.writingNotice(request);

        //JSP 서블릿 클래스는 doGet doPost 메서드가 존재했는데 여기서 model이 그 역할을 한다.
        // Model : 데이터를 담는 그릇 역할, map 구조로 저장됨// key와 value로 구성
        // model.addAttribute("변수명", 값)
        return mv;

    }

}