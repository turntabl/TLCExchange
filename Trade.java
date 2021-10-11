package com.company;

public class Trade {
    public enum TradeStatus {
        READY, EXECUTED, CANCELLED
    }

    public enum TradeSide {
        BUY, SELL
    }

    public String getTicker() {
        return ticker;
    }

    public Double getQty() {
        return qty;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public TradeSide getSide() {
        return side;
    }

    private String ticker;
    private Double qty;
    private TradeStatus status;
    private TradeSide side;

    @Override
    public String toString() {
        return "Trade{" +
                "ticker='" + ticker + '\'' +
                ", qty=" + qty +
                ", status=" + status +
                ", side=" + side +
                '}';
    }

    public Trade(String ticker, Double qty, TradeSide side) {
        this.ticker = ticker;
        this.qty = qty;
        this.status = TradeStatus.READY;
        this.side = side;
    }
}
