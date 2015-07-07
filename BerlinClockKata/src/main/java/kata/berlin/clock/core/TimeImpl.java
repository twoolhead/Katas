package kata.berlin.clock.core;

/**
 * Created by Thomas on 7/6/2015.
 */
public class TimeImpl extends ITime {
    private final String time;

    public TimeImpl(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
