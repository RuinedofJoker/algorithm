package gof23.behavioral_patterns.command.example1.stock;

import gof23.behavioral_patterns.command.example1.Order;

public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
