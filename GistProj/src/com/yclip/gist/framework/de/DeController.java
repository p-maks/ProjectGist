/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.gist.GistBuilder;

/**
 * Differential Engine Controller class to handle input from user and does
 * Sentence Template construction.
 *
 * @author m
 */
public class DeController {

    public ImageSentence getImageSentence(String input) {
        
        SentenceTemplate sT = new SentenceTemplate(input);
        
        //break it down to sentences - initially we can make an assumption input alwaya a sentence
        //pass it onto gist processor    
        GistBuilder gP = new GistBuilder();
        return gP.construct(sT);
    }
}
