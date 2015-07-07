package kata.berlin.clock.chronologic;

import kata.berlin.clock.core.ITime;
import kata.berlin.clock.core.Signals;
import kata.berlin.clock.core.TimeImpl;
import kata.berlin.clock.formatter.IChronologicalFormatter;

import java.util.List;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinWallClockImpl implements IChronologicalInstrument {

    private static final String TIME_SUBSTEP = ":";

    private IChronologicalFormatter cronologicalFormatter;
    private String time;

    public BerlinWallClockImpl(String time, IChronologicalFormatter cronologicalFormatter) {
        this.time = time;
        this.cronologicalFormatter = cronologicalFormatter;
    }

    @Override
    public ITime displayCompleteTime() {
        final String[] decomposed = time.split(TIME_SUBSTEP);

        TimeUtils.timeIsCorrectStructure(decomposed);

        final StringBuilder timeBuilder = new StringBuilder();

        final List<Signals> hourSignals = cronologicalFormatter.formatHour(decomposed[0]);
        bindAllFormatterSignals(timeBuilder, hourSignals);

        final List<Signals> minuteSignals = cronologicalFormatter.formatMinute(decomposed[1]);
        bindAllFormatterSignals(timeBuilder, minuteSignals);

        final List<Signals> secondSignals = cronologicalFormatter.formatSecond(decomposed[2]);
        bindAllFormatterSignals(timeBuilder, secondSignals);

        return new TimeImpl(timeBuilder.toString());
    }

    private void bindAllFormatterSignals(final StringBuilder timeBuilder, List<Signals> signals) {
        for(Signals signal : signals) {
            timeBuilder.append(signal);
        }
        timeBuilder.append(TIME_SUBSTEP);
    }

    public IChronologicalFormatter getCronologicalFormatter() {
        return cronologicalFormatter;
    }

    public void setCronologicalFormatter(IChronologicalFormatter cronologicalFormatter) {
        this.cronologicalFormatter = cronologicalFormatter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
