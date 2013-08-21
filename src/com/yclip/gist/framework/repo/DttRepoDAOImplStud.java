/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Chaka
 */
public class DttRepoDAOImplStud implements DttRepoDAO {

    private static Set dttSet = new HashSet<String>() {
        {
            add("I");
            add("to");
            add("from");
            add("as");
            add("is");
            add("are");
            add("by");
            add("the");
        }
    };

    /**
     * <p>Checks if given word is DTT.</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkDtt(String word) {
        return dttSet.contains(word);
        
    }
}
