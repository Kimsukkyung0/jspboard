package com.green.board_test.board_api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Repository
@Qualifier("odCc0010Dao")
public class bdTs0010ADao implements bdTs0010ADaoIF {

//    @Resource(name = "errorLogger")
//    private ErrorLogger errorLogger;
    @Resource(name = "sqlMapClientTemplate")
    private SqlSessionTemplate sqlMapClientTemplate;

    @Override
    public String ajaxDbIns(HashMap<String,Object> params) throws Exception {

        String targetQueryName = "bdTs0010.insBoardPost";
        HashMap<String, Object> datamap = new HashMap<>();

        try {
            sqlMapClientTemplate.insert(targetQueryName, params);
            return "DAO:OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "DAO:FAILED";
        }
    }



    @Override
    public List<Integer> showablePostsList() throws Exception {
        String targetQueryName = "showablePostsList";

        try {
            //리스트로 mybatis resulttype 을 정의해줬던 지나날..ㅇ
            //기초가없으면이렇게됩니다
//            List<Object> result =
//            System.out.println("result.get(0)"+result.get(0));
//            System.out.println("result.get(1)"+result.get(1));
//             List params = sqlMapClientTemplate.selectList(targetQueryName);
//            System.out.println(params.get(0));
//            System.out.println(params.get(1));
//            return params;
            return sqlMapClientTemplate.selectList(targetQueryName);
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public HashMap<String,Object> showPostDetail(Long bd_num) throws Exception{
        String targetQueryName = "showPostDetail";
        String upHitsQuery = "updateHits";
        try{
            //게시글 디테일 조회
            HashMap<String,Object> result = sqlMapClientTemplate.selectOne(targetQueryName,bd_num);
            //조회수 올리기
            sqlMapClientTemplate.update(upHitsQuery,bd_num);

            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<HashMap<String,Object>> showAllPostList() {
        String targetQuery = "showAllPostList";
        List<HashMap<String,Object>> resultList = sqlMapClientTemplate.selectList(targetQuery);
        System.out.println("resultList.size()" + resultList.size());
        for(HashMap<String,Object> val : resultList){
            System.out.println("resultList -val : "+val);
        }
        return resultList;
    }
}
