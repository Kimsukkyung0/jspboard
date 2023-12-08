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
    public String writingNotice(WritingForm form) throws Exception{
        //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //TODO 맵형태 변환을 보통 어디서 하져 ?

        String targetQueryName = "bdTs0010.insBoardPost";
        HashMap<String,Object> datamap = new HashMap<>();

        try{sqlMapClientTemplate.insert(targetQueryName);
            //sqlmap client template에서는 쿼리문이 적인 xml파일명 / map형태로 변환된 데이터를 넘기면됨.



            //            Connection c = dataSource.getConnection();
//            Statement s =  c.createStatement();
//            ResultSet rs = s.executeQuery("        INSERT INTO j_board\n" +
//                    "        SET title = 하하,\n" +
//                    "            ctnt = 호호,\n" +
//                    "            writer= 낄낄");
//            String result =rs.getString("title");
//            System.out.println(result);
//
//            c.close();
//            s.close();
//            rs.close();

            return "OK";}
        catch (Exception e){
            e.printStackTrace();
            return "NOT OK";
        }

    };
}
