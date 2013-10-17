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
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injest(String xml, String Doc);
    
    /*
     * delete a record in the database
     * 
     * @param the xml to delete into the database
     * 
     * @return true if delete succeeds;
     */
    public boolean delete(String xml);
    
    /*
     * Update a record in the database
     * 
     * @param doc, the document to be updated
     * @param xml, the updated record
     * 
     * @return true if update succeeds
     */
    public boolean update(String doc, String xml);
 
    
    /*
     * List all database
     */
    public String listAll();
    
    
    /*
     * Create connection to the database
     */
    public boolean connect();
    
    /*
     * Release the database
     */
    public boolean release();
}
