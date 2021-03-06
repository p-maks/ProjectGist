/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import com.yclip.gist.framework.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author m
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SentenceTemplate {

    private String input;
    private List<SentenceWord> sentenceWords;
    private String taggedSentence;

    private SentenceTemplate() {
    }

    public SentenceTemplate(String input) {
        this.input = input;
    }

    public SentenceTemplate(String input, List<SentenceWord> wordInput) {
        this.input = input;
        //Split the input into words and remove punctuation
        this.sentenceWords = wordInput;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<SentenceWord> getSentenceWords() {
        return sentenceWords;
    }

    public void setSentenceWords(List<SentenceWord> sentenceWords) {
        this.sentenceWords = sentenceWords;
    }

    public String getTaggedSentence() {
        return taggedSentence;
    }

    public void setTaggedSentence(String taggedSentence) {
        this.taggedSentence = taggedSentence;
    }
}

/**
 * <Sentence>
 *  <Word>
 *      <wordPart>
 *      <DTS>
 * </Word>
 * </Sentence>
 **/