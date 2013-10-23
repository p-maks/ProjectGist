/*
 * UserDao.java
 */
package com.yclip.gist.framework.repo;

/**
 * DttRepoDAO interface is DAO interface for DTT repository management
 *
 * @author P Maksymchuk
 */
public interface DttRepoDAO extends BaseDAO {

    /**
     * <p>Checks if given word is DTT.</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkDtt(String word);
    
    
    
    
    /*
     * Create connection to the database
     */
    public boolean connect();
    
    /*
     * Release the database
     */
    public boolean release();
}
