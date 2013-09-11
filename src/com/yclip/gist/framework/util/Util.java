/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

import com.yclip.gist.framework.obj.ImageSentence;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 * Utilities for other classes to make use of
 *
 * @author Chaka
 */
public class Util {

    /*
     * @param the sentence that needs to be split
     * @return an array of sentence segments
     */
    public List<String> splitSentence(String sentence) {

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

    /*
     * @param the sentence that needs to be split
     * @return an array of sentence segments
     */
    public List<String> splitTaggedSentence(String sentence) {

        Pattern regex = Pattern.compile("<ss>(.*)</ss>|<dtt>(.*)</dtt>");
        Matcher regexMatcher = regex.matcher(sentence);
        ArrayList<String> words = new ArrayList<>();
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                // ss tagg
                words.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // dtt tagged
                words.add(regexMatcher.group(2));
            } else {
                // should never get here
                words.add(regexMatcher.group());
            }
        }
        return words;

    }

    /*
     * @param the sentence that needs to be split
     * @return an array of sentence segments
     */
    public List<String> splitTaggedSentence2(String sentence) {
        List<String> words = new ArrayList<>();
        String temp;
        int index = 0;
        
        while (index < sentence.length()) {
            System.out.println(index);
            System.out.println(sentence.substring(index));
            if (sentence.substring(index).trim().startsWith("<dtt>")) {
                temp = sentence.substring(index, sentence.substring(index).indexOf("</dtt>", index));
                System.out.println(temp);
                words.add(temp);
                System.out.println(sentence.substring(index));
                index = sentence.substring(index).indexOf("</dtt>", index)+9;
            } else if (sentence.substring(index).trim().startsWith("<ss>")) {
                temp = sentence.substring(index, sentence.substring(index).indexOf("</ss>", index));
                System.out.println(temp);
                words.add(temp);
                index = sentence.substring(index).indexOf("</ss>", index)+6;
            }
        }
        return words;

    }

    /*
     * Generate the XML for the image sentence
     * 
     * @param Image Sentence
     * 
     * @return String representation of the Image Sentence
     */
    public String generateImageSentenceXML(ImageSentence iS) throws Exception {

        StringWriter xml = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(ImageSentence.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        m.marshal(iS, xml);
        return xml.toString();
    }
}
