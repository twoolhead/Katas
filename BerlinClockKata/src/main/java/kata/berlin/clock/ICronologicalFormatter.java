package kata.berlin.clock;

import java.util.List;

/**
 * Created by Thomas on 7/6/2015.
 */
public interface ICronologicalFormatter {
    public abstract List<Signals> formatHour(String hour);
    public abstract List<Signals> formatMinute(String minute);
    public abstract List<Signals> formatSecond(String second);
}
