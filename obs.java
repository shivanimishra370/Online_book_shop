import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private ArrayList<Book> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Book book) {
        items.add(book);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Book item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public ArrayList<Book> getItems() {
        return items;
    }
}

public class obs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Welcome to the Online Book Store!");
            System.out.println("1. Add Book to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Book newBook = new Book(title, author, price);
                    cart.addItem(newBook);
                    System.out.println("Book added to cart.");
                    break;

                case 2:
                    System.out.println("Items in cart:");
                    for (Book item : cart.getItems()) {
                        System.out.println(item.getTitle() + " by " + item.getAuthor() + " - $" + item.getPrice());
                    }
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;

                case 3:
                    double total = cart.calculateTotal();
                    System.out.println("Total: $" + total);
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
