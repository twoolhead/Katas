package kata.berlin.clock;

import kata.berlin.clock.chronologic.BerlinWallClockImpl;
import kata.berlin.clock.chronologic.IChronologicalInstrument;
import kata.berlin.clock.core.ITime;
import kata.berlin.clock.formatter.BerlinUhrFormatterImpl;
import kata.berlin.clock.formatter.IChronologicalFormatter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Thomas on 7/6/2015.
 */
@Test
public class CronologicalApplicationRunnerTest {

    public void shouldReturnTimeInBerlinUhrFormat() {
        final IChronologicalFormatter cronologicalFormatter = new BerlinUhrFormatterImpl();
        final IChronologicalInstrument cronologicalInstrument = new BerlinWallClockImpl("11:53:56", cronologicalFormatter);

        final ITime berlinUhrTime = cronologicalInstrument.displayCompleteTime();
        final String actualTime = berlinUhrTime.getTime();

        assertEquals(actualTime, "R:RROO:ROOO:YYRYYRYYRYO:RRRO");
    }

}
