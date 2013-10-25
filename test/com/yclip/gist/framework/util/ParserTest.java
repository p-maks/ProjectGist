/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

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
public class ParserTest {
    
    public ParserTest() {
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
     * Test of parseXML method, of class Parser.
     */
    @Test
    public void testParseXML() throws Exception {
        System.out.println("parseXML");
        String word = "";
        String format = "";
        String type = "";
        String dataSource = "";
        String imageSource = "";
        Parser instance = new Parser();
        boolean expResult = false;
        boolean result = instance.parseXML(word, format, type, dataSource, imageSource);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readCSV method, of class Parser.
     */
    @Test
    public void testReadCSV() {
        System.out.println("readCSV");
        String csv = "";
        Parser instance = new Parser();
        instance.readCSV(csv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readSvgCSV method, of class Parser.
     */
    @Test
    public void testReadSvgCSV() {
        System.out.println("readSvgCSV");
        String csv = "c:/import/words.csv";
        Parser instance = new Parser();
        instance.readSvgCSV(csv);
    }
}