/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.yclip.gist.framework.repo.BaseDAO;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.DttRepoDAOImplStud;
import com.yclip.gist.framework.repo.OntologyDAOMarkLogicImplStud;
import java.io.InputStream;

/**
 *
 * @author Chaka
 */
public class Parser {

    public static final String WORD_SET_BASE_URI = "c:/wordset/";
    public static final String ONTOLOGY_BASE_URI = "c:/ontology/";

    public boolean parseXML(String word) throws Exception {
        String wordSetUri = WORD_SET_BASE_URI + word;
        String ontologyUri = ONTOLOGY_BASE_URI + word;
        String wordXML = word + ".xml";
        injectWordSet(wordXML, wordSetUri);
        BaseDAO wordSetDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.DTT_REPO_DAO_CLASS);
        wordSetDao.injest(wordXML, wordSetUri);
        new OntologyDAOMarkLogicImplStud().injestFile(wordXML, ontologyUri);
        injectOntology(wordXML, wordSetUri);
        
        return true;
    }

    private boolean injectWordSet(String word, String uri) {
        

        return true;
    }
    
    private boolean injectOntology(String word, String uri) {
        //Connect to Ontology server
        DatabaseClient client = DatabaseClientFactory.newClient("161.76.253.119", 8015, "rest-admin", "yclip", DatabaseClientFactory.Authentication.valueOf("DIGEST"));
        // acquire the content
        InputStream docStream = Parser.class.getClassLoader().getResourceAsStream(uri);
        
        // create a handle on the content
        InputStreamHandle handle = new InputStreamHandle(docStream);
        
        // create a manager for XML documents
        XMLDocumentManager docMgr = client.newXMLDocumentManager();
        
        // write the document content
        docMgr.write(word, handle);

        System.out.println("Wrote " + word + " ontology");

        // release the client
        client.release();

        return true;
    }
}

