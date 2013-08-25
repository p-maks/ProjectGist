/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.obj.ImageWord;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Chaka
 */
public class IwRepoDAOImplStud implements IwRepoDAO{
    
    private static Set UISSet = new HashSet<String>() {
        {
            add("airport");
            add("leave");
        }
    };
    
    private static Set LISSet = new HashSet<String>() {
        {
            add("mobbed");
        }
    };
    
    private static Set GISSet = new HashSet<String>() {
        {
            add("Man Utd");
            add("team");
            add("fans");
            add("they");
        }
    };
    
    
    /**
     * <p>Checks if given word is in the Universal Image set (UIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkUIS(String word){
        return UISSet.contains(word);
    }
    
    
    
    /**
     * <p>Checks if given word is in the Generic Image set (GIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkGIS(String word){
        return GISSet.contains(word);
    }
    
    /**
     * <p>Checks if given word is in the Localised Image set (LIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkLIS(String word){
        return LISSet.contains(word);
    }
    
    /**
     * <p>Gets image word from the Universal Image set (UIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getUIS(String word){
        return null;
    }
    
    /**
     * <p>Gets image word from the Generic Image set (GIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getGIS(String word){
        return null;
    }
    
    /**
     * <p>Gets image word from the Localised Image set (LIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getLIS(String word){
        return null;
    }

    public ImageWord getImageWord(String word) {
        ImageWord iW = new ImageWord("test");
        
        if(checkUIS(word)){
            iW = getUIS(word);
        }else if(checkLIS(word)){
            iW = getLIS(word);            
        }else{
            iW = getGIS(word);
        }
        
        return iW;
    }
    
}
