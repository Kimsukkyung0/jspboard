package com.green.jspboard.board.svc;

import com.green.jspboard.board.dao.bdTs0010DaoIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class bdTs0010Svc implements bdTs0010SvcIF{
//    @Autowired
    @Resource(name="bdTs0010Dao")
    private bdTs0010DaoIF bdTs0010Dao;

    @Override
    public String writingNotice(HttpServletRequest request) throws Exception{
        return "하하!";
    };

}
