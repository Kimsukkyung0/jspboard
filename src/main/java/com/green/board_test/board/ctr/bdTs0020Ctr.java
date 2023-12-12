package com.green.board_test.board.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class bdTs0020Ctr {
//1.게시글 리스트보기
    //2.게시글 페이지네이션 기능
    @RequestMapping(value = "/cs/notice/list", method = {RequestMethod.POST, RequestMethod.GET})
    public String ShowPostList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "board_list";
    }

    @RequestMapping(value = "/cs/notice/page", method = {RequestMethod.POST, RequestMethod.GET})
    public String ListPagination(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        //아마 여기서 요청 번호를 줘야겠쥬?
        return "board_list_pagination";
    }
}
