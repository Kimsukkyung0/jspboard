package com.green.jspboard.board.ctr;


import com.green.jspboard.board.svc.bdTs0010Svc;
import com.green.jspboard.cm.Cm;
import com.green.model.WritingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class bdTs0010Ctr {
        //TODO map의 사용
        //1.원격호출 가능한 프로그램으로 등록 (빈등록)
    //2.url 과 메서드를 연결(requestmapping)
    @Resource(name="bdTs0010Svc")
    private bdTs0010Svc svc;

    @RequestMapping(value="/cs/notice", method={RequestMethod.POST})//우선적으로 crud중 c먼저 하기
    public String writingNotice(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
        WritingForm form = (WritingForm) request.getAttribute("postForm");
        System.out.println(form.toString());
//        String result = svc.writingNotice(request);
        return "1";
    }

}
