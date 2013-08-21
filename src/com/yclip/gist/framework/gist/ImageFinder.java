/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;

/**
 *
 * @author m
 */
public class ImageFinder {
    public ImageSentence constructImageSentence(SentenceTemplate sT){
        ImageSentence iS=new ImageSentence();
        for (String word : sT.getInput().split(" ")){
            if(word.startsWith("<DTT>")&&word.endsWith("</DTT>")){
                //Direct transer text, do something with it
            }else{
                //find the image and add it to the sentance
            }
        }
                
        
        
        return iS;
    }
    
    public ImageWord findImage(String word){
        
        ImageWord iW = new ImageWord();
        
        //todo find word in repo
        
        return iW;
    }
}
