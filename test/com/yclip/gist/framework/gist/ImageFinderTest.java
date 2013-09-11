/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.yclip.gist.framework.de.DTTExtractor;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;
import java.util.ArrayList;
import java.util.HashSet;
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
public class ImageFinderTest {

    public static final String TEST_INPUT = "\"Man Utd\" team is mobbed by fans as they leave the airport";

    public ImageFinderTest() {
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
     * Test of constructImageSentence method, of class ImageFinder.
     */
    @Test
    public void testConstructImageSentence() throws Exception {
        System.out.println("constructImageSentence");
        SentenceTemplate sT = new SentenceTemplate(TEST_INPUT);
        ImageFinder instance = new ImageFinder();
        sT = new DTTExtractor().tagDTT(sT);
        String expResult = "<ss>Man Utd</ss> <ss>team</ss> <dtt>is</dtt> <ss>mobbed</ss> <dtt>by</dtt> <ss>fans</ss> <dtt>as</dtt> <ss>they</ss> <ss>leave</ss> <dtt>the</dtt> <ss>airport</ss>";
        assertEquals(expResult, sT.getTaggedSentence());
        ImageSentence result = instance.constructImageSentence(sT);
        //These words are hard coded into the iwRepoDAOImplStud for test purposes
        ArrayList<String> imageWordURLs = new ArrayList<String>();
        imageWordURLs.add("manutdlogo.jpeg");
        imageWordURLs.add("team.jpeg");
        imageWordURLs.add("mobbed.jpeg");
        imageWordURLs.add("fans.jpeg");
        imageWordURLs.add("they.jpeg");
        imageWordURLs.add("leave.jpeg");
        imageWordURLs.add("airport.jpeg");

        int i = 0;
        for (ImageWord iW : result.getImageWords()) {

            System.out.println(imageWordURLs.get(i));
            System.out.println(iW.getUrl());
            assertEquals(imageWordURLs.get(i), iW.getUrl());
            i++;
        }


    }

    /**
     * Test of findImage method, of class ImageFinder.
     */
    @Test
    public void testFindImage() throws Exception {
        System.out.println("findImage");
        String word = "";
        ImageFinder instance = new ImageFinder();
        ImageWord expResult = null;
        ImageWord result;


        word = "team";
        HashSet<String> tempSet = new HashSet<String>();
        tempSet.add("team");
        expResult = new ImageWord("team.jpeg", new ImageTextSource(tempSet));
        result = instance.findImage(word);
        assertEquals(expResult.getUrl(), result.getUrl());

    }
}