/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.ImageSentence;
/**
 *
 * @author m
 */
public class GistBuilder {
    //source images for the sentence
    public ImageSentence construct(SentenceTemplate s){
        ImageSentence iS=new ImageSentence();
        DTTExtractor dtsE=new DTTExtractor();
        ImageFinder iSource=new ImageFinder();
        //DTS tagging
        //image sourcing
        //
        s=dtsE.tagDTT(s);
        iSource.
        
        return iS;
    }
    private void create(){
    }
}
