/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.yclip.gist.framework.exceptions.NoWordException;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.IwRepoDAOImplStud;

/**
 *
 * @author m
 */
public class ImageFinder {
    public ImageSentence constructImageSentence(SentenceTemplate sT) throws Exception{
        ImageSentence iS=new ImageSentence();
        
        
        for (SentenceWord sW : sT.getSentenceWords()){
            if(sW.isDTT()){
                //Direct transer text, do something with it
            }else{
                //find the image and add it to the sentance
                try{    
                iS.addImageWord(findImage(sW.getWord()));
                }catch(NoWordException e){
                    
                }
            }
        }
                
        
        
        return iS;
    }
    
    public ImageWord findImage(String word)throws Exception{
        
        ImageWord iW = new ImageWord();
        // get IwRepoDAO
        IwRepoDAOImplStud iwRepoDao = (IwRepoDAOImplStud) DaoFactory.getInstance().getDAO(DaoFactory.IW_REPO_DAO_CLASS);
        
        iW = iwRepoDao.getImageWord(word);
        
        return iW;
    }
}
