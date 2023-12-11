package com.green.configs.filter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    public String[] jsonParamNmList = {"JSON", "JSONstr"};	// json stringify 변수명
    //public String[] exceptParamNmList = {};
    //{"ADDR", "ADDR_DTL", "ADD_ADDR", "ADD_ADDR_DTL", "FULL_ADD_ADDR",
    //	"DS_ADR", "DS_DTL_ADR", "DS_FULL_ADR", "ADR", "DTL_ADR", "FULL_ADR","DS_ADD_ADR","DS_ADD_DTL_ADR"};	// 예외처리해야할 변수(주소 위주)

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);

        if (values==null)  {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        if(Arrays.asList(jsonParamNmList).contains(parameter)) {
            for (int i = 0; i < count; i++) {
                encodedValues[i] = jsonStringCleanXSS(values[i]);
            }
        } else {
            for (int i = 0; i < count; i++) {
                encodedValues[i] = cleanXSS(values[i]);
            }
        }
        return encodedValues;
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);

        if (value == null) {
            return null;
        }

        if(Arrays.asList(jsonParamNmList).contains(parameter)) {
            return jsonStringCleanXSS(value);
        } else {
            return cleanXSS(value);
        }
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
    }


    private String cleanXSS(String value) {
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        //value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("\"", "&#34;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        value = value.replaceAll("&lt;br&gt;","<br>");	// 개행 부분 <br> 태그는 예외처리

        return value;
    }

    private String jsonStringCleanXSS(String value) {
        JSONObject newObj = new JSONObject();

        try {
            HashMap<String, Object> map = null;

            JSONObject jsonObj = new JSONObject(value);
            map = (HashMap<String, Object>) toMap(jsonObj);

            Iterator<String> iter = map.keySet().iterator();
            while(iter.hasNext()){
                String key = iter.next();
                Object val = map.get(key);
                newObj.put(key, val);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newObj.toString();
    }

    private Map<String, Object> toMap(JSONObject jsonobj) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }

            if(value instanceof String) {
                value = cleanXSS(value.toString());
            }
            map.put(key, value);
        }
        return map;
    }

    private List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            if(value instanceof String) {
                value = cleanXSS(value.toString());
            }
            list.add(value);
        }
        return list;
    }

}
