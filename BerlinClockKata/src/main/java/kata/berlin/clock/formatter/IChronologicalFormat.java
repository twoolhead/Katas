package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/9/2015.
 */
public interface IChronologicalFormat {
    public static final IChronologicalFormat VOID_FORMAT = new ChronologicalFormatComponent("");
    public abstract String getFormatted();
}
