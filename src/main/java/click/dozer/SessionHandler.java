package click.dozer;

import org.telegram.telegrambots.api.objects.Update;

import java.util.HashMap;

/**
 * Created by alexd on 25.10.2017.
 */
public class SessionHandler {
    HashMap<Integer, Integer> session = new HashMap<>();

    public int getSessionID(Update update) {
        return 0;
    }
}

/*      TODO: сделать проверку уровня пользователя при повышении stage. 0-10 - незарегистрированный, 10-100 зарегистрированный, 100-200 администратор, 1000+ root например, проверять только в базе (?)*/
