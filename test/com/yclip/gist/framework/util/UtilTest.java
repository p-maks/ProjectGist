/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

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
public class UtilTest {
    
    public UtilTest() {
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
     * Test of splitSentence method, of class Util.
     */
    @Test
    public void testSplitSentence() {
        System.out.println("splitSentence");
        String sentence = "\"Man Utd\" team is mobbed by fans as they leave the airport";
        Util instance = new Util();
        ArrayList expResult = new ArrayList<>();
        expResult.add("Man Utd");
        expResult.add("team");
        expResult.add("is");
        expResult.add("mobbed");
        expResult.add("by");
        expResult.add("fans");
        expResult.add("as");
        expResult.add("they");
        expResult.add("leave");
        expResult.add("the");
        expResult.add("airport");
        ArrayList result = instance.splitSentence(sentence);
        assertEquals(expResult, result);
    }
}