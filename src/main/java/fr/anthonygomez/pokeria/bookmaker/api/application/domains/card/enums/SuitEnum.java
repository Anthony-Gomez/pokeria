package fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums;

public enum SuitEnum {

    HEART("heart", "♥", "H"),
    SPADE("spade", "♠", "S"),
    CLUB("club", "♣", "C"),
    DIAMOND("diamond", "♦", "D");

    private final String name;
    private final String symbol;
    private final String initial;

    SuitEnum(String name, String symbol, String initial) {

        this.name = name;
        this.symbol = symbol;
        this.initial = initial;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getInitial() {
        return initial;
    }

    @Override
    public String toString() {
        return "SuiteEnum{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", initial='" + initial + '\'' +
                '}';
    }
}
