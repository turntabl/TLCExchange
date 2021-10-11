package com.company;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getID() {
        return ID;
    }

    private static int totalCount = 0;

    private int ID;

    public Map<String, Double> getShares() {
        return shares;
    }

    private Map<String, Double> shares = new HashMap<String, Double>();

    public double getBalance() {
        return balance;
    }

    public void addShares(String ticker, Double qty) {
        shares.put(ticker, shares.getOrDefault(ticker,0.0)+qty);
    }

    public Boolean deposit(Double amount) {
        // TODO: Fix this for <0 amounts
        balance += amount;
        return true;
    }

    public Boolean withdraw(Double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    private double balance = 0.0;

    public Client(String name) {
        this.name = name;
        ID = totalCount++;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                "shares=" + shares +
                '}';
    }

}
