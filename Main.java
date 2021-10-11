package com.company;

import java.util.Scanner;

public class Main {

    public static Exchange exch = new TLCExchange();

    public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
        Client client = new Client("Charlie");
        while (true) {
            System.out.print("Command: ");
            processCommand(client, scn.nextLine());
        }
    }

    public static void processCommand(Client client, String command) {
        if (command.equals("exit")) { System.exit(0); }
        String[] tokens = command.split("\s");
        if (tokens.length == 0) { return; }
        switch(tokens[0]) {
            case "account":
                clientDetails(client);
                break;
            case "portfolio":
                portfolio(client);
                break;
            case "buy":
                buy(client, tokens[1], Double.parseDouble(tokens[2]));
                break;
            case "sell":
                sell(client, tokens[1], Double.parseDouble(tokens[2]));
                break;
            case "deposit":
                deposit(client, Double.parseDouble(tokens[1]));
                break;
            case "withdraw":
                withdraw(client, Double.parseDouble(tokens[1]));
                break;
        }
    }

    public static void clientDetails(Client c) {
        System.out.println("Client name: "+c.getName());
        System.out.println("Client ID: "+c.getID());
        System.out.println("Client Balance: "+c.getBalance());
        System.out.println("Client shares: "+c.getShares());
        System.out.println();
    }

    public static void portfolio(Client c) {

    }

    public static void buy(Client c, String ticker, Double qty) {
        Trade t = new Trade(ticker, qty, Trade.TradeSide.BUY);
        exch.executeTrade(c, t);
    }

    public static void sell(Client c, String ticker, Double qty) {
        Trade t = new Trade(ticker, qty, Trade.TradeSide.SELL);
        exch.executeTrade(c, t);
    }

    public static void deposit(Client c, Double amount) {
        if(c.deposit(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit unsuccessful!");
        }
    }

    public static void withdraw(Client c, Double amount) {
        if (c.withdraw(amount)) {
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("Withdraw unsuccessful!");
        }
    }
}
