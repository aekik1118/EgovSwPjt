package edu.egov.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Kakao {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://");
		URLConnection conn = url.openConnection();
		conn.addRequestProperty("Authentication", "Kakao ");
		
		InputStream in = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(isr);
		
		String result = "";
		
		while(true) {
			String data = reader.readLine();
			if(data == null) break;
			result += data;
		}
		
		// JSON Parsing
		JSONObject obj = new JSONObject(result);
		JSONArray items = 
				obj.getJSONArray("items");
		for(int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);
			
			JSONObject id = 
				item.getJSONObject("id");
			String videoId = 
				id.getString("videoId");
			
			JSONObject snippet = 
				item.getJSONObject("snippet");
			String title = 
				snippet.getString("title");
			
			System.out.println(videoId + ", " + title);
		}
		
	}
}











