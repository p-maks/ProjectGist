/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.marklogic.client.query.MatchDocumentSummary;
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
public class OntologyDAOMarkLogicImplStudTest {
    
    public OntologyDAOMarkLogicImplStudTest() {
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
     * Test of injest method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testInjest() {
        System.out.println("injest");
        String xml = "";
        String doc = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.injest(xml, doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of injestFile method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testInjestFile() {
        System.out.println("injestFile");
        String uri = "";
        String doc = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.injestFile(uri, doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String word = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.contains(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String xml = "/oif/laser.xml";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.delete(xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String doc = "";
        String xml = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.update(doc, xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        String expResult = "";
        String result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String word = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        MatchDocumentSummary[] expResult = null;
        MatchDocumentSummary[] result = instance.search(word);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjectFromURI method, of class OntologyDAOMarkLogicImplStud.
     */
    @Test
    public void testGetObjectFromURI() {
        System.out.println("getObjectFromURI");
        String uri = "";
        OntologyDAOMarkLogicImplStud instance = new OntologyDAOMarkLogicImplStud();
        Object expResult = null;
        Object result = instance.getObjectFromURI(uri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}