package click.dozer;

/**
 * Created by alexd on 25.10.2017.
 */
public class SessionHandler {

    public int getSessionID(Integer userID) {
        return 0;
    }
}

/*      TODO: сделать проверку уровня пользователя при повышении stage. 0-10 - незарегистрированный, 10-100 зарегистрированный, 100-200 администратор, 1000+ root например, проверять только в базе (?)*/
