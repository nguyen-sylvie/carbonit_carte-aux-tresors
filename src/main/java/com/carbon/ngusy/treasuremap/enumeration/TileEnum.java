package com.carbon.ngusy.treasuremap.enumeration;

public enum TileEnum {
    ADVENTURER('A'),
    MAP('C'),
    MOUNTAIN('M'),
    PLAIN('P'),
    TREASURE('T');

    private final char symbol;

    TileEnum(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get symbol of the associated TileEnum
     * @return symbol
     */
    public String getSymbol() {
        return String.valueOf(this.symbol);
    }

    /**
     * Get TileEnum by symbol
     * @param symbol
     * @return TileEnum
     */
    public static TileEnum getBySymbol(String symbol) {
        for(TileEnum tile : values()) {
            if(tile.getSymbol().equals(symbol))
                return tile;
        }

        throw new IllegalArgumentException(symbol + " is not a valid TileEnum");
    }

    @Override
    public String toString() {
        return "CaseEnum{" +
                "symbol=" + symbol +
                '}';
    }
}
