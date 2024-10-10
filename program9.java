import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Book
class Book {
    private String title;
    private String author;
    private boolean isLent;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isLent = false;
    }

    // Getter methods for title, author and availability status
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isLent() {
        return isLent;
    }

    // Methods to lend and return the book
    public void lendBook() {
        if (!isLent) {
            isLent = true;
        } else {
            System.out.println("Book is already lent out.");
        }
    }

    public void returnBook() {
        if (isLent) {
            isLent = false;
        } else {
            System.out.println("Book was not lent out.");
        }
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + (!isLent));
    }
}

// Class representing the Library
class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a new book to the library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book '" + title + "' by " + author + " added.");
    }

    // Method to lend a book
    public void lendBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isLent()) {
                    book.lendBook();
                    System.out.println("Book '" + title + "' has been lent.");
                } else {
                    System.out.println("Book '" + title + "' is already lent.");
                }
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the library.");
    }

    // Method to return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isLent()) {
                    book.returnBook();
                    System.out.println("Book '" + title + "' has been returned.");
                } else {
                    System.out.println("Book '" + title + "' was not lent.");
                }
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in the library.");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Library Inventory:");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }
}

// Main class to interact with the Library system
public class program9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Lend Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            
