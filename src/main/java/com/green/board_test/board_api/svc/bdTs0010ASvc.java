package com.green.board_test.board_api.svc;

import com.green.board_test.board_api.dao.bdTs0010ADaoIF;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public HashMap<String, Object> showPostDetail() throws Exception {

        try {
            // 랜덤 포스트 리스트 가져오기
            List<Integer> rdList = bdTs0010ADao.showablePostsList();
            //포스트 리스트 중 난수 생성
            int i = (int) (Math.random() * rdList.size()) +1;
            System.out.println("rdList.get(i) : "+rdList.get(i));
            //난수에 해당하는 리스트 값 가져오기(db통신)

//            System.out.println("rdPostDetail.toString() : " + rdPostDetail.toString());
            return bdTs0010ADao.showPostDetail(Long.valueOf(rdList.get(i)));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
