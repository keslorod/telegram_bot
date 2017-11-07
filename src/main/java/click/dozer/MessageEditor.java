package click.dozer;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.*;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexd on 16.10.2017.
 */
public class MessageEditor {
    private Bot bot;
    private SessionHandler sessionHandler = new SessionHandler();

    public MessageEditor(Bot bot) {
        this.bot = bot;
    }

    public void response(Message msg) {

        sessionHandler.getSessionID(msg.getContact().getUserID());

        String messageText = "";
        if (msg.getText().equals("/start")) {
            SendMessage message = new SendMessage();
            messageText = "I'm Behter";
            message.setChatId(msg.getChatId()).setText(messageText);
            KeyboardRow kr = new KeyboardRow();
            kr.add(new KeyboardButton("Yes"));
            kr.add(new KeyboardButton("No"));
            List<KeyboardRow> krs = new ArrayList<>();
            krs.add(kr);
            ReplyKeyboard rp = new ReplyKeyboardMarkup().setKeyboard(krs);
            message.setReplyMarkup(rp);

            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            if (msg.getText().equals("yes")) {
                System.out.println("Yo!");
            } else if (msg.getText().equals("no")) {
                System.out.println("Nope");
            }

        }
    }

    public ArrayList<SendMessage> getDispatch() {
        return null;
    }
}
