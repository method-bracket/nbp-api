package com.example.nbp_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Contains information about the exchange rate.")
public class Rate {
    @Schema(description = "The rate's number")
    private String no;
    @Schema(description = "The rate's effective date.")
    private String effectiveDate;
    @Schema(description = "The rate's average.")
    private double mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid=" + mid +
                '}';
    }
}
