package kata.berlin.clock.formatter;

import kata.berlin.clock.core.DefaultChronolgicalSignals;
import kata.berlin.clock.core.ChronologicalSignals;
import kata.berlin.clock.core.ChronologicalUtils;

import java.util.*;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {

    private static final int TWO = 2;

    @Override
    public IChronologicalFormat formatTotalTime(String hours, String minutes, String seconds) {
        final ChronologicalFormatComposite total = new ChronologicalFormatComposite();

        IChronologicalFormat hour = formatHour(hours);
        IChronologicalFormat minute = formatMinute(minutes);
        IChronologicalFormat second = formatSecond(seconds);

        total.addFormatted(hour);
        total.addFormatted(minute);
        total.addFormatted(second);

        return total;
    }

    @Override
    public IChronologicalFormat formatHour(final String hour) {
        return IChronologicalFormat.VOID_FORMAT;
    }

    @Override
    public IChronologicalFormat formatMinute(final String minute) {
        if (ChronologicalUtils.timeIsNullOrEmpty(minute)) {
            return IChronologicalFormat.VOID_FORMAT;
        }

        final List<List<ChronologicalSignals>> totalMinuteSignals = new ArrayList<>();
        final List<ChronologicalSignals> fiveMinuteSignals = DefaultChronolgicalSignals.FIVE_MINUTE.createDefaultSignal();

        final int minInt = Integer.parseInt(minute);

        int factors, remainder;
        factors = (minInt / DefaultChronolgicalSignals.FIVE_MINUTE.getValue());
        createMultipleSignals(fiveMinuteSignals, ChronologicalSignals.YELLOW, factors);

        final List<ChronologicalSignals> oneMinuteSignals = DefaultChronolgicalSignals.ONE_MINUTE.createDefaultSignal();
        if((remainder = (minInt % DefaultChronolgicalSignals.FIVE_MINUTE.getValue())) != 0) {
            factors = (remainder / DefaultChronolgicalSignals.ONE_MINUTE.getValue());
            createMultipleSignals(oneMinuteSignals, ChronologicalSignals.YELLOW, factors);
        }

        totalMinuteSignals.add(fiveMinuteSignals);
        if (!oneMinuteSignals.isEmpty()) {
            totalMinuteSignals.add(oneMinuteSignals);
        }

        return IChronologicalFormat.VOID_FORMAT;
    }

    @Override
    public IChronologicalFormat formatSecond(final String second) {
        if (ChronologicalUtils.timeIsNullOrEmpty(second)) {
            return IChronologicalFormat.VOID_FORMAT;
        }

        return ChronologicalUtils.isDivisibleBy(TWO, second) ?
                new ChronologicalFormatComponent(ChronologicalSignals.RED.getSignal()) :
                new ChronologicalFormatComponent(ChronologicalSignals.OFF.getSignal());
    }

    private void createMultipleSignals(List<ChronologicalSignals> signals, ChronologicalSignals signal, int repetition) {
        for(int sig = 0; sig < repetition; sig++) {
            signals.set(sig, signal);
        }
    }

}
