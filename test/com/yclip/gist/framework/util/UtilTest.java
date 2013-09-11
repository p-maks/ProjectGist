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
        String sentence = "\"Man Utd\" team is mobbed by fans as \"they leave\" the airport";
        Util instance = new Util();
        ArrayList expResult = new ArrayList<>();
        expResult.add("Man Utd");
        expResult.add("team");
        expResult.add("is");
        expResult.add("mobbed");
        expResult.add("by");
        expResult.add("fans");
        expResult.add("as");
        expResult.add("they leave");
        //expResult.add("leave");
        expResult.add("the");
        expResult.add("airport");
        ArrayList result = (ArrayList) instance.splitSentence(sentence);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of splitSentence method, of class Util.
     */
    @Test
    public void testSplitTaggedSentence() {
        System.out.println("splitSentence");
        String sentence = "<ss>Man Utd</ss> <ss>team</ss> <dtt>is</dtt> <ss>mobbed</ss> <dtt>by</dtt> <ss>fans</ss> <dtt>as</dtt> <ss>they</ss> <ss>leave</ss> <dtt>the</dtt> <ss>airport</ss>";
        Util instance = new Util();
        ArrayList expResult = new ArrayList<>();
        expResult.add("<ss>Man Utd</ss>");
        expResult.add("<ss>team</ss>");
        expResult.add("<dtt>is</dtt>");
        expResult.add("<ss>mobbed</ss>");
        expResult.add("<dtt>by</dtt>");
        expResult.add("<ss>fans</ss>");
        expResult.add("<dtt>as</dtt>");
        expResult.add("<ss>they</ss>");
        expResult.add("<ss>leave</ss>");
        expResult.add("<dtt>the</dtt>");
        expResult.add("<ss>airport</ss>");
        ArrayList result = (ArrayList) instance.splitTaggedSentence2(sentence);
        assertEquals(expResult, result);
    }
}