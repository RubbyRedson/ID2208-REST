package se.kth.webservice.third.controllers;

import se.kth.webservice.third.data.DatabaseWrapper;
import se.kth.webservice.third.data.IRepository;
import se.kth.webservice.third.data.TestRepo;

/**
 * Created by victoraxelsson on 2017-02-11.
 */
public abstract class Controller {
    public static boolean test = false;
    protected static final int DEFAULT_PAGE_SIZE = 10;
    protected static final int DEFAULT_PAGE_START = 0;
    protected IRepository repo;

    public Controller(){

        //This could also be dependency injected, or set from env vars
        if (test) repo = new TestRepo();
        else repo = new DatabaseWrapper();
    }


}
