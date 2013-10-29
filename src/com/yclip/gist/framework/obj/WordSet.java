/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chaka
 */
@XmlRootElement(name="wordset")
@XmlAccessorType(XmlAccessType.FIELD)
public class WordSet {
    @XmlAttribute(name="name")
    private String imageWord;
    // XmlElement sets the name of the entities
    @XmlElement(name = "word")
    public Set wordSet = new HashSet<String>();

    public Set getWordSet() {
        return wordSet;
    }

    public void setWordSet(Set wordSet) {
        this.wordSet = wordSet;
    }
    
    public String getImageWord() {
        return imageWord;
    }

    public void setImageWord(String imageWord) {
        this.imageWord = imageWord;
    }
    
    public String toString(){
        String string = "Image word: " + imageWord +"\n"+
                "Word Set: \n";
        for (Object word : wordSet) {
            
            string= string + word.toString() +"\n";
        }
        return string;
    }
    
}
