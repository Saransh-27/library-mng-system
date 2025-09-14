import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple Library Management System that allows users to issue books, return books,
 * and view the library inventory.
 */
public class tut104 {
    // List to store available books
    private static final ArrayList<String> books = new ArrayList<>();
    // List to store issued books
    private static final ArrayList<String> issuedBooks = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize the library with some books
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
        books.add("The Catcher in the Rye");

        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            System.out.println("Welcome to the Library Management System");

            do {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. View Available Books");
                System.out.println("2. Issue a Book");
                System.out.println("3. Return a Book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1: viewBooks();
                    case 2: issueBook(sc);
                    case 3: returnBook(sc);
                    case 4: System.out.println("Exiting the Library Management System. Goodbye!");
                    default: System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 4);
        }
    }

    /**
     * Displays the list of available books in the library.
     */
    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books are currently available in the library.");
        } else {
            System.out.println("Available Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    /**
     * Allows the user to issue a book from the library.
     * 
     * @param sc Scanner object for user input
     */
    private static void issueBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books are available to issue.");
            return;
        }

        System.out.println("Enter the name of the book you want to issue:");
        String bookName = sc.nextLine();

        if (books.contains(bookName)) {
            books.remove(bookName);
            issuedBooks.add(bookName);
            System.out.println("You have successfully issued the book: " + bookName);
        } else {
            System.out.println("The book \"" + bookName + "\" is not available in the library.");
        }
    }

    /**
     * Allows the user to return a book to the library.
     * 
     * @param sc Scanner object for user input
     */
    private static void returnBook(Scanner sc) {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books have been issued.");
            return;
        }

        System.out.println("Enter the name of the book you want to return:");
        String bookName = sc.nextLine();

        if (issuedBooks.contains(bookName)) {
            issuedBooks.remove(bookName);
            books.add(bookName);
            System.out.println("You have successfully returned the book: " + bookName);
        } else {
            System.out.println("The book \"" + bookName + "\" was not issued.");
        }
    }
}