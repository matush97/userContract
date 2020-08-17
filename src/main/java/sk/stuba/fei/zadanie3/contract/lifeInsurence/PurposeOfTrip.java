package sk.stuba.fei.zadanie3.contract.lifeInsurence;

public enum PurposeOfTrip {
    WORK(1),
    RECREATIONAL(2),
    SPORT(3);

    private int value;

    PurposeOfTrip(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PurposeOfTrip{" +
                "value=" + value +
                '}';
    }
}
