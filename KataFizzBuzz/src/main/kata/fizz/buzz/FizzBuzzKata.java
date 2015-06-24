package kata.fizz.buzz;

/**
 * Created by Thomas on 6/12/2015.
 */
public class FizzBuzzKata {

    public String determineFizzBuzzOutcome(int catalyst) {
        if (catalyst < 0) {
            return Integer.toString(catalyst);
        }

        for (FizzBuzz fizzBuzz : FizzBuzz.values()) {
            if (fizzBuzz.isCorrectCatalyst(catalyst)) {
                return fizzBuzz.getFizzBuzz();
            }
        }

        return Integer.toString(catalyst);
    }
}
