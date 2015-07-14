package kata.berlin.clock.formatter;

import kata.berlin.clock.core.DefaultChronolgicalSignals;
import kata.berlin.clock.core.ChronologicalSignals;
import kata.berlin.clock.core.ChronologicalUtils;

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

        final StringBuilder fiveMinuteBuilder = new StringBuilder();
        setDefaultSignals(fiveMinuteBuilder, ChronologicalSignals.OFF, DefaultChronolgicalSignals.FIVE_MINUTE.getSize());

        final int minInt = Integer.parseInt(minute);

        int factors = (minInt / DefaultChronolgicalSignals.FIVE_MINUTE.getValue());
        overrideSignals(fiveMinuteBuilder, ChronologicalSignals.YELLOW, factors);

        discoverAndSetQuarterSignals(fiveMinuteBuilder);

        int remainder = (minInt % DefaultChronolgicalSignals.FIVE_MINUTE.getValue());
        if(remainder != 0) {
            StringBuilder oneMinuteSignals = new StringBuilder();
            setDefaultSignals(oneMinuteSignals, ChronologicalSignals.OFF, DefaultChronolgicalSignals.ONE_MINUTE.getSize());
            factors = (remainder / DefaultChronolgicalSignals.ONE_MINUTE.getValue());
            overrideSignals(oneMinuteSignals, ChronologicalSignals.YELLOW, factors);

            fiveMinuteBuilder.append(oneMinuteSignals);
        }

        return new ChronologicalFormatComponent(fiveMinuteBuilder.toString());
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

    private void discoverAndSetQuarterSignals(StringBuilder signals) {
        if('Y' == signals.charAt(2)) signals.replace(2, 3, ChronologicalSignals.RED.getSignal());
        if('Y' == signals.charAt(5)) signals.replace(5, 6, ChronologicalSignals.RED.getSignal());
        if('Y' == signals.charAt(8)) signals.replace(8, 9, ChronologicalSignals.RED.getSignal());
    }

    private void overrideSignals(StringBuilder signals, ChronologicalSignals signal, int repetition) {
        for(int sig = 0; sig < repetition; sig++) {
            signals.replace(sig, sig + 1, signal.getSignal());
        }
    }

    private void setDefaultSignals(StringBuilder signals, ChronologicalSignals signal, int repetition) {
        for(int sig = 0; sig < repetition; sig++) {
            signals.append(signal.getSignal());
        }
    }

}
