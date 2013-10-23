/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yclip.gist.framework.repo;

/**
 * <p>Data Access Object (DAO) interface is a parent interface for all of
 * the other interfaces in the data access layer and to provides common methods to all DAOs</p>
 * <p>This interface used to provide common methods to all DAOs.</p>

 * @author P Maksymchuk
 */
public interface BaseDAO {
    
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

}
