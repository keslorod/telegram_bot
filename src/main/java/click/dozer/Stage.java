package click.dozer;

import click.dozer.innerClasses.Executor;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;

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

    //вернуть Massage
    public BotApiMethod getMessage() {
        BotApiMethod message = new SendMessage();
        return message;
    }

    //вернуть EditMessage (inline)
    public BotApiMethod getMessage(String text) {
        BotApiMethod message = null;
        if (text.equals("inline")) {
//            message = new Edi();
        } else {
            message = getMessage();
            ((SendMessage) message).setText(text);
        }
        return message;
    }

    public int getID() {
        return ID;
    }
}
