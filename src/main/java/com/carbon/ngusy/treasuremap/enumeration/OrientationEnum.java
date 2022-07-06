package com.carbon.ngusy.treasuremap.enumeration;

public enum OrientationEnum {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('O');

    private final char symbol;
    private static OrientationEnum[] values = values();

    OrientationEnum(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get symbol of the associated OrientationEnum
     * @return symbol
     */
    public String getSymbol() {
        return String.valueOf(this.symbol);
    }

    /**
     * Get OrientationEnum by symbol
     * @param symbol
     * @return OrientationEnum
     */
    public static OrientationEnum getBySymbol(String symbol) {
        for(OrientationEnum orientation : values()) {
            if(orientation.getSymbol().equals(symbol))
                return orientation;
        }

        throw new IllegalArgumentException(symbol + " is not a valid OrientationEnum");
    }

    public OrientationEnum right() {
        return values[(this.ordinal() + 1) % OrientationEnum.values.length];
    }

    public OrientationEnum left() {
        return values[(this.ordinal() - 1 + OrientationEnum.values.length) % OrientationEnum.values.length];
    }

    @Override
    public String toString() {
        return "OrientationEnum{" +
                "symbol=" + symbol +
                '}';
    }
}
