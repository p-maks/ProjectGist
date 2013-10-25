/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistence.framework.oif;

import com.yclip.gist.framework.constants.constants;
import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.Ontology;
import com.yclip.gist.framework.obj.WordSet;
import com.yclip.gist.framework.repo.BaseDAO;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.IwRepoDAOMarkLogicImplStud;
import com.yclip.gist.framework.util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Chaka
 */
public class OIF {

    private static final String url = "https://www.google.com/search?&tbm=isch&q=";

    private String searchForWord(String input) throws IOException {
        String textView = "";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url + input);
        HttpResponse response = client.execute(request);

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            textView = textView + "\n" + line;
        }
        return textView;

    }

    
    /*
     * Get an image for the word from google images and add it into the 
     * repositary and the file system
     */
    public ImageWord getImageForWord(String input) throws IOException, Exception {

        String result = getUrlFromResults(searchForWord(input));
        //this.imageWordRepository=imageWordRepository;
        System.out.println(result);
        String filePath = saveImage(result, input, "jpg");
        //imageWordRepository.insert(input, filePath, "<img src=\""+filePath+"\">", input.toLowerCase());
        String doc = "/oif/" + input + ".xml";



        BaseDAO wordSetDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.WS_REPO_DAO_CLASS);
        //if (!wordSetDao.contains(input)) {
            WordSet source = new WordSet();
            //create the word set for the word.  
            // TODO should probably obtain wordset from word net
            // for now just use the input word
            Set sourceSet = new HashSet();
            sourceSet.add(input);
            source.setWordSet(sourceSet);
            source.setImageWord(doc);
            wordSetDao.injest(new Util().generateXML(source), doc);
        
            Ontology onto = new Ontology();
            //create the word set for the word.  
            // TODO should probably obtain onotology from somewhere
            // for now just use the input word
            Set ontoSet = new HashSet();
            ontoSet.add(input);
            onto.setOntology(ontoSet);
            onto.setImageWord(doc);
            BaseDAO ontoDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.ONTO_REPO_DAO_CLASS);
            ontoDao.injest(new Util().generateXML(onto), doc);

            BaseDAO iwDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.IW_REPO_DAO_CLASS);
            
            //url, imagetextsource, filetype, data source, image source, repotype
            ImageWord iw = new ImageWord(doc, new ImageTextSource(doc,doc), "jpg",null, filePath, constants.OIF);
            iwDao.injest(new Util().generateXML(iw), iw.getUrl());
        //}
            
            return iw;
    }

    
    /*
     * Method to split the google images site and return the url of the first image
     * may need to be altered if google change google images.
     */
    private String getUrlFromResults(String searchHtml) {
        String url = "";
        String temp = searchHtml;

        int i = temp.indexOf("<h2 class=\"hd\">");
        temp = temp.substring(i);

        i = temp.indexOf("<img");
        temp = temp.substring(i);
        i = temp.indexOf(">");
        temp = temp.substring(0, i);
        i = temp.indexOf("src=\"");
        i = i + 5;
        temp = temp.substring(i);
        i = temp.indexOf("\"");
        url = temp.substring(0, i);

        return url;
    }

    /*
     * Code from http://www.avajava.com/tutorials/lessons/how-do-i-save-an-image-from-a-url-to-a-file.html
     * but as comments aren't counted you don't know that
     */
    private String saveImage(String imageUrl, String destinationFile, String type) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();

        // TODO alter file location so it's relative to web instance, so it can be view on the web
        File file = new File("C:/images/" + destinationFile + "." + type);
        OutputStream os = new FileOutputStream(file);
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
        return file.getPath();
    }
}
