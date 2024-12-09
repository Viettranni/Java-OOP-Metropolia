package entity;

import jakarta.persistence.*;

// This package contains the entity classes. Using MVC terms, this constitutes the MODEL.

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double amount;
    // Many transactions can be made for the currency
    @ManyToOne
    private Currency currency;

    public Transaction() {
    }

    public Transaction(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
}

