/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 1. reference to basic/most common word set 
 * 2. reference to ontology 
 * 3. reference to MT corpus
 *
 * @author P Maksymchuk
 */
@XmlRootElement
public class ImageTextSource {
    
    public Set wordSet = new HashSet<String>();

    public Set getWordSet() {
        return wordSet;
    }

    public void setWordSet(Set wordSet) {
        this.wordSet = wordSet;
    }
    
    public ImageTextSource(Set wordSet){
        this.wordSet = wordSet;
    }
}
