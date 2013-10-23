/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistence.framework.oif;

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
public class OIFTest {
    
    public OIFTest() {
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
     * Test of searchForWord method, of class OIF.
     */
    @Test
    public void testSearchForWord() throws Exception {
        System.out.println("searchForWord");
        String input = "";
        OIF instance = new OIF();
        String expResult = "";
        String result = instance.searchForWord(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageForWord method, of class OIF.
     */
    @Test
    public void testGetImageForWord() throws Exception {
        System.out.println("getImageForWord");
        String input = "dog";
        OIF instance = new OIF();
        instance.getImageForWord(input);
    }

    /**
     * Test of saveImage method, of class OIF.
     */
    @Test
    public void testSaveImage() throws Exception {
        System.out.println("saveImage");
        String imageUrl = "";
        String destinationFile = "";
        String type = "";
        OIF instance = new OIF();
        String expResult = "";
        String result = instance.saveImage(imageUrl, destinationFile, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}