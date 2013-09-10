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

    /*
     * Source images for the sentence
     * 
     * @param SentenceTemplate which has already been tagged for DTT
     * 
     * @return ImageSentence which has been constructed
     * 
     */
    public ImageSentence construct(SentenceTemplate sT) throws Exception {
        ImageSentence iS = new ImageSentence();

        ImageFinder iSource = new ImageFinder();
        //DTS tagging
        //image sourcing
        //

        iS = iSource.constructImageSentence(sT);

        return iS;
    }

    private void create() {
    }
}
