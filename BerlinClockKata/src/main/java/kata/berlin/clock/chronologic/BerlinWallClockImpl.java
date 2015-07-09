package kata.berlin.clock.chronologic;

import kata.berlin.clock.core.ITime;
import kata.berlin.clock.core.TimeImpl;
import kata.berlin.clock.core.ChronologicalUtils;
import kata.berlin.clock.formatter.ChronologicalFormat;
import kata.berlin.clock.formatter.IChronologicalFormatter;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinWallClockImpl implements IChronologicalInstrument {

    private static final String TIME_SUBSTEP = ":";

    public static final int HOURS = 0;
    public static final int MINUTES = 1;
    public static final int SECONDS = 2;

    private IChronologicalFormatter chronologicalFormatter;
    private String time;

    public BerlinWallClockImpl(String time, IChronologicalFormatter cronologicalFormatter) {
        this.chronologicalFormatter = cronologicalFormatter;
        this.time = time;
    }

    @Override
    public ITime displayCompleteTime() {
        final String[] decomposed = time.split(TIME_SUBSTEP);

        ChronologicalUtils.timeIsCorrectStructure(decomposed);

        final ChronologicalFormat hourSignals = chronologicalFormatter.formatHour(decomposed[HOURS]);
        final ChronologicalFormat minuteSignals = chronologicalFormatter.formatMinute(decomposed[MINUTES]);
        final ChronologicalFormat secondSignals = chronologicalFormatter.formatSecond(decomposed[SECONDS]);

        final StringBuilder totalSignals = new StringBuilder().append(hourSignals).append(minuteSignals).append(secondSignals);

        return new TimeImpl(totalSignals.toString());
    }

    public void setChronologicalFormatter(IChronologicalFormatter chronologicalFormatter) {
        this.chronologicalFormatter = chronologicalFormatter;
    }

    public IChronologicalFormatter getChronologicalFormatter() {
        return chronologicalFormatter;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
