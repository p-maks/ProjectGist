/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
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
public class DTTExtractorTest {
    
    
    
    public DTTExtractorTest() {
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
     * Test of tagDTT method, of class DTTExtractor.
     */
    @Test
    public void testTagDTT() throws Exception {
        String test_sentence = "\"Man Utd\" team is mobbed by fans as they leave the airport";
        System.out.println("tagDTT");
        SentenceTemplate sT = new SentenceTemplate(test_sentence);
        DTTExtractor instance = new DTTExtractor();
        SentenceTemplate result = instance.tagDTT(sT);
        System.out.println(result.getInput());
        assertEquals("The tagged string is incorrect", "Man Utd team <DTT>is</DTT> mobbed <DTT>by</DTT> fans <DTT>as</DTT> they leave <DTT>the</DTT> airport", result.getInput());
        
    }
}