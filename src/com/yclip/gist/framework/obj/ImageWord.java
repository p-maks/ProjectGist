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
    
}
