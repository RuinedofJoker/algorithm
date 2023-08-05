package gof23.behavioral_patterns.command.example1;

import gof23.behavioral_patterns.command.example1.stock.BuyStock;
import gof23.behavioral_patterns.command.example1.stock.SellStock;
import gof23.behavioral_patterns.command.example1.stock.Stock;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();

        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
