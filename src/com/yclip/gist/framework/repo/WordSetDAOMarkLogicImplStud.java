/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.query.KeyValueQueryDefinition;
import com.marklogic.client.query.QueryManager;
import com.yclip.gist.framework.util.Parser;
import java.io.InputStream;
import javax.xml.namespace.QName;

/**
 *
 * @author Chaka
 */
public class WordSetDAOMarkLogicImplStud implements BaseDAO{

    @Override
    public boolean injest(String xml, String Doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean injestFile(String doc, String uri) {
        //Connect to word set server
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8016, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // acquire the content
        InputStream docStream = Parser.class.getClassLoader().getResourceAsStream(uri);
        
        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(docStream);
        
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        
        // write the document content
        docMgr.write(doc, handle);

        System.out.println("Wrote " + doc + " word set");

        // release the client
        client.release();
        return true;
    }
    
    public boolean contains(String word){
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8016, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // create a manager for searching
        QueryManager queryMgr = client.newQueryManager();

        // create a search definition
        KeyValueQueryDefinition query = queryMgr.newKeyValueDefinition();
        query.put(queryMgr.newElementLocator(new QName("word")), word);

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String doc, String xml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
