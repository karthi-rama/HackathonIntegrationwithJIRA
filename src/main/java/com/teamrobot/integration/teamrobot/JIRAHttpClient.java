package com.teamrobot.integration.teamrobot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JIRAHttpClient {
    CloseableHttpClient httpClient;
    HttpResponse httpResponse;
    public static String URI = "https://teamrobot.atlassian.net/rest/api/latest";
    public String executePostCall(HashMap<String, String> headerMap,String requestBody) {
        String response = "";
        httpClient = HttpClientBuilder.create().build();
        //HttpGet request = new HttpGet(URI);
        HttpPost postrequest = new HttpPost(URI+"/issue");
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            postrequest.addHeader(entry.getKey(), entry.getValue());
        }        
        try {
            StringEntity params = new StringEntity(requestBody);
            postrequest.setEntity(params); 
            httpResponse = httpClient.execute(postrequest);httpResponse.getStatusLine();
            HttpEntity responseEntity = httpResponse.getEntity();
            if(responseEntity!=null) {
                response = EntityUtils.toString(responseEntity);
            }
            System.out.println("stgdyrtu"+response);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }
    
    public String executeGetCall(HashMap<String, String> headerMap,String issueID) {
        String response = "";
        httpClient = HttpClientBuilder.create().build();
        //HttpGet request = new HttpGet(URI);
        HttpGet getrequest = new HttpGet(URI+"/"+issueID);
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            getrequest.addHeader(entry.getKey(), entry.getValue());
        }        
        try {
            httpResponse = httpClient.execute(getrequest);
            HttpEntity responseEntity = httpResponse.getEntity();
            if(responseEntity!=null) {
                response = EntityUtils.toString(responseEntity);
            }
            System.out.println("stgdyrtu"+response);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }
}
