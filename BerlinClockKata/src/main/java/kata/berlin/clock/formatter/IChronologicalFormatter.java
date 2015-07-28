package kata.berlin.clock.formatter;

/**
 * Created by Thomas on 7/6/2015.
 */
public interface IChronologicalFormatter {
    public abstract IComposite formatTotalTime(String hours, String minutes, String seconds);
    public abstract IComposite formatHour(String hour);
    public abstract IComposite formatMinute(String minute);
    public abstract IComposite formatSecond(String second);
}
