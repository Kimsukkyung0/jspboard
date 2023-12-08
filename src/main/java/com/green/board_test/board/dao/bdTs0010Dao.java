package com.green.board_test.board.dao;

import com.green.model.WritingForm;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@Repository
@Qualifier("odCc0010Dao")
public class bdTs0010Dao implements bdTs0010DaoIF{

    private DataSource dataSource;
    @Resource(name = "sqlMapClientTemplate")
    private SqlSessionTemplate sqlMapClientTemplate;

    @Override
    public String writingNotice(WritingForm form) throws Exception{
        //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //TODO 맵형태 변환을 보통 어디서 하져 ?
        //본 코드에선 쿼리 이름 과 맵타입의 파라미터로 넘겼음.
        //일단 지금은 맵타입으로 변환이 안된 상태이므로 , 일단 writingformd타입으로 등록해놓긔
        //notnull설정인 친구들이 있어서 값이 정상적으로 들어가진 않을 것이다.
        try{sqlMapClientTemplate.insert(form.getContents());
            Connection c = dataSource.getConnection();
            Statement s =  c.createStatement();
            ResultSet rs = s.executeQuery("        INSERT INTO j_board\n" +
                    "        SET title = 하하,\n" +
                    "            ctnt = 호호,\n" +
                    "            writer= 낄낄");
            String result =rs.getString("title");
            System.out.println(result);

            c.close();
            s.close();
            rs.close();

            return result;}
        catch (Exception e){
            e.printStackTrace();
            return "NOT OK";
        }

    };
}
