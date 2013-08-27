/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;
import java.util.HashSet;
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
public class ImageFinderTest {
    
    public ImageFinderTest() {
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
     * Test of constructImageSentence method, of class ImageFinder.
     */
    @Test
    public void testConstructImageSentence() throws Exception {
        System.out.println("constructImageSentence");
        SentenceTemplate sT = null;
        ImageFinder instance = new ImageFinder();
        ImageSentence expResult = null;
        ImageSentence result = instance.constructImageSentence(sT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findImage method, of class ImageFinder.
     */
    @Test
    public void testFindImage() throws Exception {
        System.out.println("findImage");
        String word = "";
        ImageFinder instance = new ImageFinder();
        ImageWord expResult = null;
        ImageWord result = instance.findImage(word);
        assertNull(result);
        word = "team";
        HashSet<String> tempSet = new HashSet<String>();
        tempSet.add("team");
        expResult = new ImageWord("team.jpeg", new ImageTextSource(tempSet));
        result = instance.findImage(word);
        assertEquals(expResult.getUrl(), result.getUrl());
        
    }
}