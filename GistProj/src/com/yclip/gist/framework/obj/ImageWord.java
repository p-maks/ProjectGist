/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author P Maksymchuk
 */
@XmlRootElement
public class ImageWord {
    private String url;
    private ImageTextSource textSrc;
    private MetaInfo metaInfo;
    private ImageCorelation corelation;

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
