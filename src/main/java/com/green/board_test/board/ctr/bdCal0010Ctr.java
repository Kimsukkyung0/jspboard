package com.green.board_test.board.ctr;

import com.green.model.WritingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class bdCal0010Ctr {

    @RequestMapping(value = "/cs/cal", method = {RequestMethod.POST, RequestMethod.GET})
    public String getFullCalendar(HttpServletRequest request, HttpServletResponse response, WritingForm form, Model model) throws Exception {
        return "calendar_test";
    }
}
