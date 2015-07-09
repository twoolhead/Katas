package kata.berlin.clock.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Thomas on 7/7/2015.
 */
public enum DefaultChronolgicalSignals {
    ONE_MINUTE(1, 4, ChronologicalSignals.OFF), FIVE_MINUTE(5, 11, ChronologicalSignals.OFF);

    private ChronologicalSignals fill;
    private int value;
    private int size;

    DefaultChronolgicalSignals(int value, int size, ChronologicalSignals fill) {
        this.value = value;
        this.size = size;
        this.fill = fill;
    }

    public List<ChronologicalSignals> createDefaultSignal() {
        List<ChronologicalSignals> defaultSignal = Arrays.asList(new ChronologicalSignals[this.size]);
        Collections.fill(defaultSignal, this.fill);
        return defaultSignal;
    }

    public ChronologicalSignals getFill() {
        return fill;
    }

    public int getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }
}
