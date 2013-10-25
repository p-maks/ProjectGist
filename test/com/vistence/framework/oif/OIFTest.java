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
     * Test of getImageForWord method, of class OIF.
     */
    @Test
    public void testGetImageForWord() throws Exception {
        System.out.println("getImageForWord");
        String input = "laser";
        OIF instance = new OIF();
        instance.getImageForWord(input);
    }

}