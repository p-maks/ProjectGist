/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities for other classes to make use of
 * 
 * @author Chaka
 */
public class Util {
    
    
    public ArrayList<String> splitSentence(String sentence){
        
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(sentence);
        ArrayList<String> words = new ArrayList<>();
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                // Add double-quoted string without the quotes
                words.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // Add single-quoted string without the quotes
                words.add(regexMatcher.group(2));
            } else {
                // Add unquoted word
                words.add(regexMatcher.group());
            }
        }
        return words;
        
    }
    
    
}
