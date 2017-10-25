package click.dozer;

/**
 * Created by alexd on 25.10.2017.
 */
public class Session {

    private final int ID;
    private int stage;

    public Session(int ID) {
        this.ID = ID;
    }

/*      TODO: сделать проверку уровня пользователя при повышении stage. 0-10 - незарегистрированный, 10-100 зарегистрированный, 100-200 администратор, 1000+ root например, проверять только в базе (?)*/

    public boolean setStage(int stage, User user) {

        this.stage = stage;
        return true;
    }

    public int getID() {
        return ID;
    }

    public int getStage() {
        return stage;
    }
}
