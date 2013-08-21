/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

/**
 *
 * @author m
 */
public class SentenceTemplate {
    String input;
    String wordInput[];
    String inputXML;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String[] getWordInput() {
        return wordInput;
    }

    public void setWordInput(String[] wordInput) {
        this.wordInput = wordInput;
    }

    public String getInputXML() {
        return inputXML;
    }

    public void setInputXML(String inputXML) {
        this.inputXML = inputXML;
    }
    
    public SentenceTemplate(String input){
        this.input=input;
        //Split the input into words
        this.wordInput = input.split(" ");
        
        convertToInputXML(input);
    }
    
    private String convertToInputXML(String input){
        
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