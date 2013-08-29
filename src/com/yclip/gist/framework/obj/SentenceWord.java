/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chaka
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SentenceWord {

    public SentenceWord() {
    }

    private String word;
    private boolean dtt;

    public boolean isDTT() {
        return dtt;
    }

    public void setDTT(boolean isDTT) {
        this.dtt = isDTT;
    }

    public SentenceWord(String word) {
        this.word = word;
        dtt = false;
    }

    public SentenceWord(String word, boolean dtt) {
        this.word = word;
        this.dtt = dtt;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public String toString(){
        return "SentenceWord: "+ word + " isDTT:" + dtt;
    }
}
