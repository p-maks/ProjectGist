/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.repo.DaoFactory;
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
        DttRepoDAOImplStud dttRepoDao = (DttRepoDAOImplStud) DaoFactory.getInstance().getDAO(DaoFactory.DTT_REPO_DAO_CLASS);

        List<String> sentenceWords = new Util().splitSentence(sT.getInput());

        for (String word : sentenceWords) {
            //Make sure no space is at the start or end of the sentence
            if (isFirst) {
                isFirst = false;
            } else {
                tempSentence = tempSentence + " ";
            }
            if (dttRepoDao.checkDtt(word)) {
                dttRepoDao.checkDtt(word);
                tempSentence = tempSentence + "<dtt>" + word + "</dtt>";

            } else {
                tempSentence = tempSentence + "<ss>" + word + "</ss>";
            }

        }
        sT.setTaggedSentence(tempSentence);

        return sT;
    }
}
