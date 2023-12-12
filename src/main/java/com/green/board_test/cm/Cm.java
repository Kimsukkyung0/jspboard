package com.green.board_test.cm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import ubs.fw.exception.ErrorLogger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Cm {
//custweb에서 간단하게 개발할때 사용할 수 있는 메서드 위주로 복사해오긔

    public static Long timeOverTime() {
        return (long) (60*60*1000);  // 1시간이상 조작업을 시 로그아웃 시킴
        //return (long) (4*1000);
    }
    public static boolean checkTimeOver(String ltoken) {
        try {

            if (ltoken.length() >= 80) {

                Timestamp nowTimeStamp = new Timestamp(System.currentTimeMillis());

                String oldTimeStamp = ltoken.substring(80,ltoken.length());
                Long a1 = nowTimeStamp.getTime();
                Long a2 = Long.parseLong(oldTimeStamp);

                if(timeOverTime() < a1-a2) {
                    return false;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return true;
        }
        return true;

    }

    public static String startCtrMethod(HttpServletRequest request, String opId) {

        String OP_ID = ("USER" + opId).toUpperCase();
        //원래는 다른 메서드를 통해서 getOpIdFront+opId를 받았어야함 .
        return OP_ID;

    }



    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }


//    데이터파싱>map to json
    public static Map<String, Object> toMap(JSONObject jsonobj) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof org.json.JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }



    public static HashMap<String, Object> cmRequestToMap(HttpServletRequest request, Model model, String opId) {
        HashMap<String, Object> map = null;
        model.addAttribute("OP_ID", opId);
        if (request == null) {
            map = new HashMap<String, Object>();
            return map;
        }

        try {
            org.json.JSONObject jsonObj = new JSONObject(request.getParameter("JSON"));

            map = (HashMap<String, Object>) toMap(jsonObj);

        } catch (Exception e) {
            map = new HashMap<String, Object>();
        }

        // String screenOpId = map.get("OP_ID");
        HashMap<String, Object> paserData = settingAddData(request, map, opId);
//		if("true".equals(paserData.get("_timeover"))) {
//			model.addAttribute("_timeover", true);
//		}

        return paserData;
    }

    public static HashMap<String, Object> settingAddData(HttpServletRequest request, HashMap<String, Object> data,
                                                         String opId) {
        ServletContext context = request.getSession().getServletContext();
        @SuppressWarnings("unchecked")   // 요청된 서비스의 매체코드 넣어주는곳
        HashMap<String, Object> opIdDatas = (HashMap<String, Object>) context.getAttribute("opIdDatas");
        if (opIdDatas != null) {
            @SuppressWarnings("unchecked")
            HashMap<String, Object> tmp = (HashMap<String, Object>) opIdDatas.get(opId);
            if (tmp != null && "Y".equals(tmp.get("SEARCH_SELF_SA_MEDI_USE_YN"))) {
                data.put("stMediCd","Cm.testMediCd1");
            } else {
                String stMediCd = "Cm.222MediCd2222";
                data.put("stMediCd", stMediCd);
            }
        }

        data.put("saMediCd", "Cd.saMediCdTest33333");
        data.put("saMediCdCm", "Cd.saMediCdCmTest4444444");

//        // 토큰 정보 있을시 토큰 암호화 해재 하여 설정해 주는 부분
//        try {
//            //String ltoken = URLEncoder.encode((String) data.get("_ltoken"), "UTF-8");
//            String ltoken = (String) data.get("_ltoken");
//            if (ltoken != null && ltoken.length() > 0) {
//                // ltoken = CryptoUtil.decryptDES3(Cm.getLogDesKey(),ltoken);
//                ltoken = CryptoUtil.decryptAse(ltoken);
//                if (ltoken.length() >= 80) {
//                    data.put("_ltoken", ltoken.substring(0, 80));
//                    if(!checkTimeOver(ltoken)) {  // 시간이 지나면 토큰을 비움
//                        data.put("_ltoken", "");
//                    }
//                } else {
//                    data.put("_ltoken", "");
//                }
//            }
//        } catch (Exception e) {
//            data.put("_ltoken", null);
//        }

        return data;
    }

    public static Map<String, Object> rtnMap(String cd, String msg, Object resultList, String opId) {
        // CD o 반환코드 참고
        // CODE o 0000:: 정상처리 , 99XX 시스템 에러 , 나머지 코드 정의 중
        // MSG o 에러인경우 에러메시지 반환
        // RESULT o 결과값
        // opId o 요청 위치

        Map<String, Object> rtMap = new HashMap<String, Object>();

        rtMap.put("CD", cd);
        rtMap.put("CODE", "0000");
        rtMap.put("MSG", msg);
        rtMap.put("OPID", opId);
        rtMap.put("_ltoken", makeNewLoginToken());
        if (cd != null && cd.length() > 0 && "S".equals(cd.substring(0, 1))) {
            rtMap.put("RESULT", resultList);
        } else {
            rtMap.put("RESULT", "");
        }
        return rtMap;
    }
    public static Map<String, Object> rtnFalseMap(String code,Exception e,
                                                  String opId) {
        // CD o 반환코드 참고
        // MSG o 에러인경우 에러메시지 반환
        // RESULT o 결과값
        // opId o 요청 위치

        Map<String, Object> rtMap = new HashMap<String, Object>();

        rtMap.put("OPID", opId);
        rtMap.put("RESULT", "");

        String errMsg = "";
            rtMap.put("CD", code);
            rtMap.put("CODE", "에러맵으로 리턴된 결과값입니다");
            rtMap.put("ERRMSG", "에러입니다");
            rtMap.put("_ltoken", makeNewLoginToken());
            errMsg = "에러입니다";

        rtMap.put("MSG", errMsg);
        return rtMap;
    }



    public static String makeNewLoginToken() {
        return "FreshiestHomeMadeToken";
    }


}
