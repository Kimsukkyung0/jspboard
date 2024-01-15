package com.green.board_test.board_api.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Repository
@Qualifier("bdTs0020ADao")
public class bdTs0020ADao implements bdTs0020ADaoIF{
    @Resource(name = "sqlMapClientTemplate")
    private SqlSessionTemplate sqlMapClientTemplate;
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

    @Override
    public List showAllPostList4Pagination(HashMap<String, Object> params){
        String targetQuery = "showAllPostList4Pagination";
        try{
            return sqlMapClientTemplate.selectList(targetQuery, params);

            //        테스트용 코드 - 주석처리    System.out.println("objects.size() : " +objects.size());
//            for(Object o : objects) {
//                System.out.println("objects.get : " + o);
//            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //총 페이지 갯수를 구하기 위한 메서드생성
    @Override
    public int getTotalCnt(){
        String targetQuery = "getTotalCnt";
        return sqlMapClientTemplate.selectOne(targetQuery);
    }

}
