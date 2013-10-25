/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.marklogic.client.query.MatchDocumentSummary;
import com.yclip.gist.framework.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class WordSetDAOMarkLogicImplStudTest {
    
    public WordSetDAOMarkLogicImplStudTest() {
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
     * Test of injest method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testInjest() {
        System.out.println("injest");
        String xml = "";
        String doc = "";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.injest(xml, doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of injestFile method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testInjestFile() {
        System.out.println("injestFile");
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        boolean result = instance.injestFile("c:\\import\\wordset\\exit.xml", "exit.xml");
    }

    /**
     * Test of contains method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String word = "";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.contains(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String xml = "/oif/laser.xml";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.delete(xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String doc = "";
        String xml = "";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.update(doc, xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        String expResult = "";
        String result = instance.listAll();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String word = "";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        MatchDocumentSummary[] expResult = null;
        MatchDocumentSummary[] result = instance.search(word);
        //assertArrayEquals(expResult, result);
        
        word = "laser";
        result = instance.search(word);
        System.out.println(result[0].getUri());
        
        
    }

    /**
     * Test of getObjectFromURI method, of class WordSetDAOMarkLogicImplStud.
     */
    @Test
    public void testGetObjectFromURI() {
        System.out.println("getObjectFromURI");
        String uri = "/oif/laser.xml";
        WordSetDAOMarkLogicImplStud instance = new WordSetDAOMarkLogicImplStud();
        Object expResult = null;
        Object result = instance.getObjectFromURI(uri);
        System.out.println(result.toString());
        try {
            System.out.println(new Util().generateXML(result));
        } catch (Exception ex) {
            Logger.getLogger(WordSetDAOMarkLogicImplStudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}