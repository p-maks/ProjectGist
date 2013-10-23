/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.yclip.gist.framework.obj.ImageWord;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.admin.QueryOptionsManager;
import com.marklogic.client.admin.config.QueryOptionsBuilder;
import com.marklogic.client.document.GenericDocumentManager;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.JAXBHandle;
import com.marklogic.client.io.QueryOptionsHandle;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.yclip.gist.framework.exceptions.NoWordException;
import com.yclip.gist.framework.util.Util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
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
public class IwRepoDAOMarkLogicImplStud implements IwRepoDAO {

    DatabaseClient client;

    @Override
    public boolean checkUIS(String word) {
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("Word")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);

        //no longer need the database connection
        release();

        System.out.println(resultsHandle.get());
        return resultsHandle.get().contains(word);
    }

    @Override
    public boolean checkGIS(String word) {
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("Word")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);

        //no longer need the database connection
        release();

System.out.println(resultsHandle.get());
        return resultsHandle.get().contains(word);
    }

    @Override
    public boolean checkLIS(String word) {
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("Word")), word);

        // create a handle for the search results to be received as raw XML
        StringHandle resultsHandle = new StringHandle();

        // run the search
        queryMgr.search(query, resultsHandle);

        //no longer need the database connection
        release();


        return resultsHandle.get().contains(word);
    }

    @Override
    public ImageWord getUIS(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageWord getGIS(String word) {
        ImageWord iw = null;
        
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
        
        MatchDocumentSummary[] docSummaries = resultsHandle.getMatchResults();
        
        //Just use the first Uri for now, this probably wants it's own method to
        //decide on choice of image
        String uri = docSummaries[0].getUri();
        
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(ImageWord.class);
			// create a handle to receive the document content
			JAXBHandle readHandle = new JAXBHandle(context);

			// read the JAXB object from the document content
			docMgr.read(uri, readHandle);

			// access the document content
			iw = (ImageWord) readHandle.get();

		} catch (JAXBException e) {
			Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, e);
		}
                
                      
        //no longer need the database connection
        release();
        return iw;
    }
    
   /* public ImageWord getImageWord(String word) {
        ImageWord iw = null;
        
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
        
        MatchDocumentSummary[] docSummaries = resultsHandle.getMatchResults();
        
        //Just use the first Uri for now, this probably wants it's own method to
        //decide on choice of image
        String uri = docSummaries[0].getUri();
        
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(ImageWord.class);
			// create a handle to receive the document content
			JAXBHandle readHandle = new JAXBHandle(context);

			// read the JAXB object from the document content
			docMgr.read(uri, readHandle);

			// access the document content
			iw = (ImageWord) readHandle.get();

		} catch (JAXBException e) {
			Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, e);
		}
                
                      
        //no longer need the database connection
        release();
        return iw;
    }*/

    @Override
    public ImageWord getLIS(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injest(String doc, String xml) {
        connect();
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

        release();
        return true;
    }

    /*
     * Injest xml into database
     * 
     * @param the xml to parse into the database
     * 
     * @return true if injest succeeds
     */
    public boolean injestJson(String doc, String json) {
        connect();


        // acquire the content
        InputStream stream;
        try {
            stream = new ByteArrayInputStream(json.getBytes("UTF-8"));
        

        // create a manager for JSON documents
        JSONDocumentManager docMgr = client.newJSONDocumentManager();

        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(stream);

        // write the document content
        docMgr.write(doc, handle);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Wrote " + doc + " content");

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
    public boolean update(String doc, String xml) {
        connect();
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

        release();
        return true;
    }

    /*
     * List all database
     */
    public String listAll() {
        connect();
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        StringQueryDefinition query = queryMgr.newStringDefinition();

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
    public DatabaseClient connect() {
        Authentication auth = Authentication.valueOf("DIGEST");
        client = DatabaseClientFactory.newClient("161.76.253.119", 8017, "rest-admin", "yclip", auth);
        return client;
    }

    /*
     * Release the database
     */
    public boolean release() {
        client.release();
        return true;
    }

    @Override
    public ImageWord getImageWord(String word) throws NoWordException {
        ImageWord iW;

        /*if (checkUIS(word)) {
            iW = getUIS(word);
        } else if (checkLIS(word)) {
            iW = getLIS(word);
        } else */
            if (checkGIS(word)) {
            iW = getGIS(word);
        } else {

            throw new NoWordException();

        }

        return iW;
    }
    
    private ImageWord getImageWordFromDatabasUri(String uri){
        connect();
        // create a manager for XML documents
                XMLDocumentManager docMgr = client.newXMLDocumentManager();        
                
                JAXBContext context;
                try {
                        context = JAXBContext.newInstance(ImageWord.class);
                        // create a handle to receive the document content
                        JAXBHandle readHandle = new JAXBHandle(context);

                        // read the JAXB object from the document content
                        docMgr.read(uri, readHandle);
                        release();
                        // access the document content
                        return (ImageWord) readHandle.get();

                } catch (JAXBException e) {
                        Logger.getLogger(IwRepoDAOMarkLogicImplStud.class.getName()).log(Level.SEVERE, null, e);
                        return null;
                }
    }
    
    
}
