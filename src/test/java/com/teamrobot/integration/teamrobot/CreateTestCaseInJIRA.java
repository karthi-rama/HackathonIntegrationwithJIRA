package com.teamrobot.integration.teamrobot;

import java.io.UnsupportedEncodingException;

public class CreateTestCaseInJIRA {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        JIRAIntegration jiraInt = new JIRAIntegration();
        jiraInt.postTestCaseAPICall();
    }

}
