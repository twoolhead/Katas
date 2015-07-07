package kata.berlin.clock.formatter;

import kata.berlin.clock.core.Signals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {

    private static final List<Signals> DEFAULT_EMPTY = Collections.emptyList();

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
        if ((Integer.parseInt(second) % 2) == 0) {
            return Arrays.asList(Signals.RED);
        }
        return DEFAULT_EMPTY;
    }
}
