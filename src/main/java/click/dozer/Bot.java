package click.dozer;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * Created by alexd on 16.10.2017.
 */
public class Bot extends TelegramLongPollingBot {
    private final String BotUsename = "";
    private final String BotToken = "";

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onClosing() {

    }
}
