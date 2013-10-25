/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.DttRepoDAO;
import com.yclip.gist.framework.repo.DttRepoDAOImplStud;
import com.yclip.gist.framework.util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m
 */
public class DTTExtractor {

    String tempSentence = "";
    boolean isFirst = true;

    /*
     * Tags the sentence template for Direct transfer text and sentence segment
     * 
     * @param SentenceTemplate which has not been tagged
     * 
     * @return SentenceTemplate which has been tagged
     * 
     */
    public SentenceTemplate tagDTT(SentenceTemplate sT) throws Exception {

        // get DttRepoDAO
        DttRepoDAO dttRepoDao = (DttRepoDAO) DaoFactory.getInstance().getDAO(DaoFactory.DTT_REPO_DAO_CLASS);

        List<String> words = new Util().splitSentence(sT.getInput());
        List<SentenceWord> sentenceWords = new ArrayList<SentenceWord>();

        for (String word : words) {
            //Make sure no space is at the start or end of the sentence
            if (isFirst) {
                isFirst = false;
            } else {
                tempSentence = tempSentence + " ";
            }
            if (dttRepoDao.checkDtt(word)) {
                tempSentence = tempSentence + "<dtt>" + word + "</dtt>";
                System.out.println(word + " is dtt");

            } else {
                tempSentence = tempSentence + "<ss>" + word + "</ss>";
                System.out.println(word + " is not dtt");
            }
            sentenceWords.add(new SentenceWord(word, dttRepoDao.checkDtt(word)));

        }
        sT.setTaggedSentence(tempSentence);
        sT.setSentenceWords(sentenceWords);
        System.out.println("Temp Sentence: "+tempSentence);
        return sT;
    }
}
