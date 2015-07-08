package kata.berlin.clock.formatter;

import kata.berlin.clock.core.Signals;

import java.util.List;

/**
 * Created by Thomas on 7/6/2015.
 */
public interface IChronologicalFormatter {
    public abstract List<List<Signals>> formatHour(String hour);
    public abstract List<List<Signals>> formatMinute(String minute);
    public abstract List<List<Signals>> formatSecond(String second);
}
