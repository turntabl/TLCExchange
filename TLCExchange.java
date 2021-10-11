package com.company;

public class TLCExchange implements Exchange {
    public TLCExchange() {

    }

    public Boolean executeTrade(Client c, Trade t) {
        Double totalPrice = getPrice(t.getTicker()) * t.getQty();
        if (t.getSide() == Trade.TradeSide.BUY) {
            if (totalPrice <= c.getBalance()) {
                c.withdraw(totalPrice);
                c.addShares(t.getTicker(), t.getQty());
                return true;
            } else {
                System.out.println("Insufficient funds!");
                return false;
            }
        }

        if (t.getSide() == Trade.TradeSide.SELL &&
                c.getShares().getOrDefault(t.getTicker(),0.0) >= t.getQty()) {

            c.addShares(t.getTicker(), -t.getQty());
            c.deposit(t.getQty()*getPrice(t.getTicker()));
            return true;
        } else {
            System.out.println("Insufficient Shares");
            return false;
        }
    }

    public Double getPrice(String ticker) {
        return 15.0;
    }
}
