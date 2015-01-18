package module;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int id;
    private List<Item> items;

    public Cart() {

	items = new ArrayList<Item>();
    }

    public int getId() {
	return id;
    }

    public List<Item> getItems() {
	return items;
    }

    public void addItem(Item item) {
	this.items.add(item);
    }
}
