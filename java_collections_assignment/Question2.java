import java.util.*;

class Question2 {
    private String id;
    private String name;
    private String category;
    private double price;

    public Question2(String id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question2)) return false;
        Question2 product = (Question2) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question2{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", category='" + category + '\'' +
               ", price=" + price +
               '}';
    }
}

class Question2Catalog {
    private Map<Question2, Integer> catalog = new HashMap<>();

    public boolean addQuestion2(Question2 product, int quantity) {
        if (catalog.containsKey(product)) {
            System.out.println("Question2 ID already exists.");
            return false;
        }
        catalog.put(product, quantity);
        return true;
    }

    public boolean updateQuestion2(String id, String name, String category, double price, int quantity) {
        for (Question2 p : catalog.keySet()) {
            if (p.getId().equals(id)) {
                p.setName(name);
                p.setCategory(category);
                p.setPrice(price);
                catalog.put(p, quantity);
                return true;
            }
        }
        return false;
    }

    public boolean deleteQuestion2(String id) {
        Question2 toRemove = null;
        for (Question2 p : catalog.keySet()) {
            if (p.getId().equals(id)) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            catalog.remove(toRemove);
            return true;
        }
        return false;
    }

    public Question2 getQuestion2(String id) {
        for (Question2 p : catalog.keySet()) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void listQuestion2sSortedBy(String criteria) {
        List<Map.Entry<Question2, Integer>> productList = new ArrayList<>(catalog.entrySet());

        switch (criteria) {
            case "id":
                productList.sort(Comparator.comparing(e -> e.getKey().getId()));
                break;
            case "name":
                productList.sort(Comparator.comparing(e -> e.getKey().getName()));
                break;
            default:
                System.out.println("Invalid sort criteria.");
                return;
        }

        for (Map.Entry<Question2, Integer> entry : productList) {
            System.out.println(entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
    public class Main {
    public static void main(String[] args) {
        Question2Catalog catalog = new Question2Catalog();

        catalog.addQuestion2(new Question2("p001", "apple", "fruit", 0.50), 100);
        catalog.addQuestion2(new Question2("p002", "banana", "fruit", 0.30), 150);

        catalog.updateQuestion2("p002", "banana", "fruit", 0.35, 140);

        catalog.listQuestion2sSortedBy("name");

        catalog.deleteQuestion2("p001");

        System.out.println("After deletion:");
        catalog.listQuestion2sSortedBy("id");
    }
}

}
