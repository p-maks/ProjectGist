/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.util.Util;
import java.util.ArrayList;
import java.util.List;
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
public class DeControllerTest {
public static final String TEST_INPUT = "\"Man Utd\" team is mobbed by fans as they leave the airport";
    public DeControllerTest() {
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

    @Test
    public void testInputParse(){
        //Split the sentence into seperate words to be stored in the SentenceTemplate
        List<String> parsedInput = new Util().splitSentence(TEST_INPUT);
        assertTrue(parsedInput.size()>0);
                
        //Create list of sentence words from the split sentence
        List<SentenceWord> sentenceWords = new ArrayList();
        for (String object : parsedInput) {
            sentenceWords.add(new SentenceWord(object));
        }
        //Init SentenceTemplate
        SentenceTemplate sT = new SentenceTemplate(TEST_INPUT, sentenceWords);
        
        DTTExtractor dtsE=new DTTExtractor();
        try {
            sT=dtsE.tagDTT(sT);
        } catch (Exception ex) {
        }
        System.out.println("Initial input:" + sT.getInput());
        for (SentenceWord sentenceWord : sT.getSentenceWords()) {
            System.out.println("    "+ sentenceWord.toString());
        }
        
        
    }
    
    
    /**
     * Test of getImageSentence method, of class DeController.
     */
     @Test
    public void testGetImageSentence() throws Exception {
        System.out.println("getImageSentence");
        String input = "\"Man Utd\" team is mobbed by fans as they leave the airport";
        DeController instance = new DeController();
        String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<ImageSentence>\n" +
"    <ImageWord>\n" +
"        <ImageSource>manutdlogo.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">Man Utd</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>team.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">team</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>mobbed.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">mobbed</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>fans.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">fans</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>they.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">they</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>leave.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">leave</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"    <ImageWord>\n" +
"        <ImageSource>airport.jpeg</ImageSource>\n" +
"        <ImageTextSource>\n" +
"            <WordSet>\n" +
"                <Word xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">airport</Word>\n" +
"            </WordSet>\n" +
"        </ImageTextSource>\n" +
"    </ImageWord>\n" +
"</ImageSentence>\n";
        ImageSentence result = instance.getImageSentence(input);
        Util util = new Util();
        String resultString = util.generateImageSentenceXML(result);
        assertEquals(expResult, resultString);

        input = "\"Man Utd\" team is mobbed by fans as they leave the airport test";
        result = instance.getImageSentence(input);
        resultString = util.generateImageSentenceXML(result);
        assertEquals(expResult, resultString);
        
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
     
     @Test
     public void testAnotherGetImageSentence() throws Exception {
         System.out.println("Test image sentence");
         DeController instance = new DeController();
         ImageSentence result = instance.getImageSentence("time laser exit boy time day eye face \"walking out\" walking out");
         for (ImageWord iW : result.getImageWords()) {

            System.out.println(iW.toString());
     }
     }
}