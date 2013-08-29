/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chaka
 */
public class SentenceTemplateTest {
    
    public static final String TEST_INPUT = "\"Man Utd\" team is mobbed by fans as they leave the airport";
    
    public SentenceTemplateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of getWordInput method, of class SentenceTemplate.
     */
    @Test
    public void testGetWordInput() {
        
        System.out.println("getWordInput");
        
        ArrayList expectedResult = new ArrayList<>();
        expectedResult.add("Man Utd");
        expectedResult.add("team");
        expectedResult.add("is");
        expectedResult.add("mobbed");
        expectedResult.add("by");
        expectedResult.add("fans");
        expectedResult.add("as");
        expectedResult.add("they");
        expectedResult.add("leave");
        expectedResult.add("the");
        expectedResult.add("airport");
        SentenceTemplate instance = new SentenceTemplate(TEST_INPUT, expectedResult);
        List result = instance.getSentenceWords();
        assertEquals(expectedResult, result );
    }

    /**
     * Test of setWordInput method, of class SentenceTemplate.
     */
    @Test
    public void testSetWordInput() {
        System.out.println("getWordInput");
        ArrayList expectedResult = new ArrayList<>();
        expectedResult.add("Man Utd");
        expectedResult.add("team");
        expectedResult.add("is");
        expectedResult.add("mobbed");
        expectedResult.add("by");
        expectedResult.add("fans");
        expectedResult.add("as");
        expectedResult.add("they");
        expectedResult.add("leave");
        expectedResult.add("the");
        expectedResult.add("airport");
        SentenceTemplate instance = new SentenceTemplate(TEST_INPUT,expectedResult);
        
    }

    /**
     * Test of getInputXML method, of class SentenceTemplate.
     
    @Test
    public void testGetInputXML() {
        System.out.println("getInputXML");
        SentenceTemplate instance = null;
        String expResult = "";
        String result = instance.getInputXML();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setInputXML method, of class SentenceTemplate.
     
    @Test
    public void testSetInputXML() {
        System.out.println("setInputXML");
        String inputXML = "";
        SentenceTemplate instance = null;
        instance.setInputXML(inputXML);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}