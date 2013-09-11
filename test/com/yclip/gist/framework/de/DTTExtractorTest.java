/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.util.Util;
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
public class DTTExtractorTest {
    
    public static final String TEST_INPUT = "\"Man Utd\" team is mobbed by fans as they leave the airport";
    
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
        List<String> parsedInput = new Util().splitSentence(test_sentence);
        //Create list of sentence words from the split sentence
        List<SentenceWord> sentenceWords = new ArrayList();
        for (String object : parsedInput) {
            sentenceWords.add(new SentenceWord(object));
        }
        
        SentenceTemplate sT = new SentenceTemplate(test_sentence,sentenceWords);
        DTTExtractor instance = new DTTExtractor();
        SentenceTemplate result = instance.tagDTT(sT);
        System.out.println(result.getInput());
        System.out.println(result.getTaggedSentence());
        assertEquals(result.getTaggedSentence(), "<ss>Man Utd</ss> <ss>team</ss> <dtt>is</dtt> <ss>mobbed</ss> <dtt>by</dtt> <ss>fans</ss> <dtt>as</dtt> <ss>they</ss> <ss>leave</ss> <dtt>the</dtt> <ss>airport</ss>");
        
        
        //these tests test whether the dtt value has been set correctly, 
        //if the list gets removed these tests should be removed as well
        assertFalse(result.getSentenceWords().get(0).toString() + " is true",result.getSentenceWords().get(0).isDTT());
        assertFalse(result.getSentenceWords().get(1).toString() + " is true",result.getSentenceWords().get(1).isDTT());
        assertTrue(result.getSentenceWords().get(2).toString() + " is false",result.getSentenceWords().get(2).isDTT());
        assertFalse(result.getSentenceWords().get(3).toString() + " is true",result.getSentenceWords().get(3).isDTT());
        assertTrue(result.getSentenceWords().get(4).toString() + " is false",result.getSentenceWords().get(4).isDTT());
        assertFalse(result.getSentenceWords().get(5).toString() + " is true",result.getSentenceWords().get(5).isDTT());
    }
}