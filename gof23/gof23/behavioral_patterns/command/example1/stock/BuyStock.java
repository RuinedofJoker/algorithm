package gof23.behavioral_patterns.command.example1.stock;

import gof23.behavioral_patterns.command.example1.Order;

public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
