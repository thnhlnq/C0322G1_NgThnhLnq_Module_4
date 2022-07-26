package borrow_book.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int codeBook;

    @OneToMany(mappedBy = "borrower")
    private List<Book> book;

    public Borrower() {
    }

    public Borrower(int id, String name, int codeBook) {
        this.id = id;
        this.name = name;
        this.codeBook = codeBook;
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

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }
}
