/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
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
public class DeControllerTest {
    
    public DeControllerTest() {
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
     * Test of getImageSentence method, of class DeController.
     */
    @Test
    public void testGetImageSentence() throws Exception {
        System.out.println("getImageSentence");
        String input = "\"Man Utd\" team is mobbed by fans as they leave the airport";
        DeController instance = new DeController();
        ImageSentence expResult = null;
        ImageSentence result = instance.getImageSentence(input);
        for(ImageWord iW: result.getImageWords()){
           System.out.println(iW.getUrl()); 
        }
    }
}