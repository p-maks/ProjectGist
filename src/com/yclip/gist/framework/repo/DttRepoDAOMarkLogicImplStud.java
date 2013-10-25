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
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.yclip.gist.framework.obj.Dtt;
import com.yclip.gist.framework.obj.Ontology;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import org.w3c.dom.Document;

/**
 *
 * @author Chaka
 */
public class DttRepoDAOMarkLogicImplStud implements DttRepoDAO{

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
        SearchHandle resultsHandle = new SearchHandle();
        
        // run the search
        queryMgr.search(query, resultsHandle);
        //no longer need the database connection
        release();

        
        return  resultsHandle.getTotalResults() == 0 ? false: true;
    }


    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    @Override
    public boolean injest(String doc, String xml){
        connect();
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DttRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public boolean update(String doc, String xml){
        connect();
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DttRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public boolean contains(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean injestFile(String xml, String doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public MatchDocumentSummary[] search(String word) {
        
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("Word")), word);

        // create a handle for the search results
	SearchHandle resultsHandle = new SearchHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        
        release();
        
        return resultsHandle.getTotalResults()==0?null:resultsHandle.getMatchResults();
    }
    
    @Override
    public Object getObjectFromURI(String uri) {
        connect();
        
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        Dtt dtt = null;
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(Dtt.class);
			// create a handle to receive the document content
			JAXBHandle readHandle = new JAXBHandle(context);

			// read the JAXB object from the document content
			docMgr.read(uri, readHandle);

			// access the document content
			dtt = (Dtt) readHandle.get();

		} catch (JAXBException e) {
			Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, e);
		}
                
                      
        //no longer need the database connection
        release();
        
        return dtt;
    }
}
