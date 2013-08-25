/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yclip.gist.framework.repo;

/**
 * The DAO Factory is a typical factory design pattern implementation for
 * creating and serving concrete DAO implementations to the Dao objects.
 *
 * @author P Maksymchuk
 */
public class DaoFactory {

    // make it Singleton
    private static DaoFactory daoFactory = null;
    public static final String DTT_REPO_DAO_CLASS = "com.yclip.gist.framework.repo.DttRepoDAOImplStud";
    public static final String IW_REPO_DAO_CLASS = "com.yclip.gist.framework.repo.IwRepoDAOImplStud";

    /**
     * Static block that creates a new DAO factory the first time a DaoFactory
     * is created.
     */
    static {
        daoFactory = new DaoFactory();
    }

    /**
     * Private constructor that will load all of the fully qualified DAO class
     * names from the .properties file.
     */
    private DaoFactory() {
    }

    /**
     * Returns a single instance of DaoFactory. Provides an access point for the
     * singleton instance of processorFactory.
     *
     * @return reference to the instance of processorFactory
     */
    public synchronized static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    /**
     * The getDAO() method will retrieve a DAO requested by the user.
     */
    public BaseDAO getDAO(String desiredDAO) throws Exception {
        Object dao = null;
        System.out.println("looking for dao: " + desiredDAO);
        //If the classInfo properties object contains the key requested
        //by the user

        try {
            //Get the fully qualified class name.
            String className = desiredDAO;

            System.out.println(" dao class to load: " + className);
            //Retrieve a Class object for the requested className.
            Class desiredClass = Class.forName(className);
            //Retrieve a new instance of the requested DAO.
            dao = desiredClass.newInstance();

        } catch (InstantiationException e) {
            System.err.print("InstantiationException in DaoFactory.getDAO(): " + desiredDAO);
            throw new Exception("InstantiationException in DaoFactory.getDAO(): " + desiredDAO, e);
        } catch (IllegalAccessException e) {

            System.err.print("IllegalAccessException in DaoFactory.getDAO(): " + desiredDAO);
            throw new Exception("IllegalAccessException in DaoFactory.getDAO(): " + desiredDAO, e);
        } catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException in DaoFactory.getDAO(): " + desiredDAO);
            throw new Exception("ClassNotFoundException in DaoFactory.getDAO(): " + desiredDAO, e);
        }
        return (BaseDAO) dao;

    }
}
