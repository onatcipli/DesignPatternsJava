package week_03_Iterator;

import java.util.ArrayList;
import java.util.List;

public class SE311_Week03Iterator {

    public static void main(String[] args) {

        Collection itemCollection = new Collection();
        Item item0 = new Item("item  0");
        Item item1 = new Item("item  1");
        Item item2 = new Item("item  2");
        Item item3 = new Item("item  3");
        Item item4 = new Item("item  4");
        Item item5 = new Item("item  5");
        Item item6 = new Item("item  6");
        Item item7 = new Item("item  7");
        Item item8 = new Item("item  8");


        System.out.println("Adding items to collection...");

        itemCollection.add(item0);
        itemCollection.add(item1);
        itemCollection.add(item2);
        itemCollection.add(item3);
        itemCollection.add(item4);
        itemCollection.add(item5);
        itemCollection.add(item6);
        itemCollection.add(item7);
        itemCollection.add(item8);

        AbstractIterator oddIterator = itemCollection.createIterator("odd");

        oddIterator.display();
        AbstractIterator evenIterator = itemCollection.createIterator("even");

        evenIterator.display();
    }
}


interface AbstractAggregate {
    AbstractIterator createIterator(String type);

    void add(Item item);

    int getCount();

    Item get(int index);
}

class Collection implements AbstractAggregate {
    List<Item> itemList;

    Collection() {
        itemList = new ArrayList<>();
    }

    @Override
    public AbstractIterator createIterator(String type) {
        if (type.equals("odd")) {
            return new OddItemIterator(this);
        } else {
            return new EvenItemIterator(this);

        }
    }

    @Override
    public void add(Item item) {
        itemList.add(item);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item get(int index) {
        return itemList.get(index);
    }
}

class Item {
    public Item(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface AbstractIterator {
    void first();

    void next();

    boolean isDone();

    Item currentItem();

    void display();
}

class OddItemIterator implements AbstractIterator {
    private int index;
    Collection itemCollection;

    public OddItemIterator(Collection itemCollection) {
        this.itemCollection = itemCollection;
        System.out.println("Odd iterator Created");
    }

    /**
     * Since it is odd iterator we will begin from the the most small odd number (1)
     */
    @Override
    public void first() {
        index = 1;
    }

    @Override
    public void next() {
        index += 2;
    }

    @Override
    public boolean isDone() {
        return itemCollection.getCount() > index;
    }

    @Override
    public Item currentItem() {
        return itemCollection.get(index);
    }

    @Override
    public void display() {
        for (first(); isDone(); next()) {
            System.out.println("Iterating   : " + currentItem().getName());
        }
    }
}

class EvenItemIterator implements AbstractIterator {
    private int index;
    Collection itemCollection;

    public EvenItemIterator(Collection itemCollection) {
        this.itemCollection = itemCollection;
        System.out.println("Even iterator Created");
    }

    /**
     * Since it is odd iterator we will begin from the the most small even number (1)
     */
    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index += 2;
    }

    @Override
    public boolean isDone() {
        return itemCollection.getCount() > index;
    }

    @Override
    public Item currentItem() {
        return itemCollection.get(index);
    }

    @Override
    public void display() {
        for (first(); isDone(); next()) {
            System.out.println("Iterating   : " + currentItem().getName());
        }
    }
}