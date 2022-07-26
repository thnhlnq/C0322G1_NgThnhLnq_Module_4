package borrow_book.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int amount;

    @OneToMany(mappedBy = "book")
    private List<Borrower> borrower;

    public Book() {
    }

    public Book(int id, String name, int amount, List<Borrower> borrower) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.borrower = borrower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Borrower> getBorrower() {
        return borrower;
    }

    public void setBorrower(List<Borrower> borrower) {
        this.borrower = borrower;
    }
}
