package com.green.board_test.board.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
