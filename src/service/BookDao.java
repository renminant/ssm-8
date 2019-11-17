package service;


import pojo.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public Boolean RegisterBook(Book book) throws SQLException;
    public List<Book> getBookList(Book book) throws SQLException;
    public boolean updateBook(Book book) throws SQLException;
    public boolean deleteBookByid(Integer book_id) throws SQLException;
    public Book getBookByid(Integer book_id) throws SQLException;
    public List<Book> selectBookByWhere(String name, String author, String borrower) throws SQLException;
    public boolean borrow(Book book)throws Exception;
    public boolean borrowUpdate(Integer book_id)throws Exception;


}
