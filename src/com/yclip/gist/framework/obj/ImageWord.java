/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

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

    //Image word uri in mark logic
    private String url;
    private String repoType;
    private String fileType;
    private String imageSource;
    private String dataSource;
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
    
    public ImageWord(String url, ImageTextSource textSrc, String fileType, String dataSource, String imageSource, String repoType) {
        this.url = url;
        this.textSrc = textSrc;
        this.fileType = fileType;
        this.dataSource = dataSource;
        this.imageSource = imageSource;
        this.repoType = repoType;
        
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
    

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
    public String getRepoType() {
        return repoType;
    }

    public void setRepoType(String repoType) {
        this.repoType = repoType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
    
    public String toString(){
        String string = "";
        if(url!=null){
        string = string + "URL: "+ url + "\n";
        }
        if(fileType!=null){
                string = string + "File type: " + fileType + "\n";
        }
        if(repoType!=null){
                string = string + "Repo type: " + repoType + "\n";
        }
        if(imageSource!=null){
                string = string + "Image Source: " + imageSource + "\n";
        }
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
