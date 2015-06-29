package kata.fizz.buzz;

/**
 * Created by Thomas on 6/25/2015.
 */

public class FizzBuzzKata {
    public FizzBuzzKata() {
    }

    public String determineFizzBuzzOutcome(int catalyst) {
        if(catalyst < 0) {
            return Integer.toString(catalyst);
        } else {
            FizzBuzz[] var2 = FizzBuzz.values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                FizzBuzz fizzBuzz = var2[var4];
                if(fizzBuzz.isCorrectCatalyst(catalyst)) {
                    return fizzBuzz.getFizzBuzz();
                }
            }

            return Integer.toString(catalyst);
        }
    }
}
