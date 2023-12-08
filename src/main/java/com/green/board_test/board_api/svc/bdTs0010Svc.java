package com.green.board_test.board_api.svc;

import com.green.board_test.board_api.dao.bdTs0010ADaoIF;
import com.green.model.WritingForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class bdTs0010Svc implements bdTs0010ASvcIF{
//    @Autowired
    @Resource(name="bdTs0010ADao")
    private bdTs0010ADaoIF bdTs0010ADao;

    @Override
    public String writingNotice(WritingForm form) throws Exception{
        return bdTs0010ADao.writingNotice(form);
    };

}
