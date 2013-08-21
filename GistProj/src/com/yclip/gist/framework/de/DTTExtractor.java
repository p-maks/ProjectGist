/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;
import com.yclip.gist.framework.obj.SentenceTemplate;
/**
 *
 * @author m
 * 
 * Extract the Direct transfer text (DTT) from the sentence 
 */
public class DTTExtractor {
    String tempSentence;
   
    public SentenceTemplate tagDTT(SentenceTemplate sT){
        boolean firstLoop = true;
        for (String word : sT.getWordInput())  
        {  
            //Add a space to the end of the sentance, as long as it's not empty,
            //doing it this way means no space at the end of the sentence
            if(!firstLoop){                
                tempSentence = tempSentence + " ";
            }else{
                firstLoop = false;
            }
            
            if(searchDTT(word)){
               tempSentence = tempSentence + "<DTT>" + word + "</DTT>" ;
               
            }else{
               tempSentence = tempSentence + word;
            }
        }    
        
        sT.setInput(tempSentence);
        
        return sT;
    }
    
    private boolean searchDTT(String word){
        
        if(DTTrepository.contains(word)){
            return true;
            
        }else{
            return false;
        }
        
        
    }
    
    
}
