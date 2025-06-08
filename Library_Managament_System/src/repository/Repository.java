package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {
   final List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    // Add item
    public void add(T item) {
        items.add(item);
    }

    // Remove item
    public void remove(T item) {
        items.remove(item);
    }

    // Get all items
    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    //finding the first item that matches the given condition.
    public T find(Predicate<T> condition) {
        return items.stream().filter(condition).findFirst().orElse(null);
    }

    //predicate -  it takes an input of type T and returns a boolean.
    // Get all items matching a condition
    public List<T> filter(Predicate<T> condition) {
        return items.stream().filter(condition).collect(Collectors.toList());
    }

    //this is inbuilt feature of java for clearing for clearing the list
    // Clear all items
    public void clear() {
        items.clear();
    }
}
