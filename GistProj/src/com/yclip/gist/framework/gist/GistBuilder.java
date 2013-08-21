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
        DTTExtractor dtsE=new DTTExtractor();
        ImageFinder iSource=new ImageFinder();
        //DTS tagging
        //image sourcing
        //
        sT=dtsE.tagDTT(sT);
        iS = iSource.constructImageSentence(sT);
        
        return iS;
    }
    private void create(){
    }
}
