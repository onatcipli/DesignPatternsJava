package week_11_observer;

import java.util.ArrayList;

/**
 * Abstract Subject
 */
abstract class Stock {
    private ArrayList<Observer> observers;
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.observers = new ArrayList<Observer>();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers();
    }

    // Subject methods

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
        System.out.println("-------------------------------------------------");
    }
}

/**
 * Generic type for Observers
 * it includes update method, when Subject state change, it notify every observers with update method.
 */
interface Observer {
    public void update(Stock stock);
}

class IBM extends Stock {
    public IBM(String symbol, double price) {
        super(symbol, price);
    }
}

class Investor implements Observer {
    private Stock stock;
    private String investorName;
    private String stockSymbol;
    private double stockPrice;

    Investor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(Stock stock) {
        this.stock = stock;
        stockPrice = stock.getPrice();
        stockSymbol = stock.getSymbol();
        System.out.println(investorName + " " + stockSymbol + " : " + stockPrice);
    }
}

public class SE311_Week11Observer {

    public static void main(String[] args) {

        System.out.println("SE311_Week3Iterator !!");
        Stock ibmStcok = new IBM("IBM", 2000);

        Investor onat = new Investor("onat");
        Investor mirkan = new Investor("mirkan");
        Investor ege = new Investor("ege");

        ibmStcok.attach(onat);
        ibmStcok.attach(mirkan);
        ibmStcok.attach(ege);


        ibmStcok.setPrice(25);
        ibmStcok.setPrice(69);
        ibmStcok.setPrice(123);


        System.out.println("After detach ------------");
        ibmStcok.detach(mirkan);
        ibmStcok.detach(ege);

        ibmStcok.setPrice(222);
    }
}
