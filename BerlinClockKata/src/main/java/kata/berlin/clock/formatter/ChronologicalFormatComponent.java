package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/9/2015.
 */
public class ChronologicalFormatComponent implements IChronologicalFormat {

    private final String formatted;

    public ChronologicalFormatComponent(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public String getFormatted() {
        return formatted;
    }
}
