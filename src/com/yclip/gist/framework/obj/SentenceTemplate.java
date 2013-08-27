/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import com.yclip.gist.framework.util.Util;
import java.util.ArrayList;


/**
 *
 * @author m
 */
public class SentenceTemplate {

    String input;
    ArrayList<String> wordInput;
    String inputXML;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public ArrayList<String> getWordInput() {
        return wordInput;
    }

    public void setWordInput(ArrayList<String> wordInput) {
        this.wordInput = wordInput;
    }

    public String getInputXML() {
        return inputXML;
    }

    public void setInputXML(String inputXML) {
        this.inputXML = inputXML;
    }

    public SentenceTemplate(String input) {
        this.input = input;
        Util util = new Util();
        //Split the input into words and remove punctuation
        wordInput = util.splitSentence(input);


        convertToInputXML(input);
    }

    private String convertToInputXML(String input) {

        return inputXML;
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