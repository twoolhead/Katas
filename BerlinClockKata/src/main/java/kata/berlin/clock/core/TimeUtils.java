package kata.berlin.clock.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Thomas on 7/6/2015.
 */
public class TimeUtils {
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
        return (Objects.isNull(component) || component.trim().length() == 0);
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
    public static List<Signals> createAndFillSignalRepresentation(int size, Signals fillSignal) {
        List<Signals> defaultSignal = Arrays.asList(new Signals[size]);
        Collections.fill(defaultSignal, fillSignal);
        return defaultSignal;
    }
}
