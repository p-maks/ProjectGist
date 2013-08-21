/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.DttRepoDAO;
/**
 *
 * @author m
 */
public class DTTExtractor {
    
   
    public SentenceTemplate tagDTT(SentenceTemplate sT) throws Exception{
        boolean firstLoop = true;
        String tempSentence = "";
        
        // get DttRepoDAO
        DttRepoDAO dttRepoDao = (DttRepoDAO) DaoFactory.getInstance().getDAO(DaoFactory.DTT_REPO_DAO_CLASS);
        
        
        for (String word : sT.getWordInput())  
        {  
            //Add a space to the end of the sentance, as long as it's not empty,
            //doing it this way means no space at the end of the sentence
            if(!firstLoop){                
                tempSentence = tempSentence + " ";
            }else{
                firstLoop = false;
            }
            
            if(dttRepoDao.checkDtt(word)){
               tempSentence = tempSentence + "<DTT>" + word + "</DTT>" ;
               
            }else{
               tempSentence = tempSentence + word;
            }
        }    
        
        sT.setInput(tempSentence);
        
        return sT;
    }
    
    
}