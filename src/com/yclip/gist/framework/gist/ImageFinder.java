/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.gist;

import com.marklogic.client.query.MatchDocumentSummary;
import com.vistence.framework.oif.OIF;
import com.yclip.gist.framework.exceptions.NoWordException;
import com.yclip.gist.framework.obj.ImageSentence;
import com.yclip.gist.framework.obj.ImageWord;
import com.yclip.gist.framework.obj.Ontology;
import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.obj.WordSet;
import com.yclip.gist.framework.repo.BaseDAO;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.IwRepoDAO;
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
        MatchDocumentSummary topResult = null;
        int topScore = 0;
        int tempScore;
        System.out.println("Finding image for: " + word);
        ImageWord iw = new ImageWord();
        BaseDAO wordSetDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.WS_REPO_DAO_CLASS);
        MatchDocumentSummary[] wordSet = wordSetDao.search(word);

        //need to get the meaning of a word and search angainst that
        BaseDAO ontoDao = (BaseDAO) DaoFactory.getInstance().getDAO(DaoFactory.ONTO_REPO_DAO_CLASS);
        MatchDocumentSummary[] ontoSet = ontoDao.search(word);
        if (ontoSet == null && wordSet == null) {//Source new image if no image can be found
            System.out.println("Sourcing image for: " + word);
            iw = new OIF().getImageForWord(word);
        } else {
            try {
                IwRepoDAO iwRepoDao = (IwRepoDAO) DaoFactory.getInstance().getDAO(DaoFactory.IW_REPO_DAO_CLASS);
                /*if (wordSet != null) {//prioritise word set results
                    System.out.println(wordSet[0].getUri());
                    
                     WordSet ws = (WordSet) wordSetDao.getObjectFromURI(wordSet[0].getUri());
                     System.out.println(ws.getImageWord());
                     * iw = (ImageWord) iwRepoDao.getObjectFromWordSet(ws.getImageWord());
                     
                    for (MatchDocumentSummary match : wordSet) {
                        System.out.println("Word Set: " + match.getUri());
                        System.out.println("fitenss: " + match.getFitness());
                        System.out.println("score: " + match.getScore());
                        System.out.println("confidence: " + match.getConfidence());
                    }
                    iw = (ImageWord) iwRepoDao.getObjectFromWordSet(wordSet[0].getUri());
                }*/
                /*if (ontoSet != null) {//if wordSet = null, use ontoResult
                Ontology on = (Ontology) ontoDao.getObjectFromURI(ontoSet[0].getUri());
                     System.out.println(on.getImageWord());
                     iw = (ImageWord) iwRepoDao.getObjectFromOntology(on.getImageWord());
                     
                    iw = (ImageWord) iwRepoDao.getObjectFromOntology(ontoSet[0].getUri());
                    for (MatchDocumentSummary match : ontoSet) {
                        System.out.println("Onto Set: " + match.getUri());
                        System.out.println("fitenss: " + match.getFitness());
                        System.out.println("score: " + match.getScore());
                        System.out.println("confidence: " + match.getConfidence());
                    }
                }*/
                if (ontoSet != null && wordSet != null) {
                    for (MatchDocumentSummary wordMatch : wordSet) {
                        for (MatchDocumentSummary ontoMatch : ontoSet) {
                            if (wordMatch.getUri().equals(ontoMatch.getUri())) {
                                tempScore = wordMatch.getScore() + ontoMatch.getScore();
                                if (tempScore > topScore) {
                                    topResult = wordMatch;
                                }
                            }
                            tempScore = ontoMatch.getScore();
                            if (tempScore > topScore) {
                                topResult = ontoMatch;
                            }
                        }

                        tempScore = wordMatch.getScore();
                        if (tempScore > topScore) {
                            topResult = wordMatch;
                        }

                    }
                    iw = (ImageWord) iwRepoDao.getObjectFromWordSet(topResult.getUri());
                } else if (wordSet != null) {
                    for (MatchDocumentSummary wordMatch : wordSet) {
                        tempScore = wordMatch.getScore();
                        if (tempScore > topScore) {
                            topResult = wordMatch;
                        }
                    }
                    iw = (ImageWord) iwRepoDao.getObjectFromWordSet(topResult.getUri());
                    
                } else if (ontoSet != null) {
                    for (MatchDocumentSummary ontoMatch : ontoSet) {
                        tempScore = ontoMatch.getScore();
                        if (tempScore > topScore) {
                            topResult = ontoMatch;
                        }
                    }
                    iw = (ImageWord) iwRepoDao.getObjectFromOntology(topResult.getUri());
                }


            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught error: " + e.toString() + "Obtaining image from oif for: " + word);
                iw = new OIF().getImageForWord(word);
            }
        }

        return iw;
    }
}
