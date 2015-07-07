package kata.berlin.clock.core;

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
    public static boolean timeIsNullOrEmpty(final String timeComponent) {
        return (Objects.isNull(timeComponent) || timeComponent.trim().length() == 0);
    }
}
