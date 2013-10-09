/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import java.io.UnsupportedEncodingException;
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
public class DttRepoDAOMarkLogicImplStudTest {
    
    public DttRepoDAOMarkLogicImplStudTest() {
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
     * Test of checkDtt method, of class DttRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testCheckDtt() {
        System.out.println("checkDtt");
        String word = "I";
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.checkDtt(word);
        assertEquals(expResult, result);
        word = "Neveractuallygoingtobeaword";
        result = instance.checkDtt(word);
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of injest method, of class DttRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testInjest() throws UnsupportedEncodingException {
        System.out.println("injest");
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<DTTXML name=\"dtt_xml\">\n" +
"	<DTTItem>I</DTTItem>\n" +
"	<DTTItem>to</DTTItem>\n" +
"            <DTTItem>from</DTTItem>\n" +
"            <DTTItem>as</DTTItem>\n" +
"            <DTTItem>is</DTTItem>\n" +
"            <DTTItem>are</DTTItem>\n" +
"            <DTTItem>by</DTTItem>\n" +
"            <DTTItem>the</DTTItem>\n" +
"</DTTXML>";
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        boolean result = instance.injest(xml);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class DttRepoDAOMarkLogicImplStud.
     
    @Test
    public void testDelete() {
        System.out.println("delete");
        String xml = "";
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.delete(xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of update method, of class DttRepoDAOMarkLogicImplStud.
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        String dtt = "";
        String xml = "";
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.update(dtt, xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of listAll method, of class DttRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        String expResult = "";
        String result = instance.listAll();
        System.out.println(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of connect method, of class DttRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        DttRepoDAOMarkLogicImplStud instance = new DttRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        result = instance.release();
        assertEquals(expResult, result);
    }

    
}