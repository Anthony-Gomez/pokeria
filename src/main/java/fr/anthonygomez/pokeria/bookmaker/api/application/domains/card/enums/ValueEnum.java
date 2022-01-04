package fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums;

public enum ValueEnum {

    TWO("two", "2", 2),
    THREE("three", "3", 3),
    FOUR("four", "4", 4),
    FIVE("five", "5", 5),
    SIX("six", "6", 6),
    SEVEN("seven", "7", 7),
    EIGHT("eight", "8", 8),
    NINE("nine", "9", 9),
    TEN("ten", "10", 10),
    JACK("jack", "J", 11),
    QUEEN("queen", "Q", 12),
    KING("king", "K", 13),
    ACE("ace", "A", 14);

    private final String name;
    private final String symbol;
    private final int rank;

    ValueEnum(String name, String symbol, int rank) {
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "ValueEnum{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank=" + rank +
                '}';
    }
}
