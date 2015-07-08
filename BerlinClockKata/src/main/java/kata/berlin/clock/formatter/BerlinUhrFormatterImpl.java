package kata.berlin.clock.formatter;

import kata.berlin.clock.core.DefaultSignals;
import kata.berlin.clock.core.Signals;
import kata.berlin.clock.core.TimeUtils;

import java.util.*;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {

    private static final List<List<Signals>> EMPTY_SIGNALS = Collections.emptyList();
    private static final int TWO = 2;

    @Override
    public List<List<Signals>> formatHour(final String hour) {
        return null;
    }

    @Override
    public List<List<Signals>> formatMinute(final String minute) {
        if (TimeUtils.timeIsNullOrEmpty(minute)) {
            return EMPTY_SIGNALS;
        }

        final List<List<Signals>> totalMinuteSignals = new ArrayList<>();
        final List<Signals> fiveMinuteSignals = DefaultSignals.FIVE_MINUTE.createDefaultSignal();

        final int minInt = Integer.parseInt(minute);

        int factors, remainder;
        factors = (minInt / DefaultSignals.FIVE_MINUTE.getValue());
        createMultipleSignals(fiveMinuteSignals, Signals.YELLOW, factors);

        final List<Signals> oneMinuteSignals = DefaultSignals.ONE_MINUTE.createDefaultSignal();
        if((remainder = (minInt % DefaultSignals.FIVE_MINUTE.getValue())) != 0) {
            factors = (remainder / DefaultSignals.ONE_MINUTE.getValue());
            createMultipleSignals(oneMinuteSignals, Signals.YELLOW, factors);
        }

        totalMinuteSignals.add(fiveMinuteSignals);
        if (!oneMinuteSignals.isEmpty()) {
            totalMinuteSignals.add(oneMinuteSignals);
        }

        return totalMinuteSignals;
    }

    private void createMultipleSignals(List<Signals> signals, Signals signal, int repitition) {
        for(int sig = 0; sig < repitition; sig++) {
            signals.set(sig, signal);
        }
    }

    @Override
    public List<List<Signals>> formatSecond(final String second) {
        if (TimeUtils.timeIsNullOrEmpty(second)) {
            return EMPTY_SIGNALS;
        }

        return TimeUtils.isDivisibleBy(TWO, second) ? Arrays.asList(Signals.RED) : Arrays.asList(Signals.OFF);
    }

}
