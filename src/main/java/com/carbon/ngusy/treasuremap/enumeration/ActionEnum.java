package com.carbon.ngusy.treasuremap.enumeration;

public enum ActionEnum {
    FORWARD('A'),
    RIGHT('D'),
    LEFT('G');

    private final char symbol;

    ActionEnum(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get symbol of the associated ActionEnum
     * @return symbol
     */
    public String getSymbol() {
        return String.valueOf(this.symbol);
    }

    /**
     * Get ActionEnum by symbol
     * @param symbol
     * @return ActionEnum
     */
    public static ActionEnum getBySymbol(String symbol) {
        for(ActionEnum action : values()) {
            if(action.getSymbol().equals(symbol))
                return action;
        }

        throw new IllegalArgumentException(symbol + " is not a valid ActionEnum");
    }

    @Override
    public String toString() {
        return "ActionEnum{" +
                "symbol=" + symbol +
                '}';
    }
}
