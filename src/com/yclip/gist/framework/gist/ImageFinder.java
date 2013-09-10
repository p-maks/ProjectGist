/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.yclip.gist.framework.exceptions.NoWordException;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.IwRepoDAOImplStud;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author m
 */
public class ImageFinder {

    /*
     * @param SentenceTemplate which has already been tagged for DTT
     * 
     * @return ImageSentence which has been constructed
     * 
     */
    public ImageSentence constructImageSentence(SentenceTemplate sT) throws Exception {
        ImageSentence iS = new ImageSentence();

//        Pattern regex = Pattern.compile("<ss>(.*)</ss>|<dtt>(.*)</dtt>");
//        Matcher regexMatcher = regex.matcher(sT.getTaggedSentence());
//        ArrayList<String> words = new ArrayList<>();
//        while (regexMatcher.find()) {
//            System.out.println(regexMatcher.group());
//            if (regexMatcher.group(1) != null) {
//                System.out.println(regexMatcher.group(1));
//                try {
//                    iS.addImageWord(findImage(regexMatcher.group(1)));
//                } catch (NoWordException e) {
//                }
//            } else if (regexMatcher.group(2) != null) {
//                // dtt tagged
//                //do something with regexMatcher.group(2)
//            } else {
//                // should never get here
//                // do something with no group match regexMatcher.group()
//            }
//        }

        for (SentenceWord sW : sT.getSentenceWords()) {
            if (sW.isDTT()) {
                //Direct transer text, do something with it
            } else {
                //find the image and add it to the sentance
                try {
                    iS.addImageWord(findImage(sW.getWord()));
                } catch (NoWordException e) {
                }
            }
        }



        return iS;
    }

    /*
     * @param String the word which we need to find an image for
     * 
     * @return the ImageWord for the input word
     * 
     * @throws NoWordException if no imageword was found in the repository
     */
    public ImageWord findImage(String word) throws Exception {

        ImageWord iW = new ImageWord();
        // get IwRepoDAO
        IwRepoDAOImplStud iwRepoDao = (IwRepoDAOImplStud) DaoFactory.getInstance().getDAO(DaoFactory.IW_REPO_DAO_CLASS);

        iW = iwRepoDao.getImageWord(word);

        return iW;
    }
}
