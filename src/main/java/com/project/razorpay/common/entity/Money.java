package com.project.razorpay.common.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;


@Embeddable
public class Money {

    private int amountUnits;
    private String currency;

    private Money(int amountUnits, String currency) {
        this.amountUnits = amountUnits;
        this.currency = currency;
    }

    public Money of(int amountUnits) {
        return new Money(amountUnits,"INR");
    }

    private Money inr(int amountUnits, String currency) {
        return new Money(amountUnits, currency);
    }

    public Money add(Money other){
        if(!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("cannot add Money with different currency");
        }
        return new Money(this.amountUnits + other.amountUnits, this.currency);
    }

    public Money subtract(Money other){
        if(!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("cannot subtract Money with different currency");
        }
        return new Money(this.amountUnits - other.amountUnits, this.currency);
    }
}
