/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.Collection;

/**
 * Collection of Image Words
 * @author m
 */
public class ImageSentence {
    
     private Collection<ImageWord> imageWords;

    /**
     * @return the imageWords
     */
    public Collection<ImageWord> getImageWords() {
        return imageWords;
    }

    /**
     * @param imageWords the imageWords to set
     */
    public void setImageWords(Collection<ImageWord> imageWords) {
        this.imageWords = imageWords;
    }

    public void addImageWord(ImageWord iW) {
        imageWords.add(iW); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
