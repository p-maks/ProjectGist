/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.exceptions.NoWordException;
import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import java.util.HashSet;
import java.util.Set;
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
public class IwRepoDAOImplStudTest {

    public IwRepoDAOImplStudTest() {
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
     * Test of checkUIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testCheckUIS() {
        System.out.println("checkUIS");
        String word = "";
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        boolean expResult = false;
        boolean result = instance.checkUIS(word);
        assertFalse(result);
        word = "airport";
        result = instance.checkUIS(word);
        assertTrue(result);
    }

    /**
     * Test of checkGIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testCheckGIS() {
        System.out.println("checkGIS");
        String word = "";
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        boolean expResult = false;
        boolean result = instance.checkGIS(word);
        assertFalse(result);
        word = "team";
        result = instance.checkGIS(word);
        assertTrue(result);
    }

    /**
     * Test of checkLIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testCheckLIS() {
        System.out.println("checkLIS");
        String word = "";
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        boolean expResult = false;
        boolean result = instance.checkLIS(word);
        assertFalse(result);
        word = "mobbed";
        result = instance.checkLIS(word);
        assertTrue(result);
    }

    /**
     * Test of getUIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testGetUIS() {
        System.out.println("getUIS");
        String word = ""; //Test word not in repo
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getUIS(word);
        assertNull(result);
    }

    /**
     * Test of getGIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testGetGIS() {
        System.out.println("getGIS");
        String word = ""; //Test word not in repo
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getGIS(word);
        assertNull(result);
    }

    /**
     * Test of getLIS method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testGetLIS() {
        System.out.println("getLIS");
        String word = "";//Test word not in repo
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getLIS(word);
        assertNull(result);
    }

    /**
     * Test of getImageWord method, of class IwRepoDAOImplStud.
     */
    @Test
    public void testGetImageWord() {
        System.out.println("getImageWord");
        String word = "";  //Test word not in repo
        IwRepoDAOImplStud instance = new IwRepoDAOImplStud();
        ImageWord expResult = null;
        ImageWord result = new ImageWord();
        try {
            result = instance.getImageWord(word);
        } catch (NoWordException ex) {
            Logger.getLogger(IwRepoDAOImplStudTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue("Error was thrown correctly", ex instanceof NoWordException);
        }

        word = "leave";
        Set tempSet = new HashSet<String>();
        tempSet.add("leave");
        expResult = new ImageWord("leave.jpeg", new ImageTextSource(tempSet));
        try {
            result = instance.getImageWord(word);
        } catch (NoWordException ex) {
            Logger.getLogger(IwRepoDAOImplStudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail( "Error thrown when looking for leave" );
        }
        assertEquals(expResult.getUrl(), result.getUrl());

        word = "team";
        Set tempSet1 = new HashSet<String>();
        tempSet1.add("team");
        expResult = new ImageWord("team.jpeg", new ImageTextSource(tempSet1));
        try {
            result = instance.getImageWord(word);
        } catch (NoWordException ex) {
            Logger.getLogger(IwRepoDAOImplStudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail( "Error thrown when looking for team" );
        }
        assertEquals(expResult.getUrl(), result.getUrl());


    }

    @Test(expected = NoWordException.class)
    public void testNoWordException() throws NoWordException {
       String word = "test123noteverygoingtobeaword"; //Test a word which should never be in a repo
       new IwRepoDAOImplStud().getImageWord(word);
        
    }
    
}