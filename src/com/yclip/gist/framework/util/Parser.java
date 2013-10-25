/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.util;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.yclip.gist.framework.constants.constants;
import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.Ontology;
import com.yclip.gist.framework.obj.WordSet;
import com.yclip.gist.framework.repo.BaseDAO;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.DttRepoDAOImplStud;
import com.yclip.gist.framework.repo.OntologyDAOMarkLogicImplStud;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chaka
 */
public class Parser {

    public static final String WORD_SET_BASE_URI = "c:\\import\\wordset\\";
    public static final String ONTOLOGY_BASE_URI = "c:\\import\\ontology\\";

    public boolean parseXML(String word, String format, String type, String dataSource, String imageSource) throws Exception {
        String wordSetUri = WORD_SET_BASE_URI + word.toLowerCase() + ".xml";
        String ontologyUri = ONTOLOGY_BASE_URI + word.toLowerCase() + ".xml";
        String wordXML = word.toLowerCase() + ".xml";
        
        String iwURL = "/uis/" + wordXML;
        BaseDAO wordSetDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.WS_REPO_DAO_CLASS);
        if (!wordSetDao.contains(word)) {
            System.out.println("Injesting: " + wordSetUri);
            
            //wordSetDao.injestFile(wordSetUri, wordXML);
            BufferedReader br = null;
            String line = "";
            String tempxml = "";
            try {

                br = new BufferedReader(new FileReader(wordSetUri));
                while ((line = br.readLine()) != null) {
                    tempxml = tempxml + line + "\n";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(tempxml);
            
            wordSetDao.injest(tempxml.toLowerCase(), wordXML);
            WordSet ws = (WordSet) wordSetDao.getObjectFromURI(wordXML);
            ws.getWordSet().add(ws.getImageWord());
            ws.setImageWord(wordXML);
            wordSetDao.injest(new Util().generateXML(ws), wordXML);
            
            tempxml="";
            BaseDAO ontoDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.ONTO_REPO_DAO_CLASS);
            System.out.println("Injesting: " + ontologyUri);
            
            try {

                br = new BufferedReader(new FileReader(ontologyUri));
                while ((line = br.readLine()) != null) {
                    tempxml = tempxml + line + "\n";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(tempxml);
            ontoDao.injest(tempxml.toLowerCase(), wordXML);
            Ontology on = (Ontology) ontoDao.getObjectFromURI(wordXML);
            on.getOntology().add(on.getImageWord());
            on.setImageWord(wordXML);
            ontoDao.injest(new Util().generateXML(on), wordXML);
            
            BaseDAO iwDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.IW_REPO_DAO_CLASS);
            //url, imagetextsource, filetype, data source, image source, repotype
            ImageWord iw = new ImageWord(iwURL, new ImageTextSource(wordXML, wordXML), format, dataSource, imageSource, type);
            iwDao.injest(new Util().generateXML(iw), iw.getUrl());
        } else {
            System.out.println(word + "");
            return false;
        }

        return true;
    }

    public void readCSV(String csv) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "*";

        try {

            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {

                String[] imageWordDetails = line.split(cvsSplitBy);
                for (String string : imageWordDetails) {
                    System.out.println(string);
                }
                //word, format, repotype, dataSource, imageSource
                parseXML(imageWordDetails[1], imageWordDetails[2], imageWordDetails[3], imageWordDetails[4], imageWordDetails[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    
    public void readSvgCSV(String csv) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ":::";
        int i=0;

        try {

            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                i++;
                String[] imageWordDetails = line.split(cvsSplitBy);
                System.out.println(imageWordDetails.length);
                for (String string : imageWordDetails) {
                    System.out.println(string);
                }
                if(imageWordDetails.length==2){
                    System.out.println("Import row: " + i);
                   //word, format, repotype, dataSource, imageSource
                parseXML(imageWordDetails[0], "svg", constants.UIS, imageWordDetails[1], null); 
                }else{
                    System.out.println("No import for row: " + i + " word: " + imageWordDetails[0]);
                }
                System.out.println("move to next");
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
