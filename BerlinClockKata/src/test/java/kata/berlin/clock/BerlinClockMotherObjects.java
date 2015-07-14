package kata.berlin.clock;

import kata.berlin.clock.core.ChronologicalSignals;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas on 7/7/2015.
 */
public class BerlinClockMotherObjects {
    /*
        Five minute representation of time on a BerlinClock dial.
     */
    public static final List<ChronologicalSignals> FIVE_MINUTES =
            Arrays.asList(ChronologicalSignals.YELLOW, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF,
                    ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF);

    public static final String FIVE = "YOOOOOOOOOO";

    /*
        Twenty minute representation of time on a BerlinClock dial.
    */
    public static final List<ChronologicalSignals> TWENTY_MINUTES =
            Arrays.asList(ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW,
                    ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF);

    public static final String TWENTY = "YYYYOOOOOOO";

    /*
        Twenty five representation of time on a BerlinClock dial.
    */
    public static final List<ChronologicalSignals> TWENTY_FIVE_MINUTES =
            Arrays.asList(ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW,
                    ChronologicalSignals.YELLOW, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF, ChronologicalSignals.OFF);

    public static final String TWENTY_FIVE = "YYYYYOOOOOO";

    /*
        Four representation of time on a BerlinClock dial.
    */
    public static final List<ChronologicalSignals> FOUR_MINUTES = Arrays.asList(ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW, ChronologicalSignals.YELLOW);

    public static final String FOUR = "RRRR";

    public static final String TWENTY_FOUR = "YYRYOOOOOOOYYYY";

    public static final String FIFTY_SIX = "YYRYYRYYRYYYOOO";
}

