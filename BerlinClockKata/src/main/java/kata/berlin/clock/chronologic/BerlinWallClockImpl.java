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

    private IChronologicalFormatter cronologicalFormatter;
    private String time;

    public BerlinWallClockImpl(String time, IChronologicalFormatter cronologicalFormatter) {
        this.time = time;
        this.cronologicalFormatter = cronologicalFormatter;
    }

    @Override
    public ITime displayCompleteTime() {
        final StringBuilder timeBuilder = new StringBuilder();

        final List<Signals> hourSignals = cronologicalFormatter.formatHour(time);
        bindAllFormatterSignals(timeBuilder, hourSignals);

        final List<Signals> minuteSignals = cronologicalFormatter.formatMinute(time);
        bindAllFormatterSignals(timeBuilder, minuteSignals);

        final List<Signals> secondSignals = cronologicalFormatter.formatSecond(time);
        bindAllFormatterSignals(timeBuilder, secondSignals);

        return new TimeImpl(timeBuilder.toString());
    }

    private void bindAllFormatterSignals(final StringBuilder timeBuilder, List<Signals> signals) {
        for(Signals signal : signals) {
            timeBuilder.append(signal);
        }
        timeBuilder.append(", ");
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
