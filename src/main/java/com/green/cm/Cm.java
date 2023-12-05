package com.green.cm;

import java.sql.Timestamp;

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
}
