package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {
    private final List<T> items;

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
        return new ArrayList<>(items); // return a copy to prevent external modification
    }

    // Find first item matching a predicate
    public T find(Predicate<T> condition) {
        return items.stream().filter(condition).findFirst().orElse(null);
    }

    // Get all items matching a condition
    public List<T> filter(Predicate<T> condition) {
        return items.stream().filter(condition).collect(Collectors.toList());
    }

    // Clear all items
    public void clear() {
        items.clear();
    }
}
