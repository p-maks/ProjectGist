/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.document.GenericDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.QueryManager;
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
        query.put(queryMgr.newElementLocator(new QName("DTT")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);

        //no longer need the database connection
        release();

        if (resultsHandle.get().contains(word)) {
            return false;
        }
        return true;
    }


    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injest(String xml) {
        connect();


        release();
        return false;
    }

    /*
     * delete a record in the database
     * 
     * @param the xml to delete into the database
     * 
     * @return true if delete succeeds;
     */
    public boolean delete(String xml) {
        connect();
        // create a generic manager for documents
        GenericDocumentManager docMgr = client.newDocumentManager();

        // delete the documents
        docMgr.delete(xml);

        release();
        return true;
    }

    /*
     * Update a record in the database
     * 
     * @param dtt, the dtt record to be updated
     * @param xml, the updated record
     * 
     * @return true if update succeeds
     */
    public boolean update(String dtt, String xml) {
        connect();


        release();
        return false;
    }

    /*
     * List all database
     */
    public String listAll() {
        connect();
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();

        // create a handle to receive the document content
        DOMHandle handle = new DOMHandle();

        // read the document content
        docMgr.read("/dttrepo/dtt.xml", handle);

        // access the document content
        Document document = handle.get();

        String rootName = document.getDocumentElement().getTagName();

        release();
        return null;
    }

    /*
     * Create connection to the database
     */
    public boolean connect() {
        //TODO sort out auth
        Authentication auth = "DIGEST";
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
