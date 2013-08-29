/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.de;

import com.yclip.gist.framework.obj.SentenceTemplate;
import com.yclip.gist.framework.obj.SentenceWord;
import com.yclip.gist.framework.repo.DaoFactory;
import com.yclip.gist.framework.repo.DttRepoDAOImplStud;
import java.util.ArrayList;

/**
 *
 * @author m
 */
public class DTTExtractor {

    public SentenceTemplate tagDTT(SentenceTemplate sT) throws Exception {

        // get DttRepoDAO
        DttRepoDAOImplStud dttRepoDao = (DttRepoDAOImplStud) DaoFactory.getInstance().getDAO(DaoFactory.DTT_REPO_DAO_CLASS);

        for (SentenceWord word : sT.getSentenceWords()) {
            word.setDTT(dttRepoDao.checkDtt(word.getWord()));
        }

        return sT;
    }
}
