import model.*;
import service.libraryService;
import service.overdueMonitor;
import exceptions.*;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        libraryService library = new libraryService();
        Scanner scanner = new Scanner(System.in);

//         Start overdue monitor
        overdueMonitor monitor = new overdueMonitor(library.getLendingRecords());
        monitor.setDaemon(true);
        monitor.start();

//        overdueMonitor.checkOverdueBooks(library.getLendingRecords());


        while (true) {
            System.out.println("\n Library Management Menu ");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Members");
            System.out.println("7. Search Books by Author");
            System.out.println("8. Search Books by Title");
            System.out.println("9. View Sorted Books by Book ID and Title");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 : {
                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(bookId, title, author));
                        System.out.println("Book added successfully.");
                        break;
                    }

                    case 2 : {
                        System.out.print("Enter Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        library.addMember(new Member(memberId, name, email));
                        System.out.println("Member added successfully.");
                        break;
                    }

                    case 3 : {
                        System.out.print("Enter Book ID to issue: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter Member ID: ");
                        String memberId = scanner.nextLine();
                        library.issueBook(bookId, memberId);
                        System.out.println("Book issued successfully.");
                        break;
                    }

                    case 4 : {
                        System.out.print("Enter Book ID to return: ");
                        String bookId = scanner.nextLine();
                        library.returnBook(bookId);
                        System.out.println("Book returned successfully.");
                        break;
                    }

                    case 5 : {
                        System.out.println("All Books:");
                        library.getAllBooks().forEach(System.out::println);
                        break;
                    }

                    case 6 : {
                        System.out.println("All Members:");
                        library.getAllMembers().forEach(System.out::println);
                        break;
                    }

                    case 7 : {
                        System.out.print("Enter author name to search: ");
                        String author = scanner.nextLine();
                        List<Book> foundByAuthor = library.findBooksByAuthor(author);
                        foundByAuthor.forEach(System.out::println);
                        break;
                    }

                    case 8 : {
                        System.out.print("Enter title to search: ");
                        String title = scanner.nextLine();
                        List<Book> foundByTitle = library.findBooksByTitle(title);
                        foundByTitle.forEach(System.out::println);
                        break;
                    }

                    case 9 : {
                        System.out.println("Books sorted by book ID and title:");
                        List<Book> sorted = library.getBooksSortedByTitle();
                        sorted.forEach(System.out::println);
                        break;
                    }

                    case 0 : {
                        System.out.println("Exiting... Goodbye!");
                        return;
                    }

                    default :
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            } catch (bookNotAvailableException | memberNotFoundException | overdureBookException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
