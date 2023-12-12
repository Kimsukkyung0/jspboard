package com.green.board_test.board_api.svc;

import com.green.board_test.board_api.dao.bdTs0020ADao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class bdTs0020ASvc implements bdTs0020ASvcIF{

    @Resource(name = "bdTs0020ADao")
    private bdTs0020ADao bdTs0020ADao;

    @Override
    public List<HashMap<String, Object>> showAllPostList(){
        return bdTs0020ADao.showAllPostList();
    }
}
