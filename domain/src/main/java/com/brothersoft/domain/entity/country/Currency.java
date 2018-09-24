package com.brothersoft.domain.entity.country;

import com.brothersoft.domain.entity.DomainModel;


public class Currency implements DomainModel, Comparable<Currency> {
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

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj == null || obj.getClass() != this.getClass()) {
//            return false;
//        }
//        Currency currency = (Currency) obj;
//        if (!code.equals(currency.code)) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + name.hashCode();
//        result = prime * result + code.hashCode();
//        return result;
//    }

    @Override
    public int compareTo(Currency currency) {
        return name.compareTo(currency.getName());
    }
}
