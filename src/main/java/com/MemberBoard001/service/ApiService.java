package com.MemberBoard001.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberBoard001.dto.TagoDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ApiService {

	@Autowired
	private HttpSession session;
	
	public String kakaoPay_ready(String prcode, String prname, int prprice, int prqty) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("https://kapi.kakao.com/v1/payment/ready"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("cid","UTF-8") + "=TC0ONETIME"); /*가맹점 코드*/
        urlBuilder.append("&" + URLEncoder.encode("partner_order_id","UTF-8") + "=" + URLEncoder.encode("OD0001", "UTF-8")); /*주문번호*/
        urlBuilder.append("&" + URLEncoder.encode("partner_user_id","UTF-8") + "=" + URLEncoder.encode("TEST_STORE", "UTF-8")); /*주문자 아이디*/
        urlBuilder.append("&" + URLEncoder.encode("item_name","UTF-8") + "=" + URLEncoder.encode(prname, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("item_code","UTF-8") + "=" + URLEncoder.encode(prcode, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("quantity","UTF-8") + "=" + URLEncoder.encode(prqty+"", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("total_amount","UTF-8") + "=" + URLEncoder.encode((prqty*prprice)+"", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("tax_free_amount","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("approval_url","UTF-8") + "=" + URLEncoder.encode("http://localhost:8080/controller/kakaoPay_approval", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("cancel_url","UTF-8") + "=" + URLEncoder.encode("http://localhost:8080/controller/kakaoPay_cancel", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("fail_url","UTF-8") + "=" + URLEncoder.encode("http://localhost:8080/controller/kakaoPay_fail", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "KakaoAK "+"3f735e2c4637ec2229ade1802174edae"); // 본인 어플리케이션의 admin key
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        JsonElement element = JsonParser.parseString(sb.toString());
        //tid와 next_redirect_pc_url 뽑기
        JsonObject readyObj = element.getAsJsonObject();
        String tid = readyObj.get("tid").getAsString();
        System.out.println("tid : " + tid);
        session.setAttribute("payTid", tid);
        
        String nextPcUrl =readyObj.get("next_redirect_pc_url").getAsString();
        System.out.println("nextPcUrl : " + nextPcUrl);
		return nextPcUrl;
	}

	public String[] kakaopay_approval(String tid, String pg_token) throws Exception{
		StringBuilder urlBuilder = new StringBuilder("https://kapi.kakao.com/v1/payment/approve"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("cid","UTF-8") + "=TC0ONETIME"); /*가맹점 코드*/
        urlBuilder.append("&" + URLEncoder.encode("tid", "UTF-8") + "=" + URLEncoder.encode(tid, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pg_token", "UTF-8") + "=" + URLEncoder.encode(pg_token, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("partner_order_id","UTF-8") + "=" + URLEncoder.encode("OD0001", "UTF-8")); /*주문번호*/
        urlBuilder.append("&" + URLEncoder.encode("partner_user_id","UTF-8") + "=" + URLEncoder.encode("TEST_STORE", "UTF-8")); /*주문자 아이디*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "KakaoAK "+"3f735e2c4637ec2229ade1802174edae"); // 본인 어플리케이션의 admin key
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        JsonElement approvalElement = JsonParser.parseString(sb.toString());
        JsonObject approvalObj = approvalElement.getAsJsonObject();
        String orcode = approvalObj.get("partner_order_id").getAsString();
        System.out.println("주문번호 : " + orcode);
        String qty = approvalObj.get("quantity").getAsString();
        System.out.println("주문량 : " + qty);
        String orprice = approvalObj.get("amount").getAsJsonObject().get("total").getAsString();
        System.out.println("주문량 : " + orprice);
        String ordate = approvalObj.get("approved_at").getAsString();
        System.out.println("승인일 : " + ordate);
        String data[] = {orcode, qty, orprice, ordate};
		return data;
	}

	public String tagoGetData(TagoDto tagoData) throws Exception{
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(tagoData.getServiceKey(), "UTF-8")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(tagoData.getPageNo()+"", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(tagoData.getNumofRows(), "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입(xml, json)*/
        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(tagoData.getCityCode(), "UTF-8")); /*도시코드 [상세기능3 도시코드 목록 조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("nodeId","UTF-8") + "=" + URLEncoder.encode(tagoData.getNodeId(), "UTF-8")); /*정류소ID [국토교통부(TAGO)_버스정류소정보]에서 조회가능*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        JsonElement tagoElem = JsonParser.parseString(sb.toString());
        JsonObject tagoBody = tagoElem.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject();
        JsonObject tagoItems = tagoBody.get("items").getAsJsonObject();
        JsonArray tagoItem = tagoItems.get("item").getAsJsonArray();
        System.out.println(tagoItem.toString());
        
        Gson gson = new Gson();
        String tagoString = gson.toJson(tagoItem);
        
		return tagoString;
	}

	/*
	 * public String getAccToken(String code) throws Exception{ StringBuilder
	 * urlBuilder = new StringBuilder("https://kauth.kakao.com/oauth/token");
	 * urlBuilder.append("?" + URLEncoder.encode("grant_type", "UTF-8") +
	 * URLEncoder.encode("authorization_code", "UTF-8")); urlBuilder.append("&" +
	 * URLEncoder.encode("client_id", "UTF-8") + "=" +
	 * URLEncoder.encode("47940b0e1d32b5364cc8c92f1c6eda2d", "UTF-8"));rhd 앱
	 * REST_API_KEY urlBuilder.append("&" + URLEncoder.encode("redirect_uri",
	 * "UTF-8") + "=" +
	 * URLEncoder.encode("http://localhost:8080/controller/KakaoLogin", "UTF-8")); 앱
	 * REDIRECT_URI urlBuilder.append("&" + URLEncoder.encode("code", "UTF-8") + "="
	 * + URLEncoder.encode(code, "UTF-8")); 데이터 타입(xml, json) URL url = new
	 * URL(urlBuilder.toString()); HttpURLConnection conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod("POST");
	 * conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
	 * System.out.println("Response code: " + conn.getResponseCode());
	 * BufferedReader rd; if (conn.getResponseCode() >= 200 &&
	 * conn.getResponseCode() <= 300) { rd = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream())); } else { rd = new
	 * BufferedReader(new InputStreamReader(conn.getErrorStream())); } StringBuilder
	 * sb = new StringBuilder(); String line; while ((line = rd.readLine()) != null)
	 * { sb.append(line); } rd.close(); conn.disconnect();
	 * System.out.println(sb.toString());
	 * 
	 * JsonElement element = JsonParser.parseString(sb.toString()); String
	 * access_token = element.getAsJsonObject().get("access_token").getAsString();
	 * System.out.println("access_token : " + access_token);
	 * 
	 * return access_token; }
	 */
	
	
}
