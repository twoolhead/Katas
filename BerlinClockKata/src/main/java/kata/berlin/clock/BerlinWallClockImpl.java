package kata.berlin.clock;

import sun.misc.Signal;

import java.util.List;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinWallClockImpl implements ICronologicalInstrument {

    private ICronologicalFormatter cronologicalFormatter;
    private String time;

    public BerlinWallClockImpl(String time, ICronologicalFormatter cronologicalFormatter) {
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

    public ICronologicalFormatter getCronologicalFormatter() {
        return cronologicalFormatter;
    }

    public void setCronologicalFormatter(ICronologicalFormatter cronologicalFormatter) {
        this.cronologicalFormatter = cronologicalFormatter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
