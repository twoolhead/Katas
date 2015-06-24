package kata.fizz.buzz;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Thomas on 6/12/2015.
 */
@Test
public class FizzBuzzKataTest {

    @DataProvider(name = "stress")
    public Object[][] catalystProvider() {
        return new Object[][] {
                {10, "buzz"},
                {15, "fizzbuzz"},
                {2, "2"},
                {-2, "-2"},
                {-20, "-20"}
        };
    }

    @Test(dataProvider = "stress")
    public void stressTestFizzBuzzCatalystIdentifier(int catalyst, String expectedFizzBuzz) {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualFizz = fizzBuzzKata.determineFizzBuzzOutcome(catalyst);

        assertEquals(actualFizz, expectedFizzBuzz);
    }

    public void shouldReturnFizzIfCatalystIsDivisibleByThree() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualFizz = fizzBuzzKata.determineFizzBuzzOutcome(6);

        assertEquals(actualFizz, FizzBuzz.FIZZ.getFizzBuzz(), "\"fizz\" should have been returned.");
    }

    public void shouldReturnBuzzIfCatalystIsDivisibleByFive() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualBuzz = fizzBuzzKata.determineFizzBuzzOutcome(20);

        assertEquals(actualBuzz, FizzBuzz.BUZZ.getFizzBuzz(), "\"buzz\" should have been returned.");
    }

    public void shouldReturnFizzBuzzIfCatalystIsDivisibleByFifteen() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualBuzz = fizzBuzzKata.determineFizzBuzzOutcome(15);

        assertEquals(actualBuzz, FizzBuzz.FIZZ_BUZZ.getFizzBuzz(), "\"fizzbuzz\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsIndivisibleByFizzBuzz() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(11);

        final String expectedCatalyst = "11";
        assertEquals(actualCatalyst, expectedCatalyst, "\"11\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsNegative() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(-1);

        final String expectedCatalyst = "-1";
        assertEquals(actualCatalyst, expectedCatalyst, "\"-1\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsNegativeButStillDivisible() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();

        final String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(-20);

        final String expectedCatalyst = "-20";
        assertEquals(actualCatalyst, expectedCatalyst, "\"-20\" should have been returned.");
    }
}
