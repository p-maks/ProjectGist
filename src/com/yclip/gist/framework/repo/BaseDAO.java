/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yclip.gist.framework.repo;

import com.marklogic.client.query.MatchDocumentSummary;
import java.io.UnsupportedEncodingException;

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
    public boolean injest(String xml, String doc) throws UnsupportedEncodingException;
    
    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injestFile(String xml, String doc);
    
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
     * See if a record is in the database
     * 
     * @param doc, the document to be updated
     * @param xml, the updated record
     * 
     * @return true if word is in repo
     */
    public boolean contains(String word);
    
    
    /*
     * Search the database for a specific document
     *  
     * @param the word to search for
     * 
     * @return the Java search summary object
     */
    public MatchDocumentSummary[] search(String word);
    
    
     /*
     * Search the database for a specific document
     *  
     * @param the uri for the document
     * 
     * @return the Java object
     */
    public Object getObjectFromURI(String uri);

}
