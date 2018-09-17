package com.brothersoft.data.entity.responses.country;

import com.brothersoft.data.entity.responses.DataModel;

public class CurrencyResponse implements DataModel {
    private String code;
    private String name;
    private String symbol;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

}
