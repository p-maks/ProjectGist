/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 1. reference to basic/most common word set 2. reference to ontology 3.
 * reference to MT corpus
 *
 * @author P Maksymchuk
 */
@XmlRootElement(name = "ImageTextSrc")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageTextSource {
    // XmLElementWrapper generates a wrapper element around XML representation

    private String ontology;
    private String wordSet;
    
    

    public ImageTextSource() {
    }

    public ImageTextSource(String ontology, String wordSet) {
        this.ontology = ontology;
        this.wordSet = wordSet;
    }

    
    
    public String toString(){        
        return "Ontology URI: " + ontology + "\n" + "Wordset URI: " + wordSet;
    }
}
