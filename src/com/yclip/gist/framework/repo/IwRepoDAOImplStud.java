/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import java.util.HashSet;
import java.util.Set;
import com.yclip.gist.framework.exceptions.NoWordException;

/**
 *
 * @author Chaka
 */
public class IwRepoDAOImplStud implements IwRepoDAO{
    
    
    
    private static Set UISNameSet = new HashSet<String>() {
        {
            add("airport");
            add("leave");
        }
    };
    
    private static Set<ImageWord> UISSet = new HashSet<ImageWord>() {
        {
            Set tempSet = new HashSet<>();
            tempSet.add("airport");
            add(new ImageWord("airport.jpeg", new ImageTextSource(tempSet)));
            tempSet = new HashSet<>();
            tempSet.add("leave");
            add(new ImageWord("leave.jpeg", new ImageTextSource(tempSet)));
        }
    };
    
    private static Set LISNameSet = new HashSet<String>() {
        {
            add("mobbed");
        }
    };
    
    private static HashSet<ImageWord> LISSet = new HashSet<ImageWord>() {
        {
            Set tempSet = new HashSet<>();
            tempSet.add("mobbed");
            add(new ImageWord("mobbed.jpeg", new ImageTextSource(tempSet)));
        }
    };
    
    
    private static Set GISNameSet = new HashSet<String>() {
        {
            add("Man Utd");
            add("team");
            add("fans");
            add("they");
        }
    };
    
    private static HashSet<ImageWord> GISSet = new HashSet<ImageWord>() {
        {
            HashSet tempSet = new HashSet<>();
            tempSet.add("Man Utd");
            ImageTextSource tempITS = new ImageTextSource(tempSet);
            add(new ImageWord("manutdlogo.jpeg", tempITS));
            tempSet = new HashSet<>();
            tempSet.add("team");
            tempITS = new ImageTextSource(tempSet);
            add(new ImageWord("team.jpeg", tempITS));
            tempSet = new HashSet<>();
            tempSet.add("fans");
            add(new ImageWord("fans.jpeg", new ImageTextSource(tempSet)));
            tempSet = new HashSet<>();
            tempSet.add("they");
            add(new ImageWord("they.jpeg", new ImageTextSource(tempSet)));
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
        return UISNameSet.contains(word);
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
        return GISNameSet.contains(word);
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
        return LISNameSet.contains(word);
    }
    
    /**
     * <p>Gets image word from the Universal Image set (UIS).</p>
     *
     * @param word the string to be checked
     *
     * @return the ImageWord
     *
     */
    public ImageWord getUIS(String word){
        ImageWord returnIW = null;
        for(ImageWord iW: UISSet){
           if(iW.getTextSrc().getWordSet().contains(word)){
               returnIW= iW;
           }
        }
        
        return returnIW;
    }
    
    /**
     * <p>Gets image word from the Generic Image set (GIS).</p>
     *
     * @param word the string to be checked
     *
     * @return the ImageWord
     *
     */
    public ImageWord getGIS(String word){
        ImageWord returnIW = null;
        for(ImageWord iW: GISSet){
           if(iW.getTextSrc().getWordSet().contains(word)){
               returnIW = iW;
           }
        }
        
        return returnIW;
    }
    
    /**
     * <p>Gets image word from the Localised Image set (LIS).</p>
     *
     * @param word the string to be checked
     *
     * @return the ImageWord
     *
     */
    public ImageWord getLIS(String word){
        ImageWord returnIW = null;
        for(ImageWord iW: LISSet){
           if(iW.getTextSrc().getWordSet().contains(word)){
               returnIW= iW;
           }
        }
        
        return returnIW;
    }

    public ImageWord getImageWord(String word) throws NoWordException {
        ImageWord iW;
        
        if(checkUIS(word)){
            iW = getUIS(word);
        }else if(checkLIS(word)){
            iW = getLIS(word);            
        }else if(checkGIS(word)){
            iW = getGIS(word);
        }else{
            
            throw new NoWordException();
            
        }
        
        return iW;
    }

    @Override
    public boolean injest(String xml, String Doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String xml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String doc, String xml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
