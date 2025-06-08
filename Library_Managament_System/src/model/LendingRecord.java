package model;

import java.time.LocalDate;

public class LendingRecord {

    String recordId;
    Book book;
    Member member;
     LocalDate issueDate;
     LocalDate dueDate;
     LocalDate returnDate=null;
     static int counter = 1;

     //here storing record id as LR1, LR2 and so on
    //as records will increase the counter will also increase
    public LendingRecord(Book book, Member member, LocalDate issueDate, LocalDate dueDate) {
        this.recordId = "LR" + (counter++); //here LR means Lending Record
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LendingRecord{" +
                "recordId='" + recordId + '\'' +
                ", book=" + book +
                ", member=" + member +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
