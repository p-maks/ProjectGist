/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistence.framework.oif;

import com.yclip.gist.framework.obj.ImageTextSource;
import com.yclip.gist.framework.obj.ImageWord;
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

    static final String url = "https://www.google.com/search?&tbm=isch&q=";
    

    

    public String searchForWord(String input) throws IOException {
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

    public void getImageForWord(String input) throws IOException, Exception {
        
        String result = getUrlFromResults(searchForWord(input));
        //this.imageWordRepository=imageWordRepository;
        System.out.println(result);
        String filePath = saveImage(result, input, "jpg");
        //imageWordRepository.insert(input, filePath, "<img src=\""+filePath+"\">", input.toLowerCase());
        
        
        ImageTextSource source = new ImageTextSource();
        //create the word set for the word.  
        // TODO should probably obtain wordset from word net
        // for now just use the input word
        Set sourceSet = new HashSet();
        sourceSet.add(input);
        source.setWordSet(sourceSet);
        
        ImageWord iw = new ImageWord(filePath, source, "jpeg", filePath);
        IwRepoDAOMarkLogicImplStud instance = new IwRepoDAOMarkLogicImplStud();
        
        String doc = "/oif/" + input +".xml";
        instance.injest(doc, new Util().generateXML(iw));
    }

    private String getUrlFromResults(String searchHtml) {
        String url = "";
        String temp = searchHtml;

        int i = temp.indexOf("Search Results");
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
    public String saveImage(String imageUrl, String destinationFile, String type) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        
        // TODO alter file location so it's relative to web instance, so it can be view on the web
        File file = new File("./images/"+destinationFile + "." + type);
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
