package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/6/2015.
 */
public interface IChronologicalFormatter {
    public abstract ChronologicalFormat formatHour(String hour);
    public abstract ChronologicalFormat formatMinute(String minute);
    public abstract ChronologicalFormat formatSecond(String second);
}
