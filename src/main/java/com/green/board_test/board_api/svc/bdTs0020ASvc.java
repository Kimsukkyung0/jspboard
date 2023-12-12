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

    @Override
    public HashMap<String, Object> showAllPostList4Pagination(HashMap<String,Object> params){
        //가져온 현재페이지, 페이지당 표출게시물 갯수로
        //begin,endpage계산 (parameter 두개!)
        params.put("beginPage",1);
        params.put("endPage",10);
        List subResult = bdTs0020ADao.showAllPostList4Pagination(params);
        return new HashMap<>();
    }
}
