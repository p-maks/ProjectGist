/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //Split the input into words and remove punctuation
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(input);
        wordInput = new ArrayList<>();
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                // Add double-quoted string without the quotes
                wordInput.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // Add single-quoted string without the quotes
                wordInput.add(regexMatcher.group(2));
            } else {
                // Add unquoted word
                wordInput.add(regexMatcher.group());
            }
        }


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