package sk.stuba.fei.zadanie3.contract.lifeInsurence;

public enum TerritorialValidity {
    SLOVAKIA(1),
    WORLD(2),
    SLOVAKIA_WORLD(3);

    private int value;

    TerritorialValidity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TerritorialValidity{" +
                "value=" + value +
                '}';
    }
}
