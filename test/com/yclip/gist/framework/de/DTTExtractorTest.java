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
        System.out.println("tagDTT");
        SentenceTemplate sT = null;
        DTTExtractor instance = new DTTExtractor();
        SentenceTemplate expResult = null;
        SentenceTemplate result = instance.tagDTT(sT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}