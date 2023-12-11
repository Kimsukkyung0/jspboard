package com.green.board_test.board_api.svc;

import com.green.board_test.board_api.dao.bdTs0010ADaoIF;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public String showPostList() throws Exception{
        try{
            //랜덤 포스트 리스트 가져오기
            List rdList = new ArrayList();
            rdList =  bdTs0010ADao.showablePostsList();
            //보여줄 수 있는 리스트 중 랜덤포스트넘버
            Long rdPostNum = (long) (Math.random()* rdList.size())+1;
            System.out.println(rdPostNum);
            return rdPostNum.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "SVC:FAILED";
        }
    }

}
