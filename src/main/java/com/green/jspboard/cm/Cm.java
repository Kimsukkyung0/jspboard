package com.green.jspboard.cm;

import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    public static String startCtrMethod(HttpServletRequest request, Model model, String opId) {

        String OP_ID = ("USER" + opId).toUpperCase();
        model.addAttribute("OP_ID", OP_ID);

        return OP_ID;

    }

    //서블릿리퀘스트>map 으로 형변환
    public static Map<String, Object> getParameterMap(HttpServletRequest request, Model model, String opId) {

        model.addAttribute("OP_ID", opId);

        HashMap<String, Object> data = new HashMap<String, Object>();
        @SuppressWarnings("rawtypes")
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = (String) enums.nextElement();
            String[] parameters = request.getParameterValues(paramName);

            // Parameter가 배열일 경우
            if (parameters.length > 1) {
                data.put(paramName, URLDecoder.decode(parameters.toString().replaceAll("%", "%25")));
                // Parameter가 배열이 아닌 경우
            } else {
                data.put(paramName, URLDecoder.decode(parameters[0].replaceAll("%", "%25")));
            }
        }

        HashMap<String, Object> paserData = settingAddData(request, data, opId);
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



}
