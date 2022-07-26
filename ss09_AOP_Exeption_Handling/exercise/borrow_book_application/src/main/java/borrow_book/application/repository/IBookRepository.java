package borrow_book.application.repository;

import borrow_book.application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query(value = "update book set amount = amount - 1 where id = :id", nativeQuery = true)
    void borrow(@Param("id") int id);

    @Modifying
    @Query(value = "update book set amount = amount + 1 where id = :id", nativeQuery = true)
    void pay(@Param("id") int id);

//    @Query(value = " select * from book where name like :name ", nativeQuery = true)
//    Page<Book> findAll(Pageable pageable, @Param("name") String name);
}
