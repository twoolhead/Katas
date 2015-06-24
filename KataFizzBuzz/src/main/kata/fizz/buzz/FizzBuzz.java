package kata.fizz.buzz;

/**
 * Created by Thomas on 6/12/2015.
 */
public enum FizzBuzz {
    FIZZ_BUZZ("fizzbuzz", 15), BUZZ("buzz", 5), FIZZ("fizz", 3);

    private final String fizzBuzz;
    private final int catalyst;

    FizzBuzz(String fizzBuzz, int catalyst) {
        this.fizzBuzz = fizzBuzz;
        this.catalyst = catalyst;
    }

    public boolean isCorrectCatalyst(int catalyst) {
        return (catalyst % this.catalyst == 0);
    }

    public String getFizzBuzz() {
        return fizzBuzz;
    }

    public int getCatalyst() {
        return catalyst;
    }
}
