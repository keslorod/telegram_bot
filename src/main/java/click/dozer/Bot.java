package click.dozer;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;

/**
 * Created by alexd on 16.10.2017.
 */
public class Bot extends TelegramLongPollingBot {
    private final String botUsename = "BehterevaMskBot";
    private final String botToken = "455563688:AAEolV7o_xq7Dg6kYPvXrpGVitRTKbxLuZA";
    private MessageHandler messageHandler = new MessageHandler();
    private ArrayList<SendMessage> dispatch = new ArrayList<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            sendMsg(messageHandler.getResponse(update.getMessage()));
        }
    }

    @Override
    public String getBotUsername() {
        return botUsename;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public synchronized void sendMsg(SendMessage msg){
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void dispatchTimer(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(360000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }dispatch = messageHandler.getDispatch();
                for (SendMessage sm: dispatch) {
                    sendMsg(sm);
                }
                dispatch.clear();

            }
        });
        t1.setDaemon(true);
        t1.start();
    }
}
