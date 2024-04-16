package com.green.board_test.board_api.ctr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class DecryptCtr {
    @RequestMapping(value = "/api/dec/msg", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String decMsgFromApi(HttpServletRequest req, Model model) throws Exception {

        int x = 1;
        int y = 10;

        int result = (x > y) ? x : y;
        System.out.println("result : "+result);

        return "board_list";
    }
}
