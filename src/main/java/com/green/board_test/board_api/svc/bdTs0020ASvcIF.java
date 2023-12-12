package com.green.board_test.board_api.svc;

import java.util.HashMap;
import java.util.List;

public interface bdTs0020ASvcIF {
    List<HashMap<String, Object>> showAllPostList();

    HashMap<String, Object> showAllPostList4Pagination(HashMap<String,Object> params);
}
