package kata.fizz.buzz;

/**
 * Created by Thomas on 6/25/2015.
 */

import kata.fizz.buzz.FizzBuzz;
import kata.fizz.buzz.FizzBuzzKata;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class FizzBuzzKataTest {
    public FizzBuzzKataTest() {
    }

    @DataProvider(
            name = "stress"
    )
    public Object[][] catalystProvider() {
        return new Object[][]{{Integer.valueOf(10), "buzz"}, {Integer.valueOf(15), "fizzbuzz"}, {Integer.valueOf(2), "2"}, {Integer.valueOf(-2), "-2"}, {Integer.valueOf(-20), "-20"}};
    }

    @Test(
            dataProvider = "stress"
    )
    public void stressTestFizzBuzzCatalystIdentifier(int catalyst, String expectedFizzBuzz) {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualFizz = fizzBuzzKata.determineFizzBuzzOutcome(catalyst);
        Assert.assertEquals(actualFizz, expectedFizzBuzz);
    }

    public void shouldReturnFizzIfCatalystIsDivisibleByThree() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualFizz = fizzBuzzKata.determineFizzBuzzOutcome(6);
        Assert.assertEquals(actualFizz, FizzBuzz.FIZZ.getFizzBuzz(), "\"fizz\" should have been returned.");
    }

    public void shouldReturnBuzzIfCatalystIsDivisibleByFive() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualBuzz = fizzBuzzKata.determineFizzBuzzOutcome(20);
        Assert.assertEquals(actualBuzz, FizzBuzz.BUZZ.getFizzBuzz(), "\"buzz\" should have been returned.");
    }

    public void shouldReturnFizzBuzzIfCatalystIsDivisibleByFifteen() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualBuzz = fizzBuzzKata.determineFizzBuzzOutcome(15);
        Assert.assertEquals(actualBuzz, FizzBuzz.FIZZ_BUZZ.getFizzBuzz(), "\"fizzbuzz\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsIndivisibleByFizzBuzz() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(11);
        String expectedCatalyst = "11";
        Assert.assertEquals(actualCatalyst, "11", "\"11\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsNegative() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(-1);
        String expectedCatalyst = "-1";
        Assert.assertEquals(actualCatalyst, "-1", "\"-1\" should have been returned.");
    }

    public void shouldReturnCatalystIfCatalystIsNegativeButStillDivisible() {
        FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
        String actualCatalyst = fizzBuzzKata.determineFizzBuzzOutcome(-20);
        String expectedCatalyst = "-20";
        Assert.assertEquals(actualCatalyst, "-20", "\"-20\" should have been returned.");
    }
}
