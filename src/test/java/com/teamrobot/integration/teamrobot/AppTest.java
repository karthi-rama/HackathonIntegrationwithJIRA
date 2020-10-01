package com.teamrobot.integration.teamrobot;

import java.io.UnsupportedEncodingException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    {    
        public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        JIRAIntegration jiraInt = new JIRAIntegration();
        jiraInt.postTestCaseAPICall();
    }
}
