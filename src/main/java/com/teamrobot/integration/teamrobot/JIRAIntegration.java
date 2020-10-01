package com.teamrobot.integration.teamrobot;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Hello world!
 *
 */
public class JIRAIntegration 
{
    private static final String username = "karthika.ramz@gmail.com";
    private static final String APIKey = "Cl3dw2PMhseuuNSPHfdu1131";
    CloseableHttpClient httpClient;
    HttpResponse httpResponse;
    JIRAHttpClient client = new JIRAHttpClient();
    public void postTestCaseAPICall() throws UnsupportedEncodingException {
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json;charset=UTF-8");
        headerMap.put("Accept","application/json");
        headerMap.put("Authorization", "Basic " + Base64.encodeBase64String(
                (username + ":" + APIKey)
                .getBytes()));
        client.executePostCall(headerMap,getCreateTestCaseJson());
    }
        //Creating json data for test case creation
        private String getCreateTestCaseJson(){
            String testCaseStr ="";
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting(); 
            Gson gson = builder.create();
            TestCasePOJO testcase = new TestCasePOJO();
            FieldsPojo fields = new FieldsPojo();
            ProjectPojo project = new ProjectPojo();
            IssueTypePojo issuetype = new IssueTypePojo();
            project.setKey("HC");
            fields.setProject(project);
            issuetype.setName("Test Case");
            fields.setSummary("summary");
            fields.setDescription("description");
            fields.setIssuetype(issuetype);
            fields.setCustomfield_10036("test Steps"
                    + "1.Verify step 1"
                    + "2.Verify Step 2"
                    + "3.Verify Step 3");
            testcase.setFields(fields);
            testCaseStr = gson.toJson(testcase);
            return testCaseStr;

        }
    
}
