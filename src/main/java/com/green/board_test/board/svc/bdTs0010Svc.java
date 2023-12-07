package com.green.board_test.board.svc;

import com.green.board_test.board.dao.bdTs0010DaoIF;
import com.green.model.WritingForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class bdTs0010Svc implements bdTs0010SvcIF{
//    @Autowired
    @Resource(name="bdTs0010Dao")
    private bdTs0010DaoIF bdTs0010Dao;

    @Override
    public String writingNotice(WritingForm form) throws Exception{
        return "하하!";
    };

}
