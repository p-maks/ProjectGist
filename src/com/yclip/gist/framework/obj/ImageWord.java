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
    private String type;
    private String dataSource;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    @XmlElement(name = "ImageTextSource")
    private ImageTextSource textSrc;
    private MetaInfo metaInfo;
    private ImageCorelation corelation;

    public ImageWord() {
    }

    public ImageWord(String url) {
        this.url = url;
    }

    public ImageWord(String url, ImageTextSource textSrc) {
        this.url = url;
        this.textSrc = textSrc;
    }
    
    public ImageWord(String url, ImageTextSource textSrc, String type, String dataSource) {
        this.url = url;
        this.textSrc = textSrc;
        this.type = type;
        this.dataSource = dataSource;
        
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
    
    public String toString(){
        String string = "";
        if(url!=null){
        string = string + "URL: "+ url + "\n";
        }
        if(type!=null)
                string = string + "Type: " + type + "\n";
        if(dataSource!=null){
                string = string + "Data Source: " + dataSource + "\n";
        }
        if(textSrc!=null){
                string = string + "ImageTextSource " + textSrc.toString() + "\n"; 
        }
        if(metaInfo!=null){
                string = string + "Meta info: " + metaInfo.toString()+"\n";
        }
        if(corelation!=null){
                string = string + "Image Corelation: " + corelation.toString();
        }
        return string;
  
        
    }
}
