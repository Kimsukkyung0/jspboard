package com.green.board_test.board_api.dao;

import com.green.model.WritingForm;

import java.util.HashMap;
import java.util.List;

public interface bdTs0010ADaoIF {

    String ajaxDbIns(HashMap<String,Object> params) throws Exception;

    List showablePostsList() throws Exception;


    HashMap<String,Object> showPostDetail(Long bd_num) throws Exception;
}
