package click.dozer;

/**
 * Created by alexd on 16.10.2017.
 */
public class Event {
    private int events_ID;
    private long date;
    private String description;
    private String location;
    private boolean enabled;
    private boolean has_change;

    public Event(int events_ID, long date, String description, String location, boolean enabled, boolean has_change) {
        this.events_ID = events_ID;
        this.date = date;
        this.description = description;
        this.location = location;
        this.enabled = enabled;
        this.has_change = has_change;
    }
}
