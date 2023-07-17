package gof23.creational_pattern.builder.example1.meal;

import gof23.creational_pattern.builder.example1.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item i : items) {
            cost += i.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item i : items) {
            System.out.println("==========================");
            System.out.print("Item : " + i.name());
            System.out.print(", Packing : " + i.packing().pack());
            System.out.println(", Price : " + i.price());
            System.out.println("==========================");
        }
    }
}
