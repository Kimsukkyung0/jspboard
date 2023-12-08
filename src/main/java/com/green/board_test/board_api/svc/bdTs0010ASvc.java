package com.green.board_test.board_api.svc;

import com.green.board_test.board_api.dao.bdTs0010ADaoIF;
import com.green.model.WritingForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class bdTs0010ASvc implements bdTs0010ASvcIF{

    @Resource(name="bdTs0010ADao")
    private bdTs0010ADaoIF bdTs0010ADao;

    @Override
    public String ajaxDbTest(HashMap<String,Object>params) throws Exception{
        try{
            bdTs0010ADao.ajaxDbIns(params);
            return "OK";
        }catch (Exception e){
            e.printStackTrace();
            return "SVC:FAILED";
        }

    };

}
