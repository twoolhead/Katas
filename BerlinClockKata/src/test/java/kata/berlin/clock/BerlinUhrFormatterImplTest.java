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

@Test
public class BerlinUhrFormatterImplTest {

    private IChronologicalFormatter chronologicalFormatter;

    @BeforeMethod
    public void beforeMethod() {
        chronologicalFormatter = new BerlinUhrFormatterImpl();
    }

    public void shouldFormatSecondsSignal() {
        final String second = new String("22");

        final List<Signals> actualSignal = chronologicalFormatter.formatSecond(second);

        assertEquals(actualSignal.size(), 1, "There should only be one Signal in here.");
        assertEquals(actualSignal, Arrays.asList(Signals.RED), "There should only be a RED Signal in here -> R.");
    }
}
