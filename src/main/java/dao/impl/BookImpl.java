package dao.impl;

import dao.BookDAO;
import entity.Book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookImpl {
    BookDAO books;

    public BookImpl(BookDAO book) {
        books = book;
    }

    public List<Book> getBooks() throws SQLException, IOException {
        return books.read();
    }
    public void addBooks(Book book) throws SQLException, IOException {
        books.create(book);
    }

    public void updateBooks(int id,Book book) throws SQLException, IOException {
        books.update(id, book);
    }

    public void deleteBooks(int id) throws SQLException, IOException {
        books.delete(id);
    }
}
