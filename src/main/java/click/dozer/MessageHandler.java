package click.dozer;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.util.ArrayList;

/**
 * Created by alexd on 16.10.2017.
 */
public class MessageHandler {

    public SendMessage getResponse(Message msg) {
        String messageText = "Lorem ipsum";
        if (msg.getText().equals("/start")) {
            messageText = "I'm Behter";
        }



        SendMessage message = new SendMessage();
        message.setChatId(msg.getChatId()).setText(messageText);
        return message;
    }

    public ArrayList<SendMessage> getDispatch() {
        return null;
    }
}
