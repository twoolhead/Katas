package kata.berlin.clock.formatter;

import kata.berlin.clock.core.DefaultChronolgicalSignals;
import kata.berlin.clock.core.ChronologicalSignals;
import kata.berlin.clock.core.ChronologicalUtils;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by Thomas on 7/6/2015.
 */
public class BerlinUhrFormatterImpl implements IChronologicalFormatter {
    private static final IComposite<String> VOID = () -> "";
    private static final int TWO = 2;

    @Override
    public IComposite formatTotalTime(String hours, String minutes, String seconds) {
        final CompositeImpl total = new CompositeImpl();

        IComposite hour = formatHour(hours);
        IComposite minute = formatMinute(minutes);
        IComposite second = formatSecond(seconds);

        total.addChild(hour);
        total.addChild(minute);
        total.addChild(second);

        return total;
    }

    @Override
    public IComposite formatHour(final String hour) {
        if (ChronologicalUtils.timeIsNullOrEmpty(minute)) {
            return VOID;
        }
    }

    @Override
    public IComposite formatMinute(final String minute) {
        if (ChronologicalUtils.timeIsNullOrEmpty(minute)) {
            return VOID;
        }

    }

    @Override
    public IComposite formatSecond(final String second) {
        if (ChronologicalUtils.timeIsNullOrEmpty(minute)) {
            return VOID;
        }
    }

}
