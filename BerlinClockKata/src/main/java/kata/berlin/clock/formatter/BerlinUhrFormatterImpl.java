package kata.berlin.clock.formatter;

import kata.berlin.clock.core.Signals;
import kata.berlin.clock.core.TimeUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {

    private static final List<Signals> EMPTY_SIGNALS = Collections.emptyList();
    private static final int DIVISIBLE_BY_TWO = 2;

    @Override
    public List<Signals> formatHour(final String hour) {
        return null;
    }

    @Override
    public List<Signals> formatMinute(final String minute) {
        return null;
    }

    @Override
    public List<Signals> formatSecond(final String second) {
        if (TimeUtils.timeIsNullOrEmpty(second)) {
            return EMPTY_SIGNALS;
        }

        return ((Integer.parseInt(second) % DIVISIBLE_BY_TWO) == 0)
                ? Arrays.asList(Signals.RED) : Arrays.asList(Signals.OFF);
    }
}
