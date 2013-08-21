/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;
import com.yclip.gist.framework.de.DTTExtractor;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.ImageSentence;
/**
 *
 * @author m
 */
public class GistBuilder {
    //source images for the sentence
    public ImageSentence construct(SentenceTemplate sT){
        ImageSentence iS=new ImageSentence();
        
        ImageFinder iSource=new ImageFinder();
        //DTS tagging
        //image sourcing
        //
        
        iS = iSource.constructImageSentence(sT);
        
        return iS;
    }
    private void create(){
    }
}
