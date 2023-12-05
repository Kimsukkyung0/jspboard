package com.green.jspboard.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Repository
@Qualifier("odCc0010Dao")
public class bdTs0010Dao implements bdTs0010DaoIF{
//    @Resource(name = "sqlMapClientTemplate")
//    private SqlSessionTemplate sqlMapClientTemplate;

    @Override
    public String writingNotice(HttpServletRequest request) throws Exception{
        return "DAO";
    };
}
