package edu.egov.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class Network {
	public static void main(String[] args) throws IOException {
		// 서버 접속
		URL url = new URL("http://ggoreb.com/json1.jsp");
		URLConnection conn = url.openConnection();
		
		// 접속된 객체로부터 문자열을 가져오기
		InputStream in = conn.getInputStream();
		// InputStream ==> Reader 변환
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(isr);
		
		String result = "";
		
		// 실제 데이터 꺼내오기 (한줄씩)
		while(true) {
			String data = reader.readLine();
			if(data == null) break;
//			System.out.println(data);
			result += data;
		}
		
		// JSON Parsing
		JSONObject obj = new JSONObject(result);
		String name = obj.getString("name");
		System.out.println(name);
		int age = obj.getInt("age");
		System.out.println(age);
		
	}
}











