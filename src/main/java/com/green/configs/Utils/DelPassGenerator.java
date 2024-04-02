package com.jangbogo.driver.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//배송앱 관리자 비밀번호 생성
public class DelPassGenerator {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwdEncoder = new BCryptPasswordEncoder();
		
		//  비밀번호 암호화
//		String password = "00798";
//		String password = "1234";
		String password = "123";
		String encodePass = passwdEncoder.encode(password);
		System.out.println("encodePass : " + encodePass);

	}



}
