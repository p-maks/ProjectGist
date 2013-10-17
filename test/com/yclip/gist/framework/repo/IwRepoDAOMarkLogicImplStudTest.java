/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.util.Util;
import java.util.HashSet;
import java.util.Set;
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
public class IwRepoDAOMarkLogicImplStudTest {

    public IwRepoDAOMarkLogicImplStudTest() {
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
     * Test of checkUIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testCheckUIS() {
        System.out.println("checkUIS");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.checkUIS(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testCheckGIS() {
        System.out.println("checkGIS");
        String word = "test";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        boolean result = instance.checkGIS(word);
        assertEquals(expResult, result);
        word = "nevergoingtobeawordtotest";
        expResult = false;
        result = instance.checkGIS(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkLIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testCheckLIS() {
        System.out.println("checkLIS");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.checkLIS(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testGetUIS() {
        System.out.println("getUIS");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getUIS(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testGetGIS() {
        System.out.println("getGIS");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getGIS(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLIS method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testGetLIS() {
        System.out.println("getLIS");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getLIS(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of injest method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testInjest() throws Exception {
        System.out.println("injest");
        String doc = "test";
        ImageWord word = new ImageWord();
        word.setUrl(doc);
        ImageTextSource source = new ImageTextSource();
        Set sourceSet = new HashSet();
        sourceSet.add("test");
        source.setWordSet(sourceSet);
        word.setTextSrc(source);
        String xml = new Util().generateXML(word);
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        System.out.println(xml);
        boolean result = instance.injest(doc, xml);
        assertEquals(expResult, result);
    }

    /**
     * Test of injest method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testInjestjson() {
        System.out.println("injest");
        String doc = "imageword/words.json";
        String json = "{\"imageWords\":[{\"url\":\"crowd.svg\",\"textSrc\":null,\"metaInfo\":null,\"corelation\":null,\"id\":1,\"imageName\":\"Crowd\",\"dataSource\":\"<svg xmlns=\\\"http://www.w3.org/2000/svg\\\" xmlns:xlink=\\\"http://www.w3.org/1999/xlink\\\" version=\\\"1.0\\\" x=\\\"0px\\\" y=\\\"0px\\\" width=\\\"100px\\\" height=\\\"100px\\\" viewBox=\\\"0 0 100 100\\\" enable-background=\\\"new 0 0 100 100\\\" xml:space=\\\"preserve\\\">\\n                                            <path d=\\\"M19.453,27.837c3.151,0,5.698-2.551,5.698-5.697c0-3.15-2.546-5.702-5.698-5.702 c-3.15,0-5.696,2.551-5.696,5.702C13.757,25.286,16.303,27.837,19.453,27.837z\\\"/>\\n                                            <circle cx=\\\"81.189\\\" cy=\\\"22.138\\\" r=\\\"5.699\\\"/>\\n                                            <path d=\\\"M50.35,27.837c3.147,0,5.697-2.551,5.697-5.697c0-3.15-2.55-5.702-5.697-5.702 c-3.151,0-5.702,2.551-5.702,5.702C44.648,25.286,47.199,27.837,50.35,27.837z\\\"/>\\n                                            <circle cx=\\\"81.189\\\" cy=\\\"22.138\\\" r=\\\"5.699\\\"/>\\n                                            <path d=\\\"M89.036,35.577l9.913-11.868c1.292-1.549,1.085-3.858-0.467-5.151c-1.551-1.293-3.85-1.086-5.146,0.462 c0,0-7.637,9.068-7.658,9.057c-1.274,1.124-2.936,1.811-4.763,1.811c-1.71,0-3.278-0.597-4.507-1.59 c-0.019,0.007-0.01,0.004-0.006,0l-7.873-9.277c-0.771-0.923-1.904-1.366-3.019-1.301c-1.116-0.064-2.242,0.378-3.018,1.301 c0,0-7.637,9.068-7.654,9.057c-1.273,1.124-2.939,1.811-4.763,1.811c-1.709,0-3.278-0.597-4.507-1.59h-0.004l-7.875-9.277 c-0.78-0.93-1.92-1.372-3.044-1.301c-1.128-0.071-2.274,0.371-3.045,1.301c0,0-7.64,9.068-7.658,9.057 c-1.273,1.124-2.939,1.811-4.768,1.811c-1.71,0-3.274-0.597-4.507-1.59l-7.878-9.277c-1.292-1.549-3.596-1.756-5.146-0.462 c-1.552,1.292-1.755,3.602-0.463,5.151L11.61,36.194v12.185c0,0.337,0.026,0.661,0.071,0.987l-1.595,30.765 c-0.146,2.055,1.405,3.838,3.458,3.979c2.054,0.141,3.834-1.401,3.975-3.459l1.269-24.463c0.224,0.017,0.44,0.035,0.665,0.035 c0.273,0,0.542-0.014,0.807-0.044l1.679,24.472c0.137,2.058,1.921,3.6,3.978,3.459c2.05-0.142,3.605-1.925,3.46-3.979 l-2.124-30.939c0.026-0.267,0.044-0.541,0.044-0.813V35.577l7.35-8.799l7.861,9.417v2.594L39,62.291h2.903l-0.925,17.84 c-0.141,2.055,1.405,3.838,3.458,3.979c2.058,0.141,3.842-1.401,3.983-3.459l0.952-18.36h2.199l1.255,18.36 c0.15,2.058,1.93,3.6,3.983,3.459c2.054-0.142,3.604-1.925,3.463-3.979l-1.225-17.84h2.864L58.193,37.37v-1.793l7.318-8.764 l7.838,9.382v12.185c0,0.337,0.021,0.661,0.067,0.987l-1.596,30.765c-0.141,2.055,1.405,3.838,3.458,3.979 c2.054,0.141,3.838-1.401,3.983-3.459l1.267-24.463c0.215,0.017,0.436,0.035,0.66,0.035c0.271,0,0.542-0.014,0.807-0.044 l1.674,24.472c0.145,2.058,1.929,3.6,3.983,3.459c2.05-0.142,3.601-1.925,3.459-3.979l-2.125-30.939 c0.032-0.267,0.049-0.541,0.049-0.813V35.577z\\\"/>\\n                                            <circle cx=\\\"81.189\\\" cy=\\\"22.138\\\" r=\\\"5.699\\\"/>\\n                                            </svg>\",\"tag\":\"crowd\"},{\"url\":\"happy.svg\",\"textSrc\":null,\"metaInfo\":null,\"corelation\":null,\"id\":13,\"imageName\":\"Happy\",\"dataSource\":\"<svg xmlns=\\\"http://www.w3.org/2000/svg\\\" xmlns:xlink=\\\"http://www.w3.org/1999/xlink\\\" version=\\\"1.1\\\" x=\\\"0px\\\" y=\\\"0px\\\" width=\\\"100px\\\" height=\\\"100px\\\" viewBox=\\\"0 0 100 100\\\" enable-background=\\\"new 0 0 100 100\\\" xml:space=\\\"preserve\\\">\\n    <path d=\\\"M49.998,4C24.596,4,4,24.597,4,50c0,25.405,20.596,46,45.998,46C75.404,96,96,75.405,96,50C96,24.597,75.404,4,49.998,4z    M49.998,86C30.119,86,14,69.882,14,50c0-19.883,16.119-36,35.998-36C69.883,14,86,30.117,86,50C86,69.882,69.883,86,49.998,86z\\\"></path>\\n    <circle cx=\\\"36.5\\\" cy=\\\"38.86\\\" r=\\\"6.667\\\"></circle>\\n    <circle cx=\\\"63.5\\\" cy=\\\"38.86\\\" r=\\\"6.667\\\"></circle>\\n    <path d=\\\"M70.84,57.883c-2.119-1.297-4.89-0.629-6.187,1.49c-2.71,4.431-8.462,7.293-14.653,7.293s-11.943-2.862-14.653-7.293   c-1.297-2.119-4.067-2.787-6.187-1.49c-2.12,1.297-2.787,4.067-1.49,6.188C32.046,71.223,40.602,75.666,50,75.666   s17.955-4.443,22.331-11.596C73.628,61.95,72.961,59.18,70.84,57.883z\\\"></path>\\n    </svg>\",\"tag\":\"happy\"},{\"url\":\"man.svg\",\"textSrc\":null,\"metaInfo\":null,\"corelation\":null,\"id\":5,\"imageName\":\"Man\",\"dataSource\":\"<svg version=\\\"1.0\\\" id=\\\"Layer_1\\\" xmlns=\\\"http://www.w3.org/2000/svg\\\" xmlns:xlink=\\\"http://www.w3.org/1999/xlink\\\" x=\\\"0px\\\" y=\\\"0px\\\" width=\\\"100px\\\" height=\\\"100px\\\" viewBox=\\\"0 0 37.207 100\\\" enable-background=\\\"new 0 0 37.207 100\\\" xml:space=\\\"preserve\\\">\\n<circle cx=\\\"18.118\\\" cy=\\\"8.159\\\" r=\\\"8.159\\\"></circle>\\n<path d=\\\"M8.472,95.426c0,2.524,2.05,4.574,4.574,4.574c2.529,0,4.576-2.05,4.576-4.574l0.004-38.374h2.037L19.65,95.426\\n\\tc0,2.524,2.048,4.574,4.574,4.574s4.573-2.05,4.573-4.574l0.02-66.158h2.006v24.38c0,4.905,6.398,4.905,6.384,0v-24.9\\n\\tc0-5.418-3.184-10.728-9.523-10.728L9.396,18.012C3.619,18.012,0,22.722,0,28.599v25.05c0,4.869,6.433,4.869,6.433,0v-24.38h2.048\\n\\tL8.472,95.426z\\\"></path>\\n</svg>\",\"tag\":\"man, person\"}]}";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        boolean result = instance.injestJson(doc, json);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String doc = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.delete(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String doc = "";
        String xml = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.update(doc, xml);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        String expResult = "";
        String result = instance.listAll();
        System.out.println(result);
    }

    /**
     * Test of connect method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = true;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        result = instance.release();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of injestJson method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testInjestJson() {
        System.out.println("injestJson");
        String doc = "";
        String json = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        boolean expResult = false;
        boolean result = instance.injestJson(doc, json);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageWord method, of class IwRepoDAOMarkLogicImplStud.
     */
    @Test
    public void testGetImageWord() throws Exception {
        System.out.println("getImageWord");
        String word = "";
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        ImageWord expResult = null;
        ImageWord result = instance.getImageWord(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}