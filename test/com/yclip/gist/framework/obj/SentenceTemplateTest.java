/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.ArrayList;
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
     * Test of getInput method, of class SentenceTemplate.
     */
    @Test
    public void testSetAndGetInput() {
        System.out.println("getInput");
        SentenceTemplate instance = new SentenceTemplate("testing");
        String expResult = "test";
        instance.setInput(expResult);
        String result = instance.getInput();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWordInput method, of class SentenceTemplate.
     */
    @Test
    public void testGetWordInput() {
        System.out.println("getWordInput");
        SentenceTemplate instance = new SentenceTemplate("\"Man Utd\" team is mobbed by fans as they leave the airport");
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
        ArrayList result = instance.getWordInput();
        assertEquals(expectedResult, result );
    }

    /**
     * Test of setWordInput method, of class SentenceTemplate.
     */
    @Test
    public void testSetWordInput() {
        System.out.println("getWordInput");
        SentenceTemplate instance = new SentenceTemplate("test");
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
        instance.setWordInput(expectedResult);
        ArrayList result = instance.getWordInput();
        assertEquals(expectedResult, result );
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