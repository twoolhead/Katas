package kata.berlin.clock;

import kata.berlin.clock.formatter.BerlinUhrFormatterImpl;
import kata.berlin.clock.formatter.ChronologicalFormat;
import kata.berlin.clock.formatter.IChronologicalFormatter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Created by Thomas on 7/8/2015.
 */
@Test
public class BerlinUhrFormatterImplMinutesTest {
    private IChronologicalFormatter chronologicalFormatter;

    @BeforeMethod
    public void beforeMethod() {
        chronologicalFormatter = new BerlinUhrFormatterImpl();
    }

    public void shouldIndicateCorrectSignalsForTwentyMinuteInterval() {
        final String minute = new String("20");

        final ChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted, BerlinClockMotherObjects.TWENTY_MINUTES);
    }

    public void shouldIndicateCorrectSignalsForTwentyFiveInterval() {
        final String minute = new String("25");

        final ChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted, BerlinClockMotherObjects.TWENTY_FIVE_MINUTES);
    }

    public void shouldIndicateCorrectSignalsForTwentyFourInterval() {
        final String minute = new String("24");

        final ChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted, BerlinClockMotherObjects.FOUR_MINUTES);
    }

    public void shouldIndicateCorrectSignalsForFiveMinuteInterval() {
        final String minute = new String("5");

        final ChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted, BerlinClockMotherObjects.FIVE_MINUTES);
    }
}
