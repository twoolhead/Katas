package kata.berlin.clock.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Thomas on 7/7/2015.
 */
public enum DefaultSignals {
    ONE_MINUTE(1, 4, Signals.OFF), FIVE_MINUTE(5, 11, Signals.OFF);

    private Signals fill;
    private int value;
    private int size;

    DefaultSignals(int value, int size, Signals fill) {
        this.value = value;
        this.size = size;
        this.fill = fill;
    }

    public List<Signals> createDefaultSignal() {
        List<Signals> defaultSignal = Arrays.asList(new Signals[this.size]);
        Collections.fill(defaultSignal, this.fill);
        return defaultSignal;
    }

    public Signals getFill() {
        return fill;
    }

    public int getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }
}
