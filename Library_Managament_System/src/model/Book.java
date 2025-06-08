package model;
import java.util.*;

public class Book implements Comparable<Book>{
    String bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(String bookId,  String title, String author) {
        this.bookId = bookId;
        this.title=title;
        this.author=author;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isIssued=" + isIssued +
                '}';
    }
    @Override
    public int compareTo(Book other) {
        return this.bookId.compareToIgnoreCase(other.bookId);
    }
}
