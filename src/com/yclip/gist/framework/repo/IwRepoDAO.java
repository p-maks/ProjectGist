/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.obj.ImageWord;

/**
 *
 * @author Chaka
 */
public interface IwRepoDAO extends BaseDAO{
    /**
     * <p>Checks if given word is in the Universal Image set (UIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkUIS(String word);
    
    
    
    /**
     * <p>Checks if given word is in the Generic Image set (GIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkGIS(String word);
    
    /**
     * <p>Checks if given word is in the Localised Image set (LIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkLIS(String word);
    
    /**
     * <p>Gets image word from the Universal Image set (UIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getUIS(String word);
    
    /**
     * <p>Gets image word from the Generic Image set (GIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getGIS(String word);
    
    /**
     * <p>Gets image word from the Localised Image set (LIS).</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public ImageWord getLIS(String word);
    
    
    
    
}
