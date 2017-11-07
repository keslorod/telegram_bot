package click.dozer;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexd on 16.10.2017.
 */
public class Bot extends TelegramLongPollingBot {
    private MessageEditor messageEditor = new MessageEditor(this);
    private ArrayList<SendMessage> dispatch = new ArrayList<>();

    public Bot(){
        dispatchTimer();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
//            messageEditor.response(update.getMessage());
//            -------------------------
            if (update.getMessage().getText().equals("/start")) {
                SendMessage sm = new SendMessage()
                        .setChatId(msg.getChatId())
                        .setText("<b>Hello!</b>")
                        .enableHtml(true);
                sendMsg(sm);
            }
            if (update.getMessage().getText().equals("/KB")) {
                SendMessage sm = new SendMessage()
                        .setChatId(msg.getChatId())
                        .setText("inline?");
                KeyboardRow kr = new KeyboardRow();
                kr.add(new KeyboardButton("Yes"));
                kr.add(new KeyboardButton("No"));
                List<KeyboardRow> krs = new ArrayList<>();
                krs.add(kr);
                ReplyKeyboard rp = new ReplyKeyboardMarkup().setKeyboard(krs);
                sm.setReplyMarkup(rp);
                sendMsg(sm);
            }
            if (update.getMessage().getText().equals("Yes")) {
                SendMessage sm = new SendMessage()
                        .setChatId(msg.getChatId())
                        .setText("inline!");
                List<InlineKeyboardButton> row = new ArrayList();
                row.add(new InlineKeyboardButton().setText("ButtonText").setCallbackData("buttonPressed"));
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                keyboard.add(row);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup().setKeyboard(keyboard);
                sm.setReplyMarkup(inlineKeyboardMarkup);
                sendMsg(sm);
            }
//            -------------------------
        } else {
            if (update.hasCallbackQuery()) {
                CallbackQuery cq = update.getCallbackQuery();
                System.out.println(update.getCallbackQuery().getData());
                EditMessageText emt = new EditMessageText()
                        .setChatId(cq.getMessage().getChatId())
                        .setMessageId(cq.getMessage().getMessageId())
                        .setText("Edited text");
                List<InlineKeyboardButton> row = new ArrayList();
                row.add(new InlineKeyboardButton().setText("1").setCallbackData("2"));
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                keyboard.add(row);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup().setKeyboard(keyboard);
                emt.setReplyMarkup(inlineKeyboardMarkup);
                sendMsg(emt);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }

    public synchronized void sendMsg(BotApiMethod msg) {
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
                while (true) {
                    try {
                        Thread.sleep(360000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("поток");
                    SendMessage sm = new SendMessage()
                            .setText("Nhfkfk2")
                            .setChatId((long) 331673208);
                    sendMsg(sm);
//                dispatch = messageEditor.getDispatch();
//                for (SendMessage sm: dispatch) {
//                    sendMsg(sm);
//                }
//                dispatch.clear();
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
    }
}
