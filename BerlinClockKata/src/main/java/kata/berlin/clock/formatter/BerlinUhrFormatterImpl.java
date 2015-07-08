package kata.berlin.clock.formatter;

import kata.berlin.clock.core.Signals;
import kata.berlin.clock.core.TimeUtils;

import java.util.*;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {

    private static final List<Signals> EMPTY_SIGNALS = Collections.emptyList();
    public static final int MINUTE_CAPACITY = 11;
    private static final int TWO = 2;
    public static final int MINUTE_INTERVAL_VALUE = 5;

    @Override
    public List<Signals> formatHour(final String hour) {
        return null;
    }

    @Override
    public List<Signals> formatMinute(final String minute) {
        if (TimeUtils.timeIsNullOrEmpty(minute)) {
            return EMPTY_SIGNALS;
        }

        final List<Signals> minuteSignals = Arrays.asList(new Signals[MINUTE_CAPACITY]);
        Collections.fill(minuteSignals, Signals.OFF);

        final int minInt = Integer.parseInt(minute);

        int factors, remainder;
        if((remainder = (minInt % MINUTE_INTERVAL_VALUE)) == 0) {
            factors = (Integer.parseInt(minute) / MINUTE_INTERVAL_VALUE);
            createMultipleSignals(minuteSignals, Signals.YELLOW, factors);
        };

        return minuteSignals;
    }

    private void createMultipleSignals(List<Signals> signals, Signals signal, int repitition) {
        for(int sig = 0; sig < repitition; sig++) {
            signals.set(sig, signal);
        }
    }

    @Override
    public List<Signals> formatSecond(final String second) {
        if (TimeUtils.timeIsNullOrEmpty(second)) {
            return EMPTY_SIGNALS;
        }

        return TimeUtils.isDivisibleBy(TWO, second) ? Arrays.asList(Signals.RED) : Arrays.asList(Signals.OFF);
    }

}
