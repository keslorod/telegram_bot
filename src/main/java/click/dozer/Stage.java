package click.dozer;

import click.dozer.innerClasses.Executor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alexd on 25.10.2017.
 */
public class Stage {
    private int ID;
    private final Executor executor;
    private String name;
    private ArrayList<String> bNames;


    public Stage(int ID, Executor executor, String name, String... buttonsNames) {
        this.ID = ID;
        this.executor = executor;
        this.name = name;
        Collections.addAll(bNames, buttonsNames);
    }


    public int getID() {
        return ID;
    }
}
