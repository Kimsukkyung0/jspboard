package com.green.board_test.board_api.dao;

import com.green.model.WritingForm;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;


@Repository
@Qualifier("odCc0010Dao")
public class bdTs0010ADao implements bdTs0010ADaoIF {

    private DataSource dataSource;
    @Resource(name = "sqlMapClientTemplate")
    private SqlSessionTemplate sqlMapClientTemplate;

    @Override
    public String ajaxDbIns(HashMap<String,Object> params) throws Exception{

        String targetQueryName = "bdTs0010.insBoardPost";
        HashMap<String,Object> datamap = new HashMap<>();

        try{
            sqlMapClientTemplate.insert(targetQueryName,params);

            return "DAO:OK";}
        catch (Exception e){
            e.printStackTrace();
            return "DAO:FAILED";
        }

    };
}
