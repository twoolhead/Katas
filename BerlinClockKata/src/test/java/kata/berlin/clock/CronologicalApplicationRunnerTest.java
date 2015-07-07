package kata.berlin.clock;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Thomas on 7/6/2015.
 */
@Test
public class CronologicalApplicationRunnerTest {

    public void shouldReturnTimeInBerlinUhrFormat() {
        final ICronologicalFormatter cronologicalFormatter = new BerlinUhrFormatterImpl();
        final ICronologicalInstrument cronologicalInstrument = new BerlinWallClockImpl("", cronologicalFormatter);

        final ITime berlinUhrTime = cronologicalInstrument.displayCompleteTime();
        final String actualTime = berlinUhrTime.getTime();

        assertEquals(actualTime, "RYO");
    }

}
