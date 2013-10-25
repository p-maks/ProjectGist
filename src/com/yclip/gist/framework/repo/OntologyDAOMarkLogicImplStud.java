/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.GenericDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.yclip.gist.framework.obj.Ontology;
import com.yclip.gist.framework.obj.WordSet;
import com.yclip.gist.framework.util.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

/**
 *
 * @author Chaka
 */
public class OntologyDAOMarkLogicImplStud implements BaseDAO{

    @Override
    public boolean injest(String xml, String doc) {
        //Connect to word set server
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream;
        try {
            stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));

            // create a handle on the content
            InputStreamHandle handle = new InputStreamHandle(stream);

            // write the document content
            docMgr.write(doc, handle);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Wrote " + doc + " content");

        client.release();
        return true;
    }
    
    public boolean injestFile(String uri, String doc) {
        
        //Connect to Ontology server
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // acquire the content
        InputStream docStream = OntologyDAOMarkLogicImplStud.class.getClassLoader().getResourceAsStream(uri);
        
        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(docStream);
        
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        
        // write the document content
        docMgr.write(doc, handle);

        System.out.println("Wrote " + doc + " ontology");

        // release the client
        client.release();
        return true;
    }
    
    public boolean contains(String word){
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("onto")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        
        //no longer need the database connection
        client.release();
        return resultsHandle.get().contains(word);
    }

    @Override
    public boolean delete(String xml) {
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // create a generic manager for documents
        GenericDocumentManager docMgr = client.newDocumentManager();

        // delete the documents
        docMgr.delete(xml);

        client.release();
        return true;
    }

    @Override
    public boolean update(String doc, String xml) {
        //Connect to word set server
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        //Convert string to InputStream
        InputStream stream;
        try {
            stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));

            // create a handle on the content
            InputStreamHandle handle = new InputStreamHandle(stream);

            // write the document content
            docMgr.write(doc, handle);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Wrote " + doc + " content");

        client.release();
        return true;
    }

    @Override
    public String listAll() {
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        StringQueryDefinition query = queryMgr.newStringDefinition();

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        client.release();
        return resultsHandle.get();
    }
    
    @Override
    public MatchDocumentSummary[] search(String word) {
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("onto")), word);

        // create a handle for the search results
	SearchHandle resultsHandle = new SearchHandle();

        // run the search
        queryMgr.search(query, resultsHandle);
        
        client.release();
        
        return resultsHandle.getTotalResults()==0?null:resultsHandle.getMatchResults();
    }
    
    @Override
    public Object getObjectFromURI(String uri) {
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        
        
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        Ontology on = null;
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(Ontology.class);
			// create a handle to receive the document content
			JAXBHandle readHandle = new JAXBHandle(context);

			// read the JAXB object from the document content
			docMgr.read(uri, readHandle);

			// access the document content
			on = (Ontology) readHandle.get();

		} catch (JAXBException e) {
			Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, e);
		}
                
                      
        //no longer need the database connection
        client.release();
        
        return on;
    }
    
    
}
