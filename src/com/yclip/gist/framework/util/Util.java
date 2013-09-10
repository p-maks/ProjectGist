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
