/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

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
public class DttRepoDAOImplStudTest {
    
    public DttRepoDAOImplStudTest() {
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
     * Test of checkDtt method, of class DttRepoDAOImplStud.
     */
    @Test
    public void testCheckDtt() {
        System.out.println("checkDtt");
        String word = "as";  // A word that should be in DTT
        DttRepoDAOImplStud instance = new DttRepoDAOImplStud();
        boolean expResult = false;
        boolean result = instance.checkDtt(word);
        assertTrue("Word is not in DTT", result);
        
        
        word = "test";  //A word that shouldn't be in DTT
        result = instance.checkDtt(word);
        assertFalse("Word is in DTT", result);
    }
}