/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.document.GenericDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.namespace.QName;
import org.w3c.dom.Document;

/**
 *
 * @author Chaka
 */
public class DttRepoDAOMarkLogicImplStud {

    DatabaseClient client;

    /**
     * <p>Checks if given word is DTT.</p>
     *
     * @param word the string to be checked
     *
     * @return a <code>true</code> if its is <code>false</code> otherwise
     *
     */
    public boolean checkDtt(String word) {
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("DTTItem")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        
        //no longer need the database connection
        release();

        
        return resultsHandle.get().contains(word);
    }


    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injest(String doc, String xml) throws UnsupportedEncodingException {
        connect();
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(stream);
        
        // write the document content
        docMgr.write(doc, handle);
        
        System.out.println("Wrote "+doc+" content");

        release();
        return true;
    }

    /*
     * delete a record in the database
     * 
     * @param the document to delete from the database
     * 
     * @return true if delete succeeds;
     */
    public boolean delete(String doc) {
        connect();
        // create a generic manager for documents
        GenericDocumentManager docMgr = client.newDocumentManager();

        // delete the documents
        docMgr.delete(doc);

        release();
        return true;
    }

    /*
     * Update a record in the database
     * 
     * @param doc, the document to be updated
     * @param xml, the updated record
     * 
     * @return true if update succeeds
     */
    public boolean update(String doc, String xml) throws UnsupportedEncodingException {
        connect();
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(stream);
        
        // write the document content
        docMgr.write(doc, handle);
        
        System.out.println("Wrote "+doc+" content");

        release();
        return true;
    }

    /*
     * List all database
     */
    public String listAll() {
        connect();
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        StringQueryDefinition query = queryMgr.newStringDefinition();
        query.setCriteria("");

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        release();
        return resultsHandle.get();
    }

    /*
     * Create connection to the database
     */
    public boolean connect() {
        //TODO sort out auth
        Authentication auth = Authentication.valueOf("DIGEST");
        client = DatabaseClientFactory.newClient("localhost", 8011, "dtt-rest-admin", "vistence", auth);
        return true;
    }

    /*
     * Release the database
     */
    public boolean release() {
        client.release();
        return true;
    }
}
