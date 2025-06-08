package service;

import model.*;
import exceptions.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class libraryService {
    //here storing book id as key and for whole object as value
    private Map<String, Book> books = new HashMap<>();
    //here storing member id as key and whole object as value
    private Map<String, Member> members = new HashMap<>();

    //here i am storing records in the form of object i.e., LendingRecord
    private List<LendingRecord> records = new ArrayList<>();
    private static int counter = 1;
    private String recordId;

    // for adding a book
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    // Remove a book
    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    // Add a member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Remove a member
    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    // Issue a book to a member
    public void issueBook(String bookId, String memberId)
            throws bookNotAvailableException, memberNotFoundException, overdureBookException {

        //this will first take id and then search in hashmap then storing in the form of object
        //if the object is not available then object will store the null value
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        //custom exception 1 : bookNotAvailableException
        if (book == null || book.isIssued()) {
            throw new bookNotAvailableException("Book is not available or already issued.");
        }
        //custom exception 2 : memberNotFoundException
        if (member == null) {
            throw new memberNotFoundException("Member not found.");
        }
        //custom exception 3 : overdureBookException
        if (hasOverdueBooks(memberId)) {
            throw new overdureBookException("Member has overdue books.");
        }

        book.setIssued(true);
        LendingRecord record = new LendingRecord(
                book,
                member,
                LocalDate.now(),
                LocalDate.now().plusDays(14)
        );

        records.add(record);
    }

    // Return a book
    public void returnBook(String bookId) {
        for (LendingRecord record : records) {
            if (record.getBook().getBookId().equals(bookId) && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                record.getBook().setIssued(false);
                break;
            }
        }
    }

    // Check if a member has overdue books
    private boolean hasOverdueBooks(String memberId) {
        return records.stream()
                .anyMatch(r -> r.getMember().getMemberId().equals(memberId)
                        && r.getReturnDate() == null
                        && r.getDueDate().isBefore(LocalDate.now()));
    }

    // Getters (for use in main class or elsewhere)
    public List<LendingRecord> getLendingRecords() {
        return records;
    }

    public List<Book> getBooksSortedByTitle() {
        return books.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Return all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // Return all members
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    // Search books by title
    public List<Book> findBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }



}
