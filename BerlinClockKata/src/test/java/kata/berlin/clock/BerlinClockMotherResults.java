package kata.berlin.clock;

import kata.berlin.clock.core.Signals;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas on 7/7/2015.
 */
public class BerlinClockMotherResults {
    /*
        Five minute representation of time on a BerlinClock dial.
     */
    public static final List<Signals> FIVE_MINUTES =
            Arrays.asList(Signals.YELLOW, Signals.OFF, Signals.OFF, Signals.OFF,
                    Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF);

    /*
        Twenty minute representation of time on a BerlinClock dial.
    */
    public static final List<Signals> TWENTY_MINUTES =
            Arrays.asList(Signals.YELLOW, Signals.OFF, Signals.OFF, Signals.OFF,
                    Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF, Signals.OFF);
}

