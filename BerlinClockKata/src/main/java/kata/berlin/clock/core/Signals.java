package kata.berlin.clock.core;

/**
 * Created by Thomas on 7/6/2015.
 */
public enum Signals {
    RED("R"), YELLOW("Y"), OFF("O");

    private String signal;

    Signals(String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }
}
