package click.dozer;

import java.util.Date;

/**
 * Created by alexd on 16.10.2017.
 */
public class User {
    private final int user_ID;
    private String first_name;
    private String last_name;
    private String phone;
    private long register;

    public User(int ID, String first_name) {
        this.user_ID = ID;
        this.first_name = first_name;
        Date d = new Date();
        this.register = d.getTime();
    }

    public User(int ID, String first_name, long date) {
        this.user_ID = ID;
        this.first_name = first_name;
        this.register = date;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getRegister() {
        return register;
    }
}
