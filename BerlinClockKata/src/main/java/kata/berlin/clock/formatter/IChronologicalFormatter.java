package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/6/2015.
 */
public interface IChronologicalFormatter {
    public abstract IChronologicalFormat formatTotalTime(String hours, String minutes, String seconds);
    public abstract IChronologicalFormat formatHour(String hour);
    public abstract IChronologicalFormat formatMinute(String minute);
    public abstract IChronologicalFormat formatSecond(String second);
}
