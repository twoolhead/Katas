package kata.berlin.clock.core;

import java.util.*;

/**
 * Created by Thomas on 7/6/2015.
 */
public class ChronologicalUtils {
    private static final int THREE = 3;

    /*
        Time structure predicate.
     */
    public static void timeIsCorrectStructure(final String[] components) {
        if (components.length != THREE) {
            throw new IllegalArgumentException("There should be at least three components for the time conversion, HH/MM/SS");
        }
    };

    /*
        Time component is not null or not empty.
     */
    public static boolean timeIsNullOrEmpty(final String component) {
        return Optional.ofNullable(component)
                .map(String::trim)
                .filter((s) -> s.length() > 0)
                .isPresent();
    }

    /*
        Time component divisible by some number.
     */
    public static boolean isDivisibleBy(final int two, final String component) {
        return (Integer.parseInt(component) % two) == 0;
    }

    /*
        Factory method for default signal representations.
    */
    public static List<ChronologicalSignals> createAndFillSignalRepresentation(int size, ChronologicalSignals fillSignal) {
        List<ChronologicalSignals> defaultSignal = Arrays.asList(new ChronologicalSignals[size]);
        Collections.fill(defaultSignal, fillSignal);
        return defaultSignal;
    }
}
