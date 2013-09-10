/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.gist.GistBuilder;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Differential Engine Controller class to handle input from user and does
 * Sentence Template construction.
 *
 * @author m
 */
public class DeController {

    /* Create an ImageSentence from the input string
     * 
     * @param the String which we want to translate into an ImageSentence
     * 
     * @return the constucted ImageSentence 
     * 
     */
    public ImageSentence getImageSentence(String input) throws Exception {

        //Split the sentence into seperate words to be stored in the SentenceTemplate
        List<String> parsedInput = new Util().splitSentence(input);
        //Create list of sentence words from the split sentence
        List<SentenceWord> sentenceWords = new ArrayList();
        for (String object : parsedInput) {
            sentenceWords.add(new SentenceWord(object));
        }
        //Init SentenceTemplate
        SentenceTemplate sT = new SentenceTemplate(input, sentenceWords);

        DTTExtractor dtsE = new DTTExtractor();
        try {
            sT = dtsE.tagDTT(sT);
        } catch (Exception ex) {
            Logger.getLogger(DeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //break it down to sentences - initially we can make an assumption input alwaya a sentence
        //pass it onto gist processor    
        ImageSentence iS = new GistBuilder().construct(sT);
        Util util = new Util();
        System.out.print(util.generateImageSentenceXML(iS));
        return iS;
    }
}
