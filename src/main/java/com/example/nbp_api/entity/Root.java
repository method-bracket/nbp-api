package com.example.nbp_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Contains a list of rates for a specific table and currency.")
public class Root {
    @Schema(description = "Contains one of 3 letters specifying the table (A, B or C).")
    private String table;
    @Schema(description = "The full name of the currency.")
    private String currency;
    @Schema(description = "The currency's code (ISO 4217).")
    private String code;
    @Schema(description = "The list of rates.")
    private List<Rate> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Root{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
