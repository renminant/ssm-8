package service;

import mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import java.sql.SQLException;
import java.util.List;
@Service
public class BookDaoImpl implements BookDao {

    @Autowired
    BookMapper bookMapper;

    @Override
    public Boolean RegisterBook(Book book) throws SQLException {
        return bookMapper.RegisterBook(book);
    }

    @Override
    public List<Book> getBookList(Book book) throws SQLException {
        return bookMapper.getBookList(book);
    }


    @Override
    public boolean updateBook(Book book) throws SQLException {
        return bookMapper.updateBook(book);
    }

    @Override
    public boolean deleteBookByid(Integer book_id) throws SQLException {
        return bookMapper.deleteBookByid(book_id);
    }

    @Override
    public Book getBookByid(Integer book_id) throws SQLException {
        return bookMapper.getBookByid(book_id);
    }

    @Override
    public List<Book> selectBookByWhere(String name, String author, String borrower) throws SQLException {
        return bookMapper.selectBookByWhere(name,author,borrower);
    }

    @Override
    public boolean borrow(Book product) throws Exception {
        return bookMapper.borrow(product);
    }

    @Override
    public boolean borrowUpdate(Integer id) throws Exception {
        return bookMapper.borrowUpdate(id);
    }
}


