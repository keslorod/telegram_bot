package click.dozer;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexd on 16.10.2017.
 */
public class MessageHandler {
    private Bot bot;

    public MessageHandler(Bot bot) {
        this.bot = bot;
    }

    public void response(Message msg) {


        String messageText = "Lorem ipsum";
        if (msg.getText().equals("/start")) {
            SendMessage message = new SendMessage();
            messageText = "I'm Behter";
            message.setChatId(msg.getChatId()).setText(messageText);
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            EditMessageText message = new EditMessageText();
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rows = new ArrayList<>();
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(new InlineKeyboardButton().setText("Ping").setCallbackData("Pong"));
            rows.add(row);
            markup.setKeyboard(rows);

            message.setReplyMarkup(markup);
            message.setChatId(msg.getChatId()).setText(messageText).setMessageId(msg.getMessageId());
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public ArrayList<SendMessage> getDispatch() {
        return null;
    }
}
