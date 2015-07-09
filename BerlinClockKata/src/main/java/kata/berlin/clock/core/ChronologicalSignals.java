package kata.berlin.clock.core;

/**
 * Created by Thomas on 7/6/2015.
 */
public enum ChronologicalSignals {
    RED("R"), YELLOW("Y"), OFF("O");

    private String signal;

    ChronologicalSignals(String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }
}
