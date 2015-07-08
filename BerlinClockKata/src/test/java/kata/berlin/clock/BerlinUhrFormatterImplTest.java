package kata.berlin.clock;

/**
 * Created by Thomas on 7/6/2015.
 */

import kata.berlin.clock.core.Signals;
import kata.berlin.clock.formatter.BerlinUhrFormatterImpl;
import kata.berlin.clock.formatter.IChronologicalFormatter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class BerlinUhrFormatterImplTest {

    private IChronologicalFormatter chronologicalFormatter;

    @BeforeMethod
    public void beforeMethod() {
        chronologicalFormatter = new BerlinUhrFormatterImpl();
    }

    public void shouldIndicateRedSignalWhenSecondsAreEven() {
        final String second = new String("22");

        final List<Signals> actualSignal = chronologicalFormatter.formatSecond(second);

        assertFalse(actualSignal.isEmpty(), "Signal list should not be empty, unless there was an error.");
        assertEquals(actualSignal.size(), 1, "Incorrect number of Signals.");
        assertEquals(actualSignal, Arrays.asList(Signals.RED), "There should only be a RED Signal in here -> R.");
    }

    public void shouldIndicateOffSignalWhenSecondsAreOdd() {
        final String second = new String("15");

        final List<Signals> actualSignal = chronologicalFormatter.formatSecond(second);

        assertFalse(actualSignal.isEmpty(), "Signal list should not be empty, unless there was an error.");
        assertEquals(actualSignal.size(), 1, "Incorrect number of Signals.");
        assertEquals(actualSignal, Arrays.asList(Signals.OFF), "There should only be OFF Signal in here -> O.");
    }

    public void shouldIndicateEmptySignalWhenSecondsAreEmpty() {
        final String second = new String("");

        final List<Signals> actualSignal = chronologicalFormatter.formatSecond(second);

        assertTrue(actualSignal.isEmpty(), "Signal list should be empty, if the seconds are empty.");
    }

    public void shouldIndicateEmptySignalWhenSecondsAreNull() {
        final List<Signals> actualSignal = chronologicalFormatter.formatSecond(null);

        assertTrue(actualSignal.isEmpty(), "Signal list should be empty, if the seconds are null.");
    }

    public void shouldIndicateCorrectSignalsForFiveMinuteInterval() {
        final String minute = new String("5");

        final List<Signals> actualSignal = chronologicalFormatter.formatMinute(minute);

        assertFalse(actualSignal.isEmpty(), "Signal list should not be empty, unless there was an error.");
        assertEquals(actualSignal.size(), 11, "Incorrect number of Signals.");
        assertEquals(actualSignal, BerlinClockMotherResults.FIVE_MINUTES);
    }

    public void shouldIndicateCorrectSignalsForTwentyMinuteInterval() {
        final String minute = new String("20");

        final List<Signals> actualSignal = chronologicalFormatter.formatMinute(minute);

        assertFalse(actualSignal.isEmpty(), "Signal list should not be empty, unless there was an error.");
        assertEquals(actualSignal.size(), 11, "Incorrect number of Signals.");
        assertEquals(actualSignal, BerlinClockMotherResults.FIVE_MINUTES);
    }
}
