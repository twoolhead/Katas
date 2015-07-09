package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/8/2015.
 */
public class ChronologicalFormat {
    public static final ChronologicalFormat VOID_FORMAT = new ChronologicalFormat("");

    private final String formatted;

    public ChronologicalFormat(String formatted) {
        this.formatted = formatted;
    }

    public String getFormatted() {
        return formatted;
    }
}
