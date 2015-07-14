package kata.berlin.clock;

import kata.berlin.clock.formatter.BerlinUhrFormatterImpl;
import kata.berlin.clock.formatter.ChronologicalFormatComposite;
import kata.berlin.clock.formatter.IChronologicalFormat;
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

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted.getFormatted(), BerlinClockMotherObjects.TWENTY);
    }

    public void shouldIndicateCorrectSignalsForTwentyFiveInterval() {
        final String minute = new String("25");

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted.getFormatted(), BerlinClockMotherObjects.TWENTY_FIVE);
    }

    public void shouldIndicateCorrectSignalsForTwentyFourInterval() {
        final String minute = new String("24");

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted.getFormatted(), BerlinClockMotherObjects.TWENTY_FOUR);
    }

    public void shouldIndicateCorrectSignalsForFiveMinuteInterval() {
        final String minute = new String("5");

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted.getFormatted(), BerlinClockMotherObjects.FIVE);
    }

    public void shouldIndicateCorrectSignalsForFiftySixMinuteInterval() {
        final String minute = new String("56");

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(minute);

        assertEquals(actualFormatted.getFormatted(), BerlinClockMotherObjects.FIFTY_SIX);
    }

    public void shouldIndicateEmptySignalWhenSecondsAreEmpty() {
        final String second = new String("");

        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(second);

        assertEquals(actualFormatted, IChronologicalFormat.VOID_FORMAT, "Should have returned void format.");
    }

    public void shouldIndicateEmptySignalWhenSecondsAreNull() {
        final IChronologicalFormat actualFormatted = chronologicalFormatter.formatMinute(null);

        assertEquals(actualFormatted, IChronologicalFormat.VOID_FORMAT, "Should have returned void format.");
    }
}
