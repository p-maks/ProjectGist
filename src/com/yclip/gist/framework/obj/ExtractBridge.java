/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.obj;

import com.vistence.semantic.framework.core.IExtractionSource;

/**
 *
 * @author Chaka
 */
public class ExtractBridge implements IExtractionSource{
    String sentence;
    
    public ExtractBridge(String sentence){
        this.sentence=sentence;
    }
    @Override
    public String getSentence() {
        return sentence;
    }
    
}
