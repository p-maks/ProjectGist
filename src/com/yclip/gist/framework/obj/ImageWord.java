/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author P Maksymchuk
 */
@XmlRootElement(name = "ImageWord")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageWord {
    @XmlElement(name = "ImageSource")
    private String url;
    @XmlElement(name = "ImageTextSource")
    private ImageTextSource textSrc;
    private MetaInfo metaInfo;
    private ImageCorelation corelation;
    
    public ImageWord(){
    }
    
    public ImageWord(String url){
        this.url = url;
    }
    
    public ImageWord(String url, ImageTextSource textSrc){
        this.url = url;
        this.textSrc = textSrc;
    }
    
    

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageTextSource getTextSrc() {
        return textSrc;
    }

    public void setTextSrc(ImageTextSource textSrc) {
        this.textSrc = textSrc;
    }

    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    public ImageCorelation getCorelation() {
        return corelation;
    }

    public void setCorelation(ImageCorelation corelation) {
        this.corelation = corelation;
    }
    
    
}
