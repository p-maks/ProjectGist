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
    public SentenceTemplate(String input){
        this.input=input;
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