/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Collection of Image Words
 *
 * @author m
 */
//This statement means that class "ImageSentence.java" is the root-element of our example
@XmlRootElement(name = "ImageSentence")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageSentence {

    // XmlElement sets the name of the entities
    @XmlElement(name = "ImageWord")
    private Collection<ImageWord> imageWords;
    private SentenceTemplate sentenceTemplate;

    public ImageSentence() {
        imageWords = new ArrayList<>();
    }

    public SentenceTemplate getSentenceTemplate() {
        return sentenceTemplate;
    }

    public void setSentenceTemplate(SentenceTemplate sentenceTemplate) {
        this.sentenceTemplate = sentenceTemplate;
    }

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

    /**
     * @param imageWord to add to the imageWords to set
     */
    public void addImageWord(ImageWord iW) {
        imageWords.add(iW); //To change body of generated methods, choose Tools | Templates.
    }
}
