import java.util.*;
// package java_collections_assignment;
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Product> prodMap = new HashMap<>();

        // Adding initial products
        addInitialProducts(prodMap);

        int choice;
        do {
            System.out.println("\n Menu ");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Sort by Product ID");
            System.out.println("6. Sort by Product Name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (prodMap.containsKey(id)) {
                        System.out.println("Product with ID " + id + " already exists. Duplicate not allowed.");
                        break;
                    }
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    prodMap.put(id, new Product(id, name, category, price));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.println("\nProduct List ");
                    for (Product p : prodMap.values()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    if (!prodMap.containsKey(updateId)) {
                        System.out.println("Product not found.");
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    prodMap.put(updateId, new Product(updateId, newName, newCategory, newPrice));
                    System.out.println("Product updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();
                    if (prodMap.remove(deleteId) != null) {
                        System.out.println("Product deleted.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    List<Product> sortedById = new ArrayList<>(prodMap.values());
                    sortedById.sort(Comparator.comparingInt(Product::getPid));
                    System.out.println("\nProducts Sorted by ID");
                    for (Product p : sortedById) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    List<Product> sortedByName = new ArrayList<>(prodMap.values());
                    sortedByName.sort(Comparator.comparing(Product::getPname));
                    System.out.println("\nProducts Sorted by Name ");
                    for (Product p : sortedByName) {
                        System.out.println(p);
                    }
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void addInitialProducts(Map<Integer, Product> prodMap) {
        prodMap.put(101, new Product(101, "Watch", "Accessories", 1999.0));
        prodMap.put(102, new Product(102, "Shoes", "Footwear", 1459.0));
        prodMap.put(103, new Product(103, "Shirt", "Upperwear", 499.0));
        prodMap.put(104, new Product(104, "Jeans", "Bottomwear", 2999.0));
        prodMap.put(105, new Product(105, "Sunglasses", "Eyewear", 999.0));
        prodMap.put(106, new Product(106, "Iphone", "Mobile", 69999.0));
    }
}

 class Product{
    int pid;
    String pname;
    String category;
    Double price;

    public Product(int pid, String pname, String category, Double price) {
        this.pid = pid;
        this.pname = pname;
        this.category = category;
        this.price = price;
    }

    public int getPid() {
        return this.pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return this.pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPrice() {
        return this.price;
    }
        public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "{" +
            " pid='" + getPid() + "'" +
            ", pname='" + getPname() + "'" +
            ", category='" + getCategory() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return pid == product.pid && Objects.equals(pname, product.pname) && Objects.equals(category, product.category) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pname, category, price);
    }

 }
